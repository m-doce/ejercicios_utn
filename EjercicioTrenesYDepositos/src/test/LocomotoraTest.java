package test;

import code.Estado;
import code.Locomotora;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocomotoraTest {

    private Locomotora locomotora;

    @BeforeEach
    void setUp() {
        locomotora = new Locomotora(1500, 5000, 500, Estado.EN_DEPOSITO);
    }

    @Test
    @DisplayName("Verifica el funcionamiento del getPeso")
    void getPeso() {
        assertEquals(1500, locomotora.getPeso());
    }

    @Test
    @DisplayName("Verifica el funcionamiento del setPeso")
    void setPeso() {
        locomotora.setPeso(2000);
        assertEquals(2000, locomotora.getPeso());
    }

    @Test
    @DisplayName("Verifica el funcionamiento del getPesoDeArrastreMaximo")
    void getPesoDeArrastreMaximo() {
        assertEquals(5000, locomotora.getPesoDeArrastreMaximo());
    }

    @Test
    @DisplayName("Verifica el funcionamiento del setPesoDeArrastreMaximo")
    void setPesoDeArrastreMaximo() {
        locomotora.setPesoDeArrastreMaximo(3000);
        assertEquals(3000, locomotora.getPesoDeArrastreMaximo());
    }

    @Test
    @DisplayName("Verifica el funcionamiento del getVelocidadMaxima")
    void getVelocidadMaxima() {
        assertEquals(500, locomotora.getVelocidadMaxima());
    }

    @Test
    @DisplayName("Verifica el funcionamiento del setVelocidadMaxima")
    void setVelocidadMaxima() {
        locomotora.setVelocidadMaxima(700);
        assertEquals(700, locomotora.getVelocidadMaxima());
    }

    @Test
    @DisplayName("Verifica el funcionamiento del getEstado")
    void getEstado() {
        assertEquals(Estado.EN_DEPOSITO, locomotora.getEstado());
    }

    @Test
    @DisplayName("Verifica el funcionamiento del setEstado")
    void setEstado() {
        locomotora.setEstado(Estado.EN_MARCHA);
        assertEquals(Estado.EN_MARCHA, locomotora.getEstado());
    }

    @Test
    @DisplayName("Retorna la diferencia de peso entre el peso de arrastre máximo y el peso propio")
    void getArrastreUtil() {
        assertEquals(3500, locomotora.getArrastreUtil());
    }

    @Test
    @DisplayName("Retorna true cuando su arrastre útil es cinco veces mayor a su peso, o false en caso contrario")
    void esEficiente() {
        assertFalse(locomotora.esEficiente());

        locomotora.setPesoDeArrastreMaximo(20000);
        assertTrue(locomotora.esEficiente());
    }
}