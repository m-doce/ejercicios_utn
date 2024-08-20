package test;

import code.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DepositoTest {

    Formacion formacion1 = mock(Formacion.class);
    Formacion formacion2 = mock(Formacion.class);
    Formacion formacion3 = mock(Formacion.class);
    Locomotora locomotora1 = mock(Locomotora.class);
    Locomotora locomotora2 = mock(Locomotora.class);
    VagonDeCarga vagonCarga1 = mock(VagonDeCarga.class);
    VagonDeCarga vagonCarga2 = mock(VagonDeCarga.class);
    VagonDeCarga vagonCarga3 = mock(VagonDeCarga.class);
    VagonDePasajeros vagonPasajeros1 = mock(VagonDePasajeros.class);
    VagonDePasajeros vagonPasajeros2 = mock(VagonDePasajeros.class);
    VagonDePasajeros vagonPasajeros3 = mock(VagonDePasajeros.class);
    ArrayList<Formacion> formaciones = new ArrayList<>();
    ArrayList<Locomotora> locomotoras = new ArrayList<>();
    ArrayList<Vagon> vagones1 = new ArrayList<>();
    ArrayList<Vagon> vagones2 = new ArrayList<>();
    ArrayList<Vagon> vagones3 = new ArrayList<>();

    Deposito deposito;


    @BeforeEach
    void setUp() {
        formaciones.add(formacion1);
        formaciones.add(formacion2);
        formaciones.add(formacion3);
        locomotoras.add(locomotora1);
        locomotoras.add(locomotora2);

        deposito = new Deposito(formaciones, locomotoras);
    }

    @Test
    @DisplayName("Verifica el funcionamiento del getFormaciones")
    void getFormaciones() {
        assertEquals(formaciones, deposito.getFormaciones());
    }

    @Test
    @DisplayName("Verifica el funcionamiento del setFormaciones")
    void setFormaciones() {
        formaciones.remove(formacion1);
        deposito.setFormaciones(formaciones);
        assertEquals(formaciones, deposito.getFormaciones());
    }

    @Test
    @DisplayName("Verifica el funcionamiento del getLocomotoras")
    void getLocomotoras() {
        assertEquals(locomotoras, deposito.getLocomotoras());
    }

    @Test
    @DisplayName("Verifica el funcionamiento del setLocomotoras")
    void setLocomotoras() {
        locomotoras.remove(locomotora1);
        deposito.setLocomotoras(locomotoras);
        assertEquals(locomotoras, deposito.getLocomotoras());
    }

    @Test
    @DisplayName("Retorna una lista con los vagones más pesados de cada formación del depósito")
    void getVagonesPesados() {
        vagones1.add(vagonCarga1);
        vagones1.add(vagonPasajeros1);
        when(formacion1.getVagones()).thenReturn(vagones1);
        vagones2.add(vagonCarga2);
        vagones2.add(vagonPasajeros2);
        when(formacion2.getVagones()).thenReturn(vagones2);
        vagones3.add(vagonCarga3);
        vagones3.add(vagonPasajeros3);
        when(formacion3.getVagones()).thenReturn(vagones3);

        when(vagonCarga1.getPesoMaximo()).thenReturn(3000.0);
        when(vagonPasajeros1.getPesoMaximo()).thenReturn(1000.0);
        when(vagonCarga2.getPesoMaximo()).thenReturn(3000.0);
        when(vagonPasajeros2.getPesoMaximo()).thenReturn(1000.0);
        when(vagonCarga3.getPesoMaximo()).thenReturn(1000.0);
        when(vagonPasajeros3.getPesoMaximo()).thenReturn(1500.0);

        ArrayList<Vagon> vagonesPesados = new ArrayList<>();
        vagonesPesados.add(vagonCarga1);
        vagonesPesados.add(vagonCarga2);
        vagonesPesados.add(vagonPasajeros3);

        assertEquals(vagonesPesados, deposito.getVagonesPesados());
    }
}