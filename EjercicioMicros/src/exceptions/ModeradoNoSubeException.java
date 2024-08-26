package exceptions;

public class ModeradoNoSubeException extends RuntimeException {
    @Override
    public String getMessage() {
        return "El pasajero no quiere subir, no hay suficientes lugares libres para su gusto.";
    }
}
