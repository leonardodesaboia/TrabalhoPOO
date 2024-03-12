package Entidades;

import java.time.LocalDate;

public abstract class Bebida extends Produto {
    ;

    public Bebida(LocalDate validade, double preco, String nome, String marca, double imposto) {
        super(validade, preco, nome, marca, imposto);
    }

    @Override
    public double calcularValor() {
        return preco + imposto;
    }

    @Override
    public String toString() {
        return "Bebida []";
    }

}