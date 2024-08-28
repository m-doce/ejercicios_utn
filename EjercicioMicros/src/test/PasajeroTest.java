package test;

import code.*;
import exceptions.ClaustrofobicoNoSubeException;
import exceptions.FiacaNoSubeException;
import exceptions.ModeradoNoSubeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PasajeroTest {

    private Pasajero instance;
    private Perfil perfil;
    private Micro micro = mock(Micro.class);

    @BeforeEach
    void setUp() {
        instance = new Pasajero("Marco", 1210426, perfil, null);
    }

    @Test
    @DisplayName("Verifica que getNombre funcione")
    void getNombre() {
        assertEquals(instance.getNombre(), "Marco");
    }

    @Test
    @DisplayName("Verifica que setNombre funcione")
    void setNombre() {
        instance.setNombre("Aurelio");
        assertEquals(instance.getNombre(), "Aurelio");

    }

    @Test
    @DisplayName("Verifica que getLegajo funcione")
    void getLegajo() {
        assertEquals(instance.getLegajo(), 1210426);
    }

    @Test
    @DisplayName("Verifica que setLegajo funcione")
    void setLegajo() {
        instance.setLegajo(1800317);
        assertEquals(instance.getLegajo(), 1800317);
    }

    @Test
    @DisplayName("Verifica que getPerfil funcione")
    void getPerfil() {
        assertEquals(instance.getPerfil(), null);
    }

    @Test
    @DisplayName("Verifica que setPerfil funcione")
    void setPerfil() {
        perfil = new Apurado();
        instance.setPerfil(perfil);
        assertEquals(instance.getPerfil(), perfil);
    }

    @Test
    @DisplayName("Verifica que getJefe funcione")
    void getJefe() {
        assertEquals(instance.getJefe(), null);
    }

    @Test
    @DisplayName("Verifica que setJefe funcione")
    void setJefe() {
        Pasajero jefe = mock(Pasajero.class);
        instance.setJefe(jefe);
        assertEquals(instance.getJefe(), jefe);
    }

    @Test
    @DisplayName("Retorna true cuando no tiene asignado un jefe, por lo tanto es jefe")
    void esJefeTrue() {
        assertTrue(instance.esJefe());
    }

    @Test
    @DisplayName("Retorna false cuando tiene asignado un jefe")
    void esJefeFalse() {
        Pasajero jefe = mock(Pasajero.class);
        instance.setJefe(jefe);
        assertFalse(instance.esJefe());
    }

    @Test
    @DisplayName("Verifica quiereSubir con perfil Apurado")
    void quiereSubirApurado() {
            instance.setPerfil(new Apurado());
            assertTrue(instance.quiereSubir(micro));
    }

    @Test
    @DisplayName("Verifica quiereSubir con perfil Moderado")
    void quiereSubirModerado() {
        instance.setPerfil(new Moderado(10));
        when(micro.getLugaresTotalesLibres()).thenReturn(15);
        assertTrue(instance.quiereSubir(micro));

        when(micro.getLugaresTotalesLibres()).thenReturn(5);
        assertThrows(ModeradoNoSubeException.class, () -> {
            instance.quiereSubir(micro);
        });
    }

    @Test
    @DisplayName("Verifica quiereSubir con perfil Fiaca")
    void quiereSubirFiaca() {
        instance.setPerfil(new Fiaca());
        when(micro.getAsientosLibres()).thenReturn(5);
        assertTrue(instance.quiereSubir(micro));

        when(micro.getAsientosLibres()).thenReturn(0);
        assertThrows(FiacaNoSubeException.class, () -> {
            instance.quiereSubir(micro);
        });
    }

    @Test
    @DisplayName("Verifica quiereSubir con perfil Claustrofobico")
    void quiereSubirClaustrofobico() {
        instance.setPerfil(new Claustrofobico());
        when(micro.getVolumen()).thenReturn(150.0);
        assertTrue(instance.quiereSubir(micro));

        when(micro.getVolumen()).thenReturn(115.0);
        assertThrows(ClaustrofobicoNoSubeException.class, () -> {
            instance.quiereSubir(micro);
        });
    }

}