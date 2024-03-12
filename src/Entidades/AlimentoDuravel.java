package Entidades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AlimentoDuravel extends Comida {

    public AlimentoDuravel(LocalDate validade, double preco, String nome, String marca, double imposto) {
        super(validade, preco, nome, marca, imposto);
    }

    @Override
    public int calcularValidade() {
        LocalDate hoje = LocalDate.now();
        if (validade.isBefore(hoje)) {
            return 0;
        } else {
            return (int) ChronoUnit.DAYS.between(hoje, validade);
        }
    }

    @Override
    public String toString() {
        return "AlimentoDuravel [ validade: " + getValidade() + " preco: " + getPreco() + " nome: " + getNome()
                + " marca: " + getMarca() + " imposto: " + getImposto() + "]";
    }

}