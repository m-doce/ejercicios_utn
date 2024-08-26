package code;

import exceptions.FiacaNoSubeException;

public class Fiaca implements Perfil {
    @Override
    public boolean quiereSubir(Micro m) {
        if(m.getAsientosLibres() == 0)
            throw new FiacaNoSubeException();
        return true;
    }

}
