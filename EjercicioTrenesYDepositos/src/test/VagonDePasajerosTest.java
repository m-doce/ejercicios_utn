package test;

import code.VagonDePasajeros;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VagonDePasajerosTest {

    private VagonDePasajeros vagonChico;
    private VagonDePasajeros vagonGrande;

    @BeforeEach
    void setUp() {
        vagonChico = new VagonDePasajeros(10, 2);
        vagonGrande = new VagonDePasajeros(10, 3);
    }

    @Test
    @DisplayName("Verifica el funcionamiento del getLargo")
    void getLargo() {
        assertEquals(10, vagonChico.getLargo());
    }

    @Test
    @DisplayName("Verifica el funcionamiento del setLargo")
    void setLargo() {
        vagonChico.setLargo(15);
        assertEquals(15, vagonChico.getLargo());
    }

    @Test
    @DisplayName("Verifica el funcionamiento del getAnchoUtil")
    void getAnchoUtil() {
        assertEquals(3, vagonGrande.getAnchoUtil());
    }

    @Test
    @DisplayName("Verifica el funcionamiento del setAnchoUtil")
    void setAnchoUtil() {
        vagonGrande.setAnchoUtil(5);
        assertEquals(5, vagonGrande.getAnchoUtil());
    }

    @Test
    @DisplayName("Retorna el resultado de: la cantidad máxima de pasajeros que puede transportar * 80")
    void getPesoMaximo() {
        assertEquals(6400, vagonChico.getPesoMaximo());
        assertEquals(8000, vagonGrande.getPesoMaximo());
    }

    @Test
    @DisplayName("Retorna el resultado de: largo * 8 si su ancho útil es menor o igual a 2.5, o largo * 10 si su ancho útil es mayor a 2.5")
    void getCantidadMaximaPasajeros() {
        assertEquals(80, vagonChico.getCantidadMaximaPasajeros());
        assertEquals(100, vagonGrande.getCantidadMaximaPasajeros());
    }
}