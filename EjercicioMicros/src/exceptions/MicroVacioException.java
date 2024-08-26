package exceptions;

public class MicroVacioException extends RuntimeException {
    @Override
    public String getMessage() {
        return "El micro está vacío, no hay nadie a quien bajar del mismo.";
    }
}
