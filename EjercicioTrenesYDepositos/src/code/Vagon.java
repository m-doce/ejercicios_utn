package code;

public abstract class Vagon {
    abstract public double getPesoMaximo();
    public boolean esLiviano() {
        return this.getPesoMaximo() < 2500;
    }
    abstract public int getCantidadMaximaPasajeros();
}
