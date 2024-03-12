package Entidades;

import Interfaces.InterfaceProdutos;
import java.time.LocalDate;

public abstract class Produto implements InterfaceProdutos {
    protected LocalDate validade;
    protected double preco;
    protected String nome;
    protected String marca;
    protected double imposto;

    public Produto(LocalDate validade, double preco, String nome, String marca, double imposto) {
        this.validade = validade;
        this.preco = preco;
        this.nome = nome;
        this.marca = marca;
        this.imposto = imposto;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException();
        } else {
            this.preco = preco;
        }
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public abstract double calcularValor();

    @Override
    public String toString() {
        return "Produto [validade=" + validade + ", preco=" + preco + ", nome=" + nome + ", marca=" + marca
                + ", imposto=" + imposto + "]";
    }
}