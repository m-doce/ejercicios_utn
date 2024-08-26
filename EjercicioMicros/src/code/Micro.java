package code;

import exceptions.*;

import java.util.ArrayList;

public class Micro {

    private double volumen;
    private int capacidadSentados;
    private int capacidadParados;
    private ArrayList<Pasajero> pasajeros;
    private Pasajero primeroEnSubir;

    public Micro(double volumen, int capacidadSentados, int capacidadParados) {
        this.volumen = volumen;
        this.capacidadSentados = capacidadSentados;
        this.capacidadParados = capacidadParados;
        this.pasajeros = new ArrayList<Pasajero>();
        this.primeroEnSubir = null;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public int getCapacidadSentados() {
        return capacidadSentados;
    }

    public void setCapacidadSentados(int capacidadSentados) {
        this.capacidadSentados = capacidadSentados;
    }

    public int getCapacidadParados() {
        return capacidadParados;
    }

    public void setCapacidadParados(int capacidadParados) {
        this.capacidadParados = capacidadParados;
    }

    public int getCapacidadTotal() {
        return capacidadSentados + capacidadParados;
    }

    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(ArrayList<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

    public int getAsientosLibres() {
        int asientosLibres = this.capacidadSentados - this.pasajeros.size();
        if(asientosLibres <= 0)
            asientosLibres = 0;
        return asientosLibres;
    }
    public int getLugaresParadosLibres() {
        int lugaresLibres = this.capacidadParados;
        if(this.getAsientosLibres() == 0) {
            lugaresLibres -= (this.pasajeros.size() - this.capacidadSentados);
            if (lugaresLibres <= 0)
                lugaresLibres = 0;
        }
        return lugaresLibres;
    }
    public int getLugaresTotalesLibres() {
        return this.getAsientosLibres() + this.getLugaresParadosLibres();
    }
    public boolean puedeSubir(Pasajero p) {
        if(this.getLugaresTotalesLibres() == 0)
            throw new MicroLlenoException();
        return p.quiereSubir(this);
    }
    public void subirPasajero(Pasajero p) {
        try {
            this.puedeSubir(p);
            this.setPrimeroEnSubir(p);
            this.pasajeros.add(p);
        }
        catch(MicroLlenoException e) {
            //manejo del error
        }
        catch(ModeradoNoSubeException e) {
            //manejo del error
        }
        catch(ClaustrofobicoNoSubeException e) {
            //manejo del error
        }
        catch(FiacaNoSubeException e) {
            //manejo del error
        }
        return;
    }
    public void bajarPasajero(Pasajero p) {
        if(this.pasajeros.size() == 0)
            throw new MicroVacioException();
        if(this.pasajeros.contains(p) == false)
            throw new NoExistePasajeroException();
        this.pasajeros.remove(p);
        return;
    }
    public void setPrimeroEnSubir(Pasajero p) {
        if(this.primeroEnSubir == null)
            this.primeroEnSubir = p;
        return;
    }
    public Pasajero getPrimeroEnSubir() {
        return this.primeroEnSubir;
    }

}
