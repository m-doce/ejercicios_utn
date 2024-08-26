package exceptions;

public class NoExistePasajeroException extends RuntimeException {
    @Override
    public String getMessage() {
        return "El pasajero no se encuentra viajando en este micro.";
    }
}
