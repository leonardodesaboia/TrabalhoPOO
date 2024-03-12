package Entidades;

import Exceções.WrongNameException;

public class Repositor extends Funcionario {
    private double salarioFixo;

    public Repositor(int idade, String nome, double salarioFixo, int id, int horaExtra, String escolaridade,
            int quantidadeHorasExtras) {
        super(idade, nome, id, horaExtra, escolaridade, quantidadeHorasExtras);
        this.salarioFixo = salarioFixo;
    }

    public double getSalarioFixo() {
        return salarioFixo;
    }

    public void setSalarioFixo(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    @Override
    public double calcularEscolaridade() {
        try {
            if (escolaridade.equals("ensino medio incompleto")) {
                return 100;
            }
            if (escolaridade.equals("ensino medio completo")) {
                return 200;
            }
            if (escolaridade.equals("ensino superior incompleto")) {
                return 300;
            }
            if (escolaridade.equals("ensino superior completo")) {
                return 400;
            } else {
                return 0;
            }
        } catch (WrongNameException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public double calcularHoraExtra() {
        double totalHoraExtra = quantidadeHorasExtras * horaExtra;
        return totalHoraExtra;
    }

    @Override
    public double calcularSalario() {
        return salarioFixo + calcularHoraExtra() + calcularEscolaridade() + 100;
    }

    @Override
    public String toString() {
        return "Repositor = " + getId() + "\n" + "Nome: " + getNome() + ", Salário Fixo: " + getSalarioFixo()
                + ", Salário Total: " + calcularSalario() + "\n";
    }
}