package exceptionHandlers;

public class InsufficientMaterial extends RuntimeException{
    String message = "Insufficient Material";

    public InsufficientMaterial(String message, String message1) {
        super(message);
        message1 = this.message;
    }
}
