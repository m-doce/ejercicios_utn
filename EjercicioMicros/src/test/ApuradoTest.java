package test;

import code.Apurado;
import code.Micro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ApuradoTest {

    private Apurado instance;
    private Micro micro = mock(Micro.class);

    @BeforeEach
    void setUp() {
        instance = new Apurado();
    }

    @Test
    @DisplayName("Verifica que el Apurado siempre se quiera subir al micro")
    void quiereSubir() {
        assertTrue(instance.quiereSubir(micro));
    }
}