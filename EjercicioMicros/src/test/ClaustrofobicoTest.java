package test;

import code.Claustrofobico;
import code.Micro;
import exceptions.ClaustrofobicoNoSubeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ClaustrofobicoTest {

    private Claustrofobico instance;
    private Micro micro = mock(Micro.class);

    @BeforeEach
    void setUp() {
        instance = new Claustrofobico();
    }

    @Test
    @DisplayName("Verifica que el Claustrofobico se quiera subir cuando el micro tiene más de 120m³ de volumen")
    void quiereSubirTrue() {
        when(micro.getVolumen()).thenReturn(125.0);
        assertTrue(instance.quiereSubir(micro));
    }

    @Test
    @DisplayName("Verifica que el Claustrofobico no se quiera subir cuando el micro tiene 120m³ o menos de volumen, lanzando la excepción esperada")
    void quiereSubirFalse() {
        when(micro.getVolumen()).thenReturn(120.0);
        assertThrows(ClaustrofobicoNoSubeException.class, () -> {
            instance.quiereSubir(micro);
        });

        when(micro.getVolumen()).thenReturn(100.0);
        assertThrows(ClaustrofobicoNoSubeException.class, () -> {
            instance.quiereSubir(micro);
        });
    }
}