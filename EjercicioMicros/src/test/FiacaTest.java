package test;

import code.Fiaca;
import code.Micro;
import exceptions.FiacaNoSubeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FiacaTest {

    private Fiaca instance;
    private Micro micro = mock(Micro.class);

    @BeforeEach
    void setUp() {
        instance = new Fiaca();
    }

    @Test
    @DisplayName("Verifica que el Fiaca se quiera subir cuando el micro tiene asientos libres")
    void quiereSubirTrue() {
        when(micro.getAsientosLibres()).thenReturn(5);
        assertTrue(instance.quiereSubir(micro));
    }

    @Test
    @DisplayName("Verifica que el Fiaca no se quiera subir cuando el micro no tiene asientos libres, lanzando la excepción esperada")
    void quiereSubirFalse() {
        when(micro.getAsientosLibres()).thenReturn(0);
        assertThrows(FiacaNoSubeException.class, () -> {
            instance.quiereSubir(micro);
        });
    }
}