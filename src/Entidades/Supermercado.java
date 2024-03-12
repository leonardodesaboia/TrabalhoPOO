package Entidades;

import Exceções.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Supermercado {
    private List<Produto> consumiveis = new ArrayList<Produto>();
    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private List<Cliente> clientes = new ArrayList<Cliente>();

    public void CadastrarProdutoDireto(Produto p) {
        consumiveis.add(p);
    }

    public Supermercado(List<Produto> consumiveis, List<Funcionario> funcionarios, List<Cliente> clientes) {
        this.consumiveis = consumiveis;
        this.funcionarios = funcionarios;
        this.clientes = clientes;
    }

    public Supermercado() {
    }

    public void imprimirInformacaoFuncionarios() {
        int contadorRepositores = 0;
        int contadorCaixas = 0;
        int contadorGerentes = 0;

        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);

            if (funcionario instanceof Repositor) {
                contadorRepositores++;
            } else if (funcionario instanceof Caixa) {
                contadorCaixas++;
            } else if (funcionario instanceof Gerente) {
                contadorGerentes++;
            }
        }

        System.out.println("Quantidade de funcionários: Repositores = " + contadorRepositores);
        System.out.println("Quantidade de funcionários: Caixas = " + contadorCaixas);
        System.out.println("Quantidade de funcionários: Gerentes = " + contadorGerentes);
    }

    public void imprimirInformacaoProdutos() {
        int contadorAlimentoDuravel = 0;
        int contadorAlimentoPerecivel = 0;
        int contadorBebidaAlcoolica = 0;
        int contadorBebidaNaoAlcoolica = 0;

        for (Produto produto : consumiveis) {
            System.out.println(produto);
            if (produto instanceof AlimentoDuravel) {
                contadorAlimentoDuravel++;
            } else if (produto instanceof AlimentoPerecivel) {
                contadorAlimentoPerecivel++;
            } else if (produto instanceof BebidaAlcoolica) {
                contadorBebidaAlcoolica++;
            } else if (produto instanceof BebidaNaoAlcoolica) {
                contadorBebidaNaoAlcoolica++;
            }
        }

        System.out.println("Quantidade de Produtos: Alimento Duravel = " + contadorAlimentoDuravel);
        System.out.println("Quantidade de Produtos: Alimento Perecivel = " + contadorAlimentoPerecivel);
        System.out.println("Quantidade de Produtos: Bebida Alcoolica = " + contadorBebidaAlcoolica);
        System.out.println("Quantidade de Produtos: Bebida Nao Alcoolica = " + contadorBebidaNaoAlcoolica);
    }

    public String exibirCustos() {
        double total = 0;
        double totalRepositores = 0;
        double totalGerentes = 0;
        double totalCaixas = 0;

        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof Repositor) {
                totalRepositores += funcionario.calcularSalario();
            } else if (funcionario instanceof Caixa) {
                totalCaixas += funcionario.calcularSalario();
            } else if (funcionario instanceof Gerente) {
                totalGerentes += funcionario.calcularSalario();
            }
            total += funcionario.calcularSalario();
        }

        String resultado = "Descritivo - Custo:\n";
        resultado += "Valor total dos salários: " + total + "\n";
        resultado += "Valor total dos salários dos gerentes: " + totalGerentes + "\n";
        resultado += "Valor total dos salários dos caixas: " + totalCaixas + "\n";
        resultado += "Valor total dos salários dos repositores: " + totalRepositores;
        return resultado;
    }

    public String exibirPreco() {
        double total = 0;
        double totalComida = 0;
        double totalBebida = 0;

        for (Produto produto : consumiveis) {
            total += produto.calcularValor();
            if (produto instanceof Comida) {
                totalComida += produto.calcularValor();
            } else if (produto instanceof Bebida) {
                totalBebida += produto.calcularValor();
            }
        }

        String resultado = "Descritivo - Vendas:\n";
        resultado += "Valor Total: " + total + "\n";
        resultado += "Valor Total de Comida: " + totalComida + "\n";
        resultado += "Valor Total de Bebida: " + totalBebida;
        return resultado;
    }

    public double exibirCustosConsole() {
        double total = 0;
        double totalRepositores = 0;
        double totalGerentes = 0;
        double totalCaixas = 0;

        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);

            if (funcionario instanceof Repositor) {
                totalRepositores += funcionario.calcularSalario();
            } else if (funcionario instanceof Caixa) {
                totalCaixas += funcionario.calcularSalario();
            } else if (funcionario instanceof Gerente) {
                totalGerentes += funcionario.calcularSalario();
            }
            total += funcionario.calcularSalario();
        }

        System.out.println("Descritivo:");
        System.out.println("Valor total dos salários: " + total);
        System.out.println("Valor total dos salários dos gerentes: " + totalGerentes);
        System.out.println("Valor total dos salários dos caixas: " + totalCaixas);
        System.out.println("Valor total dos salários dos repositores: " + totalRepositores);
        return 0;
    }

    public double exibirPrecoConsole() {
        double total = 0;
        double totalComida = 0;
        double totalBebida = 0;

        for (int i = 0; i < consumiveis.size(); i++) {
            if (consumiveis.get(i) instanceof Produto) {
                total += consumiveis.get(i).calcularValor();
            }
        }
        for (int i = 0; i < consumiveis.size(); i++) {
            if (consumiveis.get(i) instanceof Comida) {
                totalComida += consumiveis.get(i).calcularValor();
            }
        }
        for (int i = 0; i < consumiveis.size(); i++) {
            if (consumiveis.get(i) instanceof Bebida) {
                totalBebida += consumiveis.get(i).calcularValor();
            }
        }

        System.out.println("Descritivo:");
        System.out.println("Valor Total: " + total);
        System.out.println("Valor Total de Comida: " + totalComida);
        System.out.println("Valor Total de Bebida: " + totalBebida);
        return 0;
    }

    // for(int i = 0; i < funcionarios.length; i++){
    // total += consumiveis[i].calcularValor();
    // totalComida+=consumiveis[i].calcularValor();
    // totalBebida+=consumiveis[i].calcularValor();
    // }

    public void cadastrarFuncionario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a idade do funcionario: ");
        int idade = sc.nextInt();
        System.out.println("Digite o nome do funcionario: ");
        String nome = sc.next();
        int id = 0;
        try {
            id = UUID.randomUUID().hashCode();
        } catch (JaCadastrado e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        System.out.println("Digite o salario fixo do funcionario: ");
        double salarioFixo = sc.nextDouble();
        System.out.println("Digite a quantidade de horas extras do funcionario: ");
        int quantidadeHorasExtras = sc.nextInt();
        System.out.println("Digite a escolaridade do funcionario: ");
        String escolaridade = sc.next();
        System.out.println("Digite o valor ganho de cada hora extra do funcionario: ");
        String castro = sc.nextLine();
        int horaExtra = sc.nextInt();
        System.out.println("Digite o cargo do funcionario: ");
        String cargo = sc.next();

        try {
            if (cargo.equals("Gerente")) {
                this.funcionarios
                        .add(new Gerente(idade, nome, id, horaExtra, escolaridade, quantidadeHorasExtras, salarioFixo));
            } else if (cargo.equals("Caixa")) {
                this.funcionarios
                        .add(new Caixa(idade, nome, id, horaExtra, escolaridade, quantidadeHorasExtras, salarioFixo));
            } else if (cargo.equals("Repositor")) {
                this.funcionarios.add(
                        new Repositor(idade, nome, salarioFixo, id, horaExtra, escolaridade, quantidadeHorasExtras));
            }
        } catch (WrongNameException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void cadastrarProduto() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do produto: ");
        String nome = sc.next();
        System.out.println("Digite o preço do produto: ");
        double preco = sc.nextDouble();
        System.out.println("Digite o tipo do produto: ");
        String tipo = sc.next();

        if (tipo.equals("Comida")) {
            System.out.println("Digite a data de validade do produto: ");
            String dataValidade = sc.next();
            LocalDate data = LocalDate.parse(dataValidade, formatter);

            System.out.println("Digite o tipo do produto (duravel ou perecivel): ");
            String tipoProduto = sc.next();
            System.out.println("Digite o imposto do produto: ");
            double imposto = sc.nextDouble();
            System.out.println("Digite a marca do produto: ");
            String marca = sc.next();

            try {
                if (tipoProduto.equals("duravel")) {
                    this.consumiveis.add(new AlimentoDuravel(data, preco, nome, marca, imposto));
                } else {
                    this.consumiveis.add(new AlimentoPerecivel(data, preco, nome, marca, imposto));
                }
            } catch (WrongNameException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        } else if (tipo.equals("Bebida")) {
            System.out.println("Digite a validade do produto");
            String validade = sc.next();
            LocalDate data = LocalDate.parse(validade, formatter);

            System.out.println("Digite a marca do produto");
            String marca = sc.next();
            System.out.println("É uma bebida alcoolica? (true para sim, false para não)");
            boolean eAlcoolica = sc.nextBoolean();
            System.out.println("Digite o imposto do produto");
            double imposto = sc.nextDouble();

            try {
                if (eAlcoolica) {
                    this.consumiveis.add(new BebidaAlcoolica(data, preco, nome, marca, imposto));
                } else {
                    this.consumiveis.add(new BebidaNaoAlcoolica(data, preco, nome, marca, imposto));
                }
            } catch (WrongNameException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }

    }

    public void CadastrarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a idade do Cliente: ");
        int idade = sc.nextInt();
        System.out.println("Digite o nome do Cliente: ");
        String nome = sc.next();

        int cadastro = 0;
        try {
            cadastro = UUID.randomUUID().hashCode();
        } catch (JaCadastrado e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        System.out.println("Digite o gasto do cliente");
        double gasto = sc.nextDouble();

        this.clientes.add(new Cliente(idade, nome, cadastro, gasto));
    }

    public void ListarClientes() {
        int contadorClientes = 0;

        for (Cliente cliente : clientes) {
            System.out.println(cliente);

            if (cliente instanceof Cliente) {
                contadorClientes++;
            }
        }

        System.out.println("Quantidade de Clientes = " + contadorClientes);
    }

    public void escreverDados() {
        String path = "src\\Files\\DadosFinais.txt";
        criarArquivo(path);
        try {
            FileWriter fw = new FileWriter(path);
            fw.write(exibirCustos() + "\n" + "\n" + exibirPreco());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERRO");
        }
    }

    public static void criarArquivo(String path) {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERRO");
        }
    }

}