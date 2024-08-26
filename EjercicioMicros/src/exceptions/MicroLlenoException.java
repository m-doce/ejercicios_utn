package exceptions;

public class MicroLlenoException extends RuntimeException {
    @Override
    public String getMessage() {
        return "El micro está lleno, no puede subir nadie más.";
    }
}
