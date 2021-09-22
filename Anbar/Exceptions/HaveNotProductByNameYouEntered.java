package Exceptions;

public class HaveNotProductByNameYouEntered extends  RuntimeException {
    public HaveNotProductByNameYouEntered(String message) {
        super(message);
    }
}
