package project.spring_security.exception;

public class EntityValidationException extends RuntimeException{
    public EntityValidationException(String message) {
        super(message);
    }
}
