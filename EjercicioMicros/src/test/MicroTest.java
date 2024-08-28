package test;

import code.*;
import exceptions.MicroLlenoException;
import exceptions.MicroVacioException;
import exceptions.NoExistePasajeroException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MicroTest {

    private Micro instance;
    private Pasajero pasajero1 = mock(Pasajero.class);
    private Pasajero pasajero2 = mock(Pasajero.class);
    private Pasajero pasajero3 = mock(Pasajero.class);
    private Pasajero pasajero4 = mock(Pasajero.class);
    private Pasajero pasajero5 = mock(Pasajero.class);
    private Pasajero pasajero6 = mock(Pasajero.class);
    private ArrayList<Pasajero> pasajeros = new ArrayList<>();

    @BeforeEach
    void setUp() {
        instance = new Micro(200.0, 10, 15);
        pasajeros.add(pasajero1);
        pasajeros.add(pasajero2);
        pasajeros.add(pasajero3);
        pasajeros.add(pasajero4);
        pasajeros.add(pasajero5);
        instance.setPasajeros(pasajeros);
    }

    @Test
    @DisplayName("Verifica que getVolumen funcione")
    void getVolumen() {
        assertEquals(instance.getVolumen(), 200.0);
    }

    @Test
    @DisplayName("Verifica que setVolumen funcione")
    void setVolumen() {
        instance.setVolumen(315.0);
        assertEquals(instance.getVolumen(), 315.0);
    }

    @Test
    @DisplayName("Verifica que getCapacidadSentados funcione")
    void getCapacidadSentados() {
        assertEquals(instance.getCapacidadSentados(), 10);
    }

    @Test
    @DisplayName("Verifica que setCapacidadSentados funcione")
    void setCapacidadSentados() {
        instance.setCapacidadSentados(20);
        assertEquals(instance.getCapacidadSentados(), 20);
    }

    @Test
    @DisplayName("Verifica que getCapacidadParados funcione")
    void getCapacidadParados() {
        assertEquals(instance.getCapacidadParados(), 15);
    }

    @Test
    @DisplayName("Verifica que setCapacidadParados funcione")
    void setCapacidadParados() {
        instance.setCapacidadParados(20);
        assertEquals(instance.getCapacidadParados(), 20);
    }

    @Test
    @DisplayName("Retorna la suma de asientos y lugares de pie")
    void getCapacidadTotal() {
        assertEquals(instance.getCapacidadTotal(), 25);
    }

    @Test
    @DisplayName("Verifica que getPasajeros funcione")
    void getPasajeros() {
        assertEquals(instance.getPasajeros(), pasajeros);
    }

    @Test@DisplayName("Verifica que setPasajeros funcione")
    void setPasajeros() {
        ArrayList<Pasajero> pasajeros2 = new ArrayList<>();
        pasajeros2.add(pasajero1);
        instance.setPasajeros(pasajeros2);
        assertEquals(instance.getPasajeros(), pasajeros2);
    }

    @Test
    @DisplayName("Retorna la diferencia entre asientos totales y la cantidad de pasajeros actual")
    void getAsientosLibres() {
        assertEquals(instance.getAsientosLibres(), 5);
    }

    @Test
    @DisplayName("Retorna la diferencia entre lugares de pie totales y la cantidad de pasajeros actual menos los que ocupan asientos")
    void getLugaresParadosLibres() {
        instance.setCapacidadSentados(2);
        assertEquals(instance.getLugaresParadosLibres(), 12);
    }

    @Test
    @DisplayName("Retorna la diferencia entre capacidad total y la cantidad de pasajeros actual")
    void getLugaresTotalesLibres() {
        instance.setCapacidadSentados(3);
        instance.setCapacidadParados(9);
        assertEquals(instance.getLugaresTotalesLibres(), 7);
    }

    @Test
    @DisplayName("Lanza una excepión cuando el micro está lleno y alguien quiere subir")
    void puedeSubirMicroLlenoError() {
        instance.setCapacidadSentados(3);
        instance.setCapacidadParados(2);
        when(pasajero6.getPerfil()).thenReturn(new Apurado());

        assertThrows(MicroLlenoException.class, () -> {
            instance.puedeSubir(pasajero6);
        });
    }

    @Test
    @DisplayName("Da un aviso cuando el micro está lleno y alguien quiere subir")
    void subirPasajeroMicroLlenoError() {
        instance.setCapacidadSentados(3);
        instance.setCapacidadParados(2);
        Pasajero apurado = new Pasajero("Dev", 102030, new Apurado(), null);
        assertEquals(instance.subirPasajero(apurado), "El micro está lleno, espere el próximo.");
    }

    @Test
    @DisplayName("Informa que el pasajero apurado subió sin problemas")
    void subirPasajeroApuradoOK() {
        Pasajero apurado = new Pasajero("Dev", 102030, new Apurado(), null);
        assertEquals(instance.subirPasajero(apurado), "El pasajero subió al micro.");
    }

    @Test
    @DisplayName("Informa que el pasajero moderado no subió")
    void subirPasajeroModeradoError() {
        instance.setCapacidadSentados(5);
        instance.setCapacidadParados(7);
        Pasajero moderado = new Pasajero("Dev", 102030, new Moderado(15), null);
        assertEquals(instance.subirPasajero(moderado), "El moderado no quiere subir.");
    }

    @Test
    @DisplayName("Informa que el pasajero moderado subió sin problemas")
    void subirPasajeroModeradoOK() {
        instance.setCapacidadSentados(15);
        instance.setCapacidadParados(20);
        Pasajero moderado = new Pasajero("Dev", 102030, new Moderado(15), null);
        assertEquals(instance.subirPasajero(moderado), "El pasajero subió al micro.");
    }

    @Test
    @DisplayName("Informa que el pasajero fiaca no subió")
    void subirPasajeroFiacaError() {
        instance.setCapacidadSentados(5);
        Pasajero fiaca = new Pasajero("Dev", 102030, new Fiaca(), null);
        assertEquals(instance.subirPasajero(fiaca), "El fiaca no quiere subir.");
    }

    @Test
    @DisplayName("Informa que el pasajero fiaca subió sin problemas")
    void subirPasajeroFiacaOK() {
        instance.setCapacidadSentados(15);
        Pasajero fiaca = new Pasajero("Dev", 102030, new Fiaca(), null);
        assertEquals(instance.subirPasajero(fiaca), "El pasajero subió al micro.");
    }

    @Test
    @DisplayName("Informa que el pasajero claustrofobico no subió")
    void subirPasajeroClaustrofobicoError() {
        instance.setVolumen(90.0);
        Pasajero claustrofobico = new Pasajero("Dev", 102030, new Claustrofobico(), null);
        assertEquals(instance.subirPasajero(claustrofobico), "El claustrofobico no quiere subir.");
    }

    @Test
    @DisplayName("Informa que el pasajero claustrofobico subió sin problemas")
    void subirPasajeroClaustrofobicoOK() {
        instance.setVolumen(190.0);
        Pasajero claustrofobico = new Pasajero("Dev", 102030, new Claustrofobico(), null);
        assertEquals(instance.subirPasajero(claustrofobico), "El pasajero subió al micro.");
    }

    @Test
    @DisplayName("Lanza una excepión cuando el micro está vacío y alguien quiere bajar")
    void bajarPasajeroMicroVacioError() {
        ArrayList<Pasajero> pasajerosVacio = new ArrayList<>();
        instance.setPasajeros(pasajerosVacio);
        assertThrows(MicroVacioException.class, () -> {
            instance.bajarPasajero(pasajero6);
        });
    }

    @Test
    @DisplayName("Lanza una excepión cuando alguien que no está en el micro quiere bajar")
    void bajarPasajeroNoExistePasajeroError() {
        assertThrows(NoExistePasajeroException.class, () -> {
            instance.bajarPasajero(pasajero6);
        });
    }

    @Test
    @DisplayName("Verifica que se pueda bajar pasajeros")
    void bajarPasajeroOK() {
        instance.bajarPasajero(pasajero5);
        assertEquals(instance.getPasajeros().size(), 4);
    }

    @Test
    @DisplayName("Verifica que getPrimeroEnSubir funcione")
    void getPrimeroEnSubir() {
        assertEquals(instance.getPrimeroEnSubir(), null);
    }

    @Test
    @DisplayName("Verifica que setPrimeroEnSubir guarde el primer pasajero que sube sólo cuando la referencia a este es null")
    void setPrimeroEnSubir() {
        instance.setPrimeroEnSubir(pasajero6);
        assertEquals(instance.getPrimeroEnSubir(), pasajero6);

        instance.setPrimeroEnSubir(pasajero1);
        assertEquals(instance.getPrimeroEnSubir(), pasajero6);
    }

}