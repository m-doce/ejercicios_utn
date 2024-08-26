package code;

public class Pasajero {

    private String nombre;
    private int legajo;
    private Perfil perfil;
    private Pasajero jefe;

    public Pasajero(String nombre, int legajo, Perfil perfil, Pasajero jefe) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.perfil = perfil;
        this.jefe = jefe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Pasajero getJefe() {
        return jefe;
    }

    public void setJefe(Pasajero jefe) {
        this.jefe = jefe;
    }

    public boolean esJefe() {
        return this.jefe == null;
    }

    public boolean quiereSubir(Micro m) {
        return this.perfil.quiereSubir(m);
    }

}
