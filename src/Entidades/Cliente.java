package Entidades;

public class Cliente extends Pessoas {
    private int cadastro;
    private double gasto;

    public Cliente(int idade, String nome, int cadastro, double gasto) {
        super(idade, nome);
        this.cadastro = cadastro;
        this.gasto = gasto;
    }

    public int getCadastro() {
        return cadastro;
    }

    public void setCadastro(int cadastro) {
        this.cadastro = cadastro;
    }

    public double getGasto() {
        return gasto;
    }

    public void setGasto(double gasto) {
        this.gasto = gasto;
    }

    @Override
    public String toString() {
        return "Cliente = " + cadastro + "\n" + " nome = " + nome + " gastos = " + gasto;
    }

}