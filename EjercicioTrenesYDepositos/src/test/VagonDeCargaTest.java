package test;

import code.VagonDeCarga;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VagonDeCargaTest {

    private VagonDeCarga vagon;

    @BeforeEach
    void setUp() {
        vagon = new VagonDeCarga(1000);
    }

    @Test
    @DisplayName("Verifica el funcionamiento del getCargaMaxima")
    void getCargaMaxima() {
        assertEquals(1000, vagon.getCargaMaxima());
    }

    @Test
    @DisplayName("Verifica el funcionamiento del setCargaMaxima")
    void setCargaMaxima() {
        vagon.setCargaMaxima(1500);
        assertEquals(1500, vagon.getCargaMaxima());
    }

    @Test
    @DisplayName("Verifica el funcionamiento del getPesoMaximo")
    void getPesoMaximo() {
        assertEquals(1160, vagon.getPesoMaximo());
    }

    @Test
    @DisplayName("Retorna 0, ya que un vagón de carga no puede llevar pasajeros")
    void getCantidadMaximaPasajeros() {
        assertEquals(0, vagon.getCantidadMaximaPasajeros());
    }

    @Test
    @DisplayName("Retorna true si pesa menos de 2500, o false si pesa más de 2500")
    void esLiviano() {
        VagonDeCarga vagonLiviano = new VagonDeCarga(1700);
        assertTrue(vagonLiviano.esLiviano());

        VagonDeCarga vagonPesado = new VagonDeCarga(2700);
        assertFalse(vagonPesado.esLiviano());
    }
}