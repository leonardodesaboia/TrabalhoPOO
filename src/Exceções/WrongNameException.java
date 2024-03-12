package Exceções;

public class WrongNameException extends RuntimeException {
    public WrongNameException(String args) {
        super(args);
    }
}