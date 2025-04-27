package exceptions;

public class EmptyStringException extends Exception {
    @Override
    public String getMessage() {
        return "Name не может быть пустым!";
    }
}
