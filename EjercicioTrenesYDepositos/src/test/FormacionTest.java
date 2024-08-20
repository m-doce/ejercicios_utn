package test;

import code.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FormacionTest {

    //Creación de los mock objects necesarios para correr los tests
    Locomotora locomotora1 = mock(Locomotora.class);
    Locomotora locomotora2 = mock(Locomotora.class);
    VagonDeCarga vagonCarga1 = mock(VagonDeCarga.class);
    VagonDeCarga vagonCarga2 = mock(VagonDeCarga.class);
    VagonDeCarga vagonCarga3 = mock(VagonDeCarga.class);
    VagonDePasajeros vagonPasajeros1 = mock(VagonDePasajeros.class);
    VagonDePasajeros vagonPasajeros2 = mock(VagonDePasajeros.class);
    VagonDePasajeros vagonPasajeros3 = mock(VagonDePasajeros.class);
    VagonDePasajeros vagonPasajeros4 = mock(VagonDePasajeros.class);
    VagonDePasajeros vagonPasajeros5 = mock(VagonDePasajeros.class);
    ArrayList<Vagon> vagones = new ArrayList<>();
    ArrayList<Locomotora> locomotoras = new ArrayList<>();

    Formacion formacion;


    @BeforeEach
    void setUp() {
        vagones.add(vagonCarga1);
        vagones.add(vagonCarga2);
        vagones.add(vagonCarga3);
        vagones.add(vagonPasajeros1);
        vagones.add(vagonPasajeros2);
        vagones.add(vagonPasajeros3);
        vagones.add(vagonPasajeros4);
        vagones.add(vagonPasajeros5);
        locomotoras.add(locomotora1);
        locomotoras.add(locomotora2);

        formacion = new Formacion(vagones, locomotoras);
    }

    @Test
    @DisplayName("Verifica el funcionamiento del getVagones")
    void getVagones() {
        assertEquals(vagones, formacion.getVagones());
    }

    @Test
    @DisplayName("Verifica el funcionamiento del setVagones")
    void setVagones() {
        ArrayList<Vagon> vagones2 = new ArrayList<>();
        vagones2.add(vagonCarga1);
        vagones2.add(vagonPasajeros1);
        formacion.setVagones(vagones2);
        assertEquals(vagones2, formacion.getVagones());
    }

    @Test
    @DisplayName("Verifica el funcionamiento del getLocomotoras")
    void getLocomotoras() {
        assertEquals(locomotoras, formacion.getLocomotoras());
    }

    @Test
    @DisplayName("Verifica el funcionamiento del setLocomotoras")
    void setLocomotoras() {
        ArrayList<Locomotora> locomotoras2 = new ArrayList<>();
        locomotoras2.add(locomotora1);
        formacion.setLocomotoras(locomotoras2);
        assertEquals(locomotoras2, formacion.getLocomotoras());
    }

    @Test
    @DisplayName("Retorna la sumatoria de pasajeros que puede transportar la formación entre todos sus vagones")
    void getTotalPasajerosTransportables() {
        when(vagonCarga1.getCantidadMaximaPasajeros()).thenReturn(0);
        when(vagonCarga2.getCantidadMaximaPasajeros()).thenReturn(0);
        when(vagonCarga3.getCantidadMaximaPasajeros()).thenReturn(0);
        when(vagonPasajeros1.getCantidadMaximaPasajeros()).thenReturn(95);
        when(vagonPasajeros2.getCantidadMaximaPasajeros()).thenReturn(120);
        when(vagonPasajeros3.getCantidadMaximaPasajeros()).thenReturn(60);
        when(vagonPasajeros4.getCantidadMaximaPasajeros()).thenReturn(70);
        when(vagonPasajeros5.getCantidadMaximaPasajeros()).thenReturn(75);

        assertEquals(420, formacion.getTotalPasajerosTransportables());
    }

    @Test
    @DisplayName("Retorna la cantidad de vagones de la formación que pesan menos de 2500")
    void getCantidadVagonesLivianos() {
        when(vagonCarga1.esLiviano()).thenReturn(false);
        when(vagonCarga2.esLiviano()).thenReturn(false);
        when(vagonCarga3.esLiviano()).thenReturn(false);
        when(vagonPasajeros1.esLiviano()).thenReturn(true);
        when(vagonPasajeros2.esLiviano()).thenReturn(true);
        when(vagonPasajeros3.esLiviano()).thenReturn(true);
        when(vagonPasajeros4.esLiviano()).thenReturn(false);
        when(vagonPasajeros5.esLiviano()).thenReturn(true);

        assertEquals(4, formacion.getCantidadVagonesLivianos());
    }

    @Test
    @DisplayName("Retorna la velocidad mínima entre las velocidades máximas de las locomotoras de la formación")
    void getVelocidadMaxima() {
        when(locomotora1.getVelocidadMaxima()).thenReturn(680.25);
        when(locomotora2.getVelocidadMaxima()).thenReturn(570.94);

        assertEquals(570.94, formacion.getVelocidadMaxima());
    }

    @Test
    @DisplayName("Retorna true cuando todas las locomotoras de la formación son eficientes, o false en caso contrario")
    void esEficiente() {
        when(locomotora1.esEficiente()).thenReturn(true);
        when(locomotora2.esEficiente()).thenReturn(true);
        assertTrue(formacion.esEficiente());

        when(locomotora1.esEficiente()).thenReturn(false);
        assertFalse(formacion.esEficiente());
    }

    @Test
    @DisplayName("Retorna true cuando la sumatoria del arrastre útil de todas las locomotoras de la formación es mayor a la sumatoria del peso máximo de todos sus vagones, o false en caso contrario")
    void puedeMoverse() {
        when(locomotora1.getArrastreUtil()).thenReturn(8000.0);
        when(locomotora2.getArrastreUtil()).thenReturn(12000.0);
        when(vagonCarga1.getPesoMaximo()).thenReturn(3000.0);
        when(vagonCarga2.getPesoMaximo()).thenReturn(2400.0);
        when(vagonCarga3.getPesoMaximo()).thenReturn(2700.0);
        when(vagonPasajeros1.getPesoMaximo()).thenReturn(990.0);
        when(vagonPasajeros2.getPesoMaximo()).thenReturn(1120.0);
        when(vagonPasajeros3.getPesoMaximo()).thenReturn(1260.0);
        when(vagonPasajeros4.getPesoMaximo()).thenReturn(1080.0);
        when(vagonPasajeros5.getPesoMaximo()).thenReturn(1920.0);
        assertTrue(formacion.puedeMoverse());

        when(locomotora2.getArrastreUtil()).thenReturn(2000.0);
        assertFalse(formacion.puedeMoverse());
    }

    @Test
    @DisplayName("Retorna 0 cuando la formación puede moverse, o la diferencia entre el arrastre útil total y el peso máximo total en caso contrario")
    void getKilosDeEmpujeFaltantes() {
        when(locomotora1.getArrastreUtil()).thenReturn(7000.0);
        when(locomotora2.getArrastreUtil()).thenReturn(2000.0);
        when(vagonCarga1.getPesoMaximo()).thenReturn(3000.0);
        when(vagonCarga2.getPesoMaximo()).thenReturn(2400.0);
        when(vagonCarga3.getPesoMaximo()).thenReturn(2700.0);
        when(vagonPasajeros1.getPesoMaximo()).thenReturn(990.0);
        when(vagonPasajeros2.getPesoMaximo()).thenReturn(1120.0);
        when(vagonPasajeros3.getPesoMaximo()).thenReturn(1260.0);
        when(vagonPasajeros4.getPesoMaximo()).thenReturn(1080.0);
        when(vagonPasajeros5.getPesoMaximo()).thenReturn(1920.0);
        assertEquals(5470, formacion.getKilosDeEmpujeFaltantes());

        when(locomotora2.getArrastreUtil()).thenReturn(8000.0);
        assertEquals(0, formacion.getKilosDeEmpujeFaltantes());
    }

    @Test
    @DisplayName("Retorna la sumatoria de peso de los vagones y locomotoras de la formación")
    void getPesoTotal() {
        when(vagonCarga1.getPesoMaximo()).thenReturn(3000.0);
        when(vagonCarga2.getPesoMaximo()).thenReturn(3000.0);
        when(vagonCarga3.getPesoMaximo()).thenReturn(3000.0);
        when(vagonPasajeros1.getPesoMaximo()).thenReturn(1000.0);
        when(vagonPasajeros2.getPesoMaximo()).thenReturn(1000.0);
        when(vagonPasajeros3.getPesoMaximo()).thenReturn(1000.0);
        when(vagonPasajeros4.getPesoMaximo()).thenReturn(1000.0);
        when(vagonPasajeros5.getPesoMaximo()).thenReturn(1000.0);
        when(locomotora1.getPeso()).thenReturn(2000.0);
        when(locomotora2.getPeso()).thenReturn(2000.0);

        assertEquals(18000, formacion.getPesoTotal());
    }

    @Test
    @DisplayName("Retorna la sumatoria de vagones y locomotoras de la formación")
    void getTotalUnidades() {
        assertEquals(10, formacion.getTotalUnidades());
    }

    @Test
    @DisplayName("Retorna true si la formación pesa más de 10000 o si se compone por más de 20 unidades, o false en caso que no se cumpla ninguna de las dos")
    void esCompleja() {
        when(vagonCarga1.getPesoMaximo()).thenReturn(1000.0);
        when(vagonCarga2.getPesoMaximo()).thenReturn(1000.0);
        when(vagonCarga3.getPesoMaximo()).thenReturn(1000.0);
        when(vagonPasajeros1.getPesoMaximo()).thenReturn(1000.0);
        when(vagonPasajeros2.getPesoMaximo()).thenReturn(1000.0);
        when(vagonPasajeros3.getPesoMaximo()).thenReturn(1000.0);
        when(vagonPasajeros4.getPesoMaximo()).thenReturn(1000.0);
        when(vagonPasajeros5.getPesoMaximo()).thenReturn(1000.0);
        when(locomotora1.getPeso()).thenReturn(2000.0);
        when(locomotora2.getPeso()).thenReturn(2000.0);
        assertTrue(formacion.esCompleja());

        when(locomotora1.getPeso()).thenReturn(500.0);
        when(locomotora2.getPeso()).thenReturn(500.0);
        assertFalse(formacion.esCompleja());

        locomotoras.add(locomotora1);
        locomotoras.add(locomotora1);
        locomotoras.add(locomotora1);
        locomotoras.add(locomotora1);
        locomotoras.add(locomotora1);
        locomotoras.add(locomotora1);
        locomotoras.add(locomotora1);
        locomotoras.add(locomotora1);
        locomotoras.add(locomotora1);
        locomotoras.add(locomotora1);
        locomotoras.add(locomotora1);
        assertTrue(formacion.esCompleja());
    }
}