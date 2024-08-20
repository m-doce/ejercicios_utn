package code;

import java.util.ArrayList;

public class Formacion {
    private ArrayList<Vagon> vagones;
    private ArrayList<Locomotora> locomotoras;

    public Formacion(ArrayList<Vagon> vagones, ArrayList<Locomotora> locomotoras) {
        this.vagones = vagones;
        this.locomotoras = locomotoras;
    }

    public ArrayList<Vagon> getVagones() {
        return vagones;
    }

    public void setVagones(ArrayList<Vagon> vagones) {
        this.vagones = vagones;
    }

    public ArrayList<Locomotora> getLocomotoras() {
        return locomotoras;
    }

    public void setLocomotoras(ArrayList<Locomotora> locomotoras) {
        this.locomotoras = locomotoras;
    }

    public int getTotalPasajerosTransportables() {
        return vagones.stream()
                .mapToInt(Vagon::getCantidadMaximaPasajeros)
                .sum();
    }
    public int getCantidadVagonesLivianos() {
        return (int) vagones.stream()
                .filter(Vagon::esLiviano)
                .count();
    }
    public double getVelocidadMaxima() {
        return locomotoras.stream()
                .mapToDouble(Locomotora::getVelocidadMaxima)
                .min()
                .orElse(0.0);
    }
    public boolean esEficiente() {
        return locomotoras.stream().allMatch(Locomotora::esEficiente);
    }
    public boolean puedeMoverse() {
        double arrastreTotal = locomotoras.stream()
                .mapToDouble(Locomotora::getArrastreUtil)
                .sum();
        double pesoTotal = vagones.stream()
                .mapToDouble(Vagon::getPesoMaximo)
                .sum();

        return arrastreTotal >= pesoTotal;
    }
    public double getKilosDeEmpujeFaltantes() {
        if (this.puedeMoverse())
            return 0;
        else {
            double arrastreTotal = locomotoras.stream()
                    .mapToDouble(Locomotora::getArrastreUtil)
                    .sum();
            double pesoTotal = vagones.stream()
                    .mapToDouble(Vagon::getPesoMaximo)
                    .sum();

            return pesoTotal - arrastreTotal;
        }
    }
    public double getPesoTotal() {
        double pesoVagones = vagones.stream()
                .mapToDouble(Vagon::getPesoMaximo)
                .sum();
        double pesoLocomotoras = locomotoras.stream()
                .mapToDouble(Locomotora::getPeso)
                .sum();

        return pesoVagones + pesoLocomotoras;
    }
    public int getTotalUnidades() {
        return vagones.size() + locomotoras.size();
    }
    public boolean esCompleja() {
        return this.getPesoTotal() > 10000 || this.getTotalUnidades() > 20;
    }
}
