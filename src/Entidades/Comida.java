package Entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Interfaces.InterfaceComidas;

public abstract class Comida extends Produto implements InterfaceComidas {

    public Comida(LocalDate validade, double preco, String nome, String marca, double imposto) {
        super(validade, preco, nome, marca, imposto);
    }

    public String getValidadeFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return validade.format(formatter);
    }

    public double calcularValor() {
        return preco + imposto;
    }

    public abstract int calcularValidade();

    @Override
    public String toString() {
        return "Comida []";
    }

}