package exceptions;

public class FiacaNoSubeException extends RuntimeException {
    @Override
    public String getMessage() {
        return "El pasajero no quiere subir, el micro no tiene asientos disponibles.";
    }
}
