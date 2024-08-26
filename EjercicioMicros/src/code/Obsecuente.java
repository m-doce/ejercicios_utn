package code;

public class Obsecuente implements Perfil {

    private Pasajero jefe;
    @Override
    public boolean quiereSubir(Micro m) {
        return this.jefe.quiereSubir(m);
    }
}
