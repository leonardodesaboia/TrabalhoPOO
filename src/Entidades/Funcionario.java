package Entidades;

import Interfaces.InterfaceFuncionarios;

public abstract class Funcionario extends Pessoas implements InterfaceFuncionarios {

    protected int id;
    protected int horaExtra;
    protected String escolaridade;
    protected int quantidadeHorasExtras;

    public Funcionario(int idade, String nome, int id, int horaExtra, String escolaridade, int quantidadeHorasExtras) {
        super(idade, nome);
        this.id = id;
        this.horaExtra = horaExtra;
        this.escolaridade = escolaridade;
        this.quantidadeHorasExtras = quantidadeHorasExtras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHoraExtra() {
        return horaExtra;
    }

    public void setHoraExtra(int horaExtra) {
        this.horaExtra = horaExtra;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public int getQuantidadeHorasExtras() {
        return quantidadeHorasExtras;
    }

    public void setQuantidadeHorasExtras(int quantidadeHorasExtras) {
        this.quantidadeHorasExtras = quantidadeHorasExtras;
    }

    public abstract double calcularSalario();

    public abstract double calcularHoraExtra();

    public abstract double calcularEscolaridade();

    @Override
    public String toString() {
        return "Funcionarios [id=" + id + ", horaExtra=" + horaExtra + ", escolaridade=" + escolaridade
                + ", quantidadeHorasExtras=" + quantidadeHorasExtras + "]";
    }

}