import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entidades.*;
import Exceções.NumeroNaoExistente;
public class App {
    private static List<Produto> LerProdutos() {
        List<Produto> consumiveis = new ArrayList<Produto>();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        String pathDados = "C:\\Users\\Leona\\Downloads\\javaAula\\Trabalho-POO\\src\\Files\\Dados.txt";
        File fileDados = new File(pathDados);
        Scanner sc = null;
        ArrayList<Object> dados = new ArrayList<>();
        try{
            sc = new Scanner(fileDados);
            while(sc.hasNext()){

                String dataValidade = sc.next();
                LocalDate data = LocalDate.parse(dataValidade, fmt);
                double preco = sc.nextDouble();
                String nome = sc.next();
                String marca = sc.next();
                double imposto = sc.nextDouble();

                dados.add(data);
                dados.add(preco);
                dados.add(nome);
                dados.add(marca);
                dados.add(imposto);

                consumiveis.add(new AlimentoPerecivel(data, preco, nome, marca, imposto));
                return consumiveis;
            }
        }catch(FileNotFoundException e){
            Supermercado.criarArquivo(pathDados);
        }
        for (Object elemento : dados) {
            System.out.println(elemento);
        }
        return null;
    }
    public static void main(String[] args) throws Exception {
        
        
        menuPrincipal();
        
    }

    private static void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("Escolha a opção de login:");
            System.out.println("1 - Login Gerente");
            System.out.println("2 - Login Caixa");
            System.out.println("3 - Sair");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    loginGerente();
                    break;
                case 2:
                    loginCaixa();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

    } 

    public static void loginGerente() {
        Supermercado supermercado = new Supermercado();
        for (Produto p : LerProdutos()) {
            
            supermercado.CadastrarProdutoDireto(p);
        }
        Scanner sc = new Scanner(System.in);
        boolean loggedIn = false;
    
        while (!loggedIn) {
            System.out.println("Digite seu login: ");
            int login = sc.nextInt();
            if (login == 1) {
                System.out.println("Digite sua senha: ");
                int senha = sc.nextInt();
                if (senha == 123) {
                    loggedIn = true;
                    boolean sair = false;
                    while (!sair) {
                        menuGerente();
                        int entrada = sc.nextInt();
                        switch (entrada) {
                            case 1:
                                supermercado.cadastrarFuncionario();
                                break;
                            case 2:
                                supermercado.cadastrarProduto();
                                break;
                            case 3:
                                supermercado.CadastrarCliente();
                                break;
                            case 4:
                                supermercado.imprimirInformacaoFuncionarios();
                                break;
                            case 5:
                                supermercado.imprimirInformacaoProdutos();
                                break;
                            case 6:
                                supermercado.ListarClientes();
                                break;
                            case 7:
                                supermercado.exibirPrecoConsole();
                                break;
                            case 8:
                                supermercado.exibirCustosConsole();
                                break;
                            case 9:
                                supermercado.escreverDados();
                                break;
                            case 10:
                                System.out.println("Saindo...");
                                sair = true;
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    }
                } else {
                    throw new IllegalStateException("Senha inválida.");
                }
            } else {
                throw new IllegalStateException("Login inválido.");
            }
        }

    }

    public static void loginCaixa() {
        Supermercado supermercado = new Supermercado();
        Scanner sc = new Scanner(System.in);
        boolean loggedIn = false;
    
    try {
        while (!loggedIn) {
            System.out.println("Digite seu login: ");
            int login = sc.nextInt();
            if (login == 2) {
                System.out.println("Digite sua senha: ");
                int senha = sc.nextInt();
                if (senha == 123) {
                    loggedIn = true;
                    boolean sair = false;
    
                    while (!sair) {
                        menuCaixa();
                        int entrada = sc.nextInt();
                        switch (entrada) {
                            case 1:
                               supermercado.cadastrarProduto();
                                break;
                            case 2:
                                supermercado.CadastrarCliente();
                                break;
                            case 3:
                                supermercado.ListarClientes();
                                break;   
                            case 4:
                                supermercado.imprimirInformacaoProdutos();
                                break;
                            case 5:
                                System.out.println("Saindo...");
                                sair = true;
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    }
                } else {
                    throw new IllegalStateException("Senha inválida.");
                }
            } else {
                throw new IllegalStateException("Login inválido.");
            }
        }
        }catch (NumeroNaoExistente e) {
        System.out.println("Numero não existente");
    }
    }
    

    private static void menuGerente(){
        System.out.println("1 - Cadastrar funcionario");
        System.out.println("2 - Cadastrar produto");
        System.out.println("3 - Cadastrar cliente");
        System.out.println("4 - Listar funcionarios");
        System.out.println("5 - Listar produtos");
        System.out.println("6 - Listar clientes");
        System.out.println("7 - Exibir vendas");
        System.out.println("8 - Exibir custos");
        System.out.println("9 - Imprimir os dados");
        System.out.println("10 - Sair");
    }

    private static void menuCaixa(){
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Cadastrar cliente");
        System.out.println("3 - Listar clientes");
        System.out.println("4 - Listar produtos");
        System.out.println("5 - Sair");
    }

}