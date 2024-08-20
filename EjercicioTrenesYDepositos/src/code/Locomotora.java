package code;

public class Locomotora {
    private double peso;
    private double pesoDeArrastreMaximo;
    private double velocidadMaxima;
    private Estado estado;

    public Locomotora(double peso, double pesoDeArrastreMaximo, double velocidadMaxima, Estado estado) {
        this.peso = peso;
        this.pesoDeArrastreMaximo = pesoDeArrastreMaximo;
        this.velocidadMaxima = velocidadMaxima;
        this.estado = estado;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPesoDeArrastreMaximo() {
        return pesoDeArrastreMaximo;
    }

    public void setPesoDeArrastreMaximo(double pesoDeArrastreMaximo) {
        this.pesoDeArrastreMaximo = pesoDeArrastreMaximo;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public double getArrastreUtil() {
        return this.pesoDeArrastreMaximo - this.peso;
    }
    public boolean esEficiente() {
        return this.getArrastreUtil() > 5 * this.peso;
    }
}
