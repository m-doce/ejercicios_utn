package code;

import exceptions.ModeradoNoSubeException;

public class Moderado implements Perfil {

    private int minimoLugaresLibres;

    @Override
    public boolean quiereSubir(Micro m) {
        if(this.minimoLugaresLibres > m.getLugaresTotalesLibres())
            throw new ModeradoNoSubeException();
        return true;
    }

}
