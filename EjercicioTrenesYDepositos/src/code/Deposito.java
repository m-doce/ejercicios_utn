package code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Deposito {
    private ArrayList<Formacion> formaciones;
    private ArrayList<Locomotora> locomotoras;

    public Deposito(ArrayList<Formacion> formaciones, ArrayList<Locomotora> locomotoras) {
        this.formaciones = formaciones;
        this.locomotoras = locomotoras;
    }

    public ArrayList<Formacion> getFormaciones() {
        return formaciones;
    }

    public void setFormaciones(ArrayList<Formacion> formaciones) {
        this.formaciones = formaciones;
    }

    public ArrayList<Locomotora> getLocomotoras() {
        return locomotoras;
    }

    public void setLocomotoras(ArrayList<Locomotora> locomotoras) {
        this.locomotoras = locomotoras;
    }

    public ArrayList<Vagon> getVagonesPesados() {
        return formaciones.stream()
                .map(formacion -> formacion.getVagones().stream()
                        .max(Comparator.comparingDouble(Vagon::getPesoMaximo))
                        .orElse(null))
                .filter(vagon -> vagon != null)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
