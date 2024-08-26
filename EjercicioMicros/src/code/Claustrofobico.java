package code;

import exceptions.ClaustrofobicoNoSubeException;

public class Claustrofobico implements Perfil {

    @Override
    public boolean quiereSubir(Micro m) {
        if(m.getVolumen() <= 120)
            throw new ClaustrofobicoNoSubeException();
        return true;
    }

}
