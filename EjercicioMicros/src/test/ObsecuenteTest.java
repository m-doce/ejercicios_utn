package test;

import code.*;
import exceptions.ClaustrofobicoNoSubeException;
import exceptions.FiacaNoSubeException;
import exceptions.ModeradoNoSubeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ObsecuenteTest {

    private Obsecuente instance;
    private Micro micro = mock(Micro.class);

    @BeforeEach
    void setUp() {
        instance = new Obsecuente(null);
    }

    @Test
    @DisplayName("Verifica que el Obsecuente siga los pasos de su jefe Apurado")
    void quiereSubirJefeApurado() {
        instance.setPerfilJefe(new Apurado());
        assertTrue(instance.quiereSubir(micro));
    }

    @Test
    @DisplayName("Verifica que el Obsecuente siga los pasos de su jefe Fiaca")
    void quiereSubirJefeFiaca() {
        instance.setPerfilJefe(new Fiaca());
        when(micro.getAsientosLibres()).thenReturn(5);
        assertTrue(instance.quiereSubir(micro));

        when(micro.getAsientosLibres()).thenReturn(0);
        assertThrows(FiacaNoSubeException.class, () -> {
            instance.quiereSubir(micro);
        });
    }

    @Test
    @DisplayName("Verifica que el Obsecuente siga los pasos de su jefe Moderado")
    void quiereSubirJefeModerado() {
        instance.setPerfilJefe(new Moderado(10));
        when(micro.getLugaresTotalesLibres()).thenReturn(15);
        assertTrue(instance.quiereSubir(micro));

        when(micro.getLugaresTotalesLibres()).thenReturn(5);
        assertThrows(ModeradoNoSubeException.class, () -> {
            instance.quiereSubir(micro);
        });
    }

    @Test
    @DisplayName("Verifica que el Obsecuente siga los pasos de su jefe Claustrofobico")
    void quiereSubirJefeClaustrofobico() {
        instance.setPerfilJefe(new Claustrofobico());
        when(micro.getVolumen()).thenReturn(150.0);
        assertTrue(instance.quiereSubir(micro));

        when(micro.getVolumen()).thenReturn(115.0);
        assertThrows(ClaustrofobicoNoSubeException.class, () -> {
            instance.quiereSubir(micro);
        });
    }
}