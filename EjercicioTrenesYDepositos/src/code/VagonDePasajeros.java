package code;

public class VagonDePasajeros extends Vagon {
    private double largo;
    private double anchoUtil;

    public VagonDePasajeros(double largo, double anchoUtil) {
        this.largo = largo;
        this.anchoUtil = anchoUtil;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAnchoUtil() {
        return anchoUtil;
    }

    public void setAnchoUtil(double anchoUtil) {
        this.anchoUtil = anchoUtil;
    }

    public double getPesoMaximo() {
        return this.getCantidadMaximaPasajeros() * 80;
    }
    public int getCantidadMaximaPasajeros() {
        if(this.anchoUtil <= 2.5)
            return (int) (this.largo * 8);
        else
            return (int) (this.largo * 10);
    }
}
