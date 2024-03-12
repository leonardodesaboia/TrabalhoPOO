package Exceções;

public class NumeroNaoExistente extends IllegalArgumentException {
    public NumeroNaoExistente(String args) {
        super(args);
    }
}