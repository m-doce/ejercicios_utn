package code;

public class VagonDeCarga extends Vagon {
    private double cargaMaxima;

    public VagonDeCarga(double cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(double cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public double getPesoMaximo() {
        return this.cargaMaxima + 160;
    }
    public int getCantidadMaximaPasajeros() {
        return 0;
    }
}
