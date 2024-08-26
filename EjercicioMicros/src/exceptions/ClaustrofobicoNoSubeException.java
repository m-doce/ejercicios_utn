package exceptions;

public class ClaustrofobicoNoSubeException extends RuntimeException {
    @Override
    public String getMessage() {
        return "El pasajero no quiere subir, el micro es muy pequeño para su gusto.";
    }
}
