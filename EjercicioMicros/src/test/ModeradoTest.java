package test;

import code.Micro;
import code.Moderado;
import exceptions.ModeradoNoSubeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ModeradoTest {

    private Moderado instance;
    private Micro micro = mock(Micro.class);

    @BeforeEach
    void setUp() {
        instance = new Moderado(10);
    }

    @Test
    @DisplayName("Verifica que el Moderado se quiera subir cuando el micro tiene al menos X lugares libres")
    void quiereSubirTrue() {
        when(micro.getLugaresTotalesLibres()).thenReturn(10);
        assertTrue(instance.quiereSubir(micro));

        when(micro.getLugaresTotalesLibres()).thenReturn(15);
        assertTrue(instance.quiereSubir(micro));
    }

    @Test
    @DisplayName("Verifica que el Moderado no se quiera subir cuando el micro no tiene al menos X lugares libres, lanzando la excepción esperada")
    void quiereSubirFalse() {
        when(micro.getLugaresTotalesLibres()).thenReturn(5);
        assertThrows(ModeradoNoSubeException.class, () -> {
            instance.quiereSubir(micro);
        });
    }
}