package code;

public class Obsecuente implements Perfil {

    private Perfil perfilJefe;

    public void setPerfilJefe(Perfil perfilJefe) {
        this.perfilJefe = perfilJefe;
    }

    public Perfil getPerfilJefe() {
        return perfilJefe;
    }

    public Obsecuente(Perfil perfilJefe) {
        this.perfilJefe = perfilJefe;
    }

    @Override
    public boolean quiereSubir(Micro m) {
        return this.perfilJefe.quiereSubir(m);
    }
}
