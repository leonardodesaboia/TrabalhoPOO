package Entidades;

import java.time.LocalDate;

public class BebidaNaoAlcoolica extends Bebida {

    public BebidaNaoAlcoolica(LocalDate validade, double preco, String nome, String marca, double imposto) {
        super(validade, preco, nome, marca, imposto);
    }

    @Override
    public String toString() {
        return "BebidaNaoAlcoolica [ validade: " + getValidade() + " preco: " + getPreco() + " nome: " + getNome()
                + " marca: " + getMarca() + " imposto: " + getImposto() + "]";
    }

}