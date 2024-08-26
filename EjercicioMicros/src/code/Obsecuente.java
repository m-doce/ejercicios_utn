package code;

public class Obsecuente implements Perfil {

    private Pasajero jefe;

    public Obsecuente(Pasajero jefe) {
        this.jefe = jefe;
    }

    @Override
    public boolean quiereSubir(Micro m) {
        return this.jefe.quiereSubir(m);
    }
}
