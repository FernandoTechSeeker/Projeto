package Unidade4;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main { 
    private static List<Carro> carros = new ArrayList<>();
    private static List<Moto> motos = new ArrayList<>();
    private static List<Pessoa> clientes = new ArrayList<>();
    private static List<Venda> vendas = new ArrayList<>();
    private static List<Van> vans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;
        do {
            try {
                System.out.println("#### Menu Concessionária ");
                System.out.println("1 - Mostrar Veículos ");
                System.out.println("2 - Comprar Veículo ");
                System.out.println("3 - Vender Veículo ");
                System.out.println("4 - Cadastrar Cliente ");
                System.out.println("5 - Gerar Relatório ");
                System.out.println("6 - Mostrar Clientes ");
                System.out.println("0 - Sair ");
                System.out.println("Escolha uma opção: ");
                escolha = scanner.nextInt();
                scanner.nextLine();

                switch (escolha) {
                    case 1:
                        mostrarVeiculos();
                        break;
                    case 2:
                        comprarVeiculo(scanner);
                        break;
                    case 3:
                        venderVeiculo(scanner);
                        break;
                    case 4:
                        cadastrarCliente(scanner);
                        break;
                    case 5:
                        gerarRelatorio();
                        break;
                    case 6:
                        mostrarClientes();
                    case 0:
                        System.out.println("Fechando o programa...");
                        break;
                    default:
                        System.out.println("Opção Inválida! Tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Certifique-se de inserir os dados corretamente!");
                scanner.nextLine(); // Limpa o buffer
            } catch (Exception e) {
                System.out.println("Erro desconhecido: " + e.getMessage());
            }
        } while (escolha != 0);

        scanner.close();
    }

    private static void mostrarVeiculos() {
        mostrarCarros();
        System.out.println("--------------------------");
        mostrarMotos();
        System.out.println("--------------------------");
        mostrarVans();
    }

    private static void mostrarCarros() {
        if (!carros.isEmpty()) {
            System.out.println("### Lista de carros: ###");
            int x = 1;
            for (Carro carro : carros) {
                System.out.println(x + " - " + carro.getModelo() + " - " + carro.getAno());
                x++;
            }
        } else {
            System.out.println("Nenhum carro foi encontrado!");
        }
    }

    private static void mostrarMotos() {
        if (!motos.isEmpty()) {
            System.out.println("### Lista de motos: ###");
            int x = 1;
            for (Moto moto : motos) {
                System.out.println(x + " - " + moto.getModelo() + " - " + moto.getAno());
                x++;
            }
        } else {
            System.out.println("Nenhuma moto foi encontrada!");
        }
    }

    private static void mostrarVans() {
        if (!vans.isEmpty()) {
            System.out.println("### Lista de vans: ###");
            int x = 1;
            for (Van van : vans) {
                System.out.println(x + " - " + van.getModelo() + " - " + van.getAno());
                x++;
            }
        } else {
            System.out.println("Nenhuma van foi encontrada!");
        }
    }
    private static void mostrarClientes() {
            if (!clientes.isEmpty()) {
                System.out.println("### Lista de clientes cadastrados: ###");
                int x = 1;
                for (Pessoa cliente : clientes) {
                    System.out.println(x + " - Nome: " + cliente.getNome() + " | Telefone: " + cliente.getTel());
                    x++;
                }
            } else {
                System.out.println("Nenhum cliente cadastrado no sistema!");
            }
        }
        
      
    

    private static void comprarVeiculo(Scanner scanner) {
        try {
            System.out.println("### Compra de Veículo ###");
            System.out.println("1 - Carro");
            System.out.println("2 - Moto");
            System.out.println("3 - Van");
            System.out.println("0 - Voltar ao menu");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha < 0 || escolha > 3) {
                throw new InputMismatchException();
            }

            while (escolha != 0) {
                System.out.println("Digite a marca do veículo: ");
                String marca = scanner.nextLine();

                System.out.println("Digite o modelo do veículo: ");
                String modelo = scanner.nextLine();

                System.out.println("Digite o ano do veículo: ");
                int ano = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Digite a cor do veículo: ");
                String cor = scanner.nextLine();

                System.out.println("Digite o preço do veículo: ");
                double preco = scanner.nextDouble();
                scanner.nextLine();

                switch (escolha) {
                    case 1:
                        System.out.println("Digite o número de portas do veículo: ");
                        int nPortas = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Digite o tipo de combustível: ");
                        String tipoCombustivel = scanner.nextLine();

                        System.out.println("Digite a capacidade do porta-malas do veículo: ");
                        int capacidadePortaMalas = scanner.nextInt();
                        scanner.nextLine();

                        Carro carro = new Carro(marca, modelo, ano, cor, preco, nPortas, tipoCombustivel, capacidadePortaMalas);
                        carros.add(carro);
                        System.out.println("Carro modelo: " + modelo + " cadastrado com sucesso!");
                        escolha = 0;
                        break;

                    case 2:
                        System.out.println("Digite as cilindradas do veículo: ");
                        int cilindradas = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("O veículo possui partida elétrica? (S/N)");
                        boolean partidaEletrica = scanner.nextLine().equalsIgnoreCase("S");

                        System.out.println("Digite a categoria do veículo: ");
                        String categoria = scanner.nextLine();

                        Moto moto = new Moto(marca, modelo, ano, cor, preco, cilindradas, partidaEletrica, categoria);
                        motos.add(moto);
                        System.out.println("Moto modelo: " + modelo + " cadastrada com sucesso!");
                        escolha = 0;
                        break;

                    case 3:
                        System.out.println("Digite o número de portas do veículo: ");
                        int numeroDePortas = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Digite o tipo de combustível: ");
                        String tipoCombustivelVan = scanner.nextLine();

                        System.out.println("Digite a quantidade de assentos do veículo: ");
                        int quantidadeAcentos = scanner.nextInt();
                        scanner.nextLine();

                        Van van = new Van(marca, modelo, ano, cor, preco, numeroDePortas, tipoCombustivelVan, quantidadeAcentos);
                        vans.add(van);
                        System.out.println("Van modelo: " + modelo + " cadastrada com sucesso!");
                        escolha = 0;
                        break;

                    default:
                        System.out.println("Opção Inválida! Tente novamente.");
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de inserir os dados corretamente!");
            scanner.nextLine(); // Limpa o buffer
        } catch (Exception e) {
            System.out.println("Erro desconhecido: " + e.getMessage());
        }
    }

    private static void venderVeiculo(Scanner scanner) {
        try {
            if (clientes.isEmpty() || (carros.isEmpty() && motos.isEmpty() && vans.isEmpty())) {
                if (clientes.isEmpty()) {
                    System.out.println("Não há clientes na base de dados!");
                }
                if (carros.isEmpty()) {
                    System.out.println("Não há carros disponíveis para vendas!");
                }
                if (motos.isEmpty()) {
                    System.out.println("Não há motos disponíveis para vendas!");
                }
                if (vans.isEmpty()) {
                    System.out.println("Não há vans disponíveis para vendas!");
                }
            } else {
                mostrarClientes();
                Pessoa comprador = clientes.get(scanner.nextInt() - 1);
                scanner.nextLine();

                System.out.println("Informe o valor da venda: R$");
                double valor = scanner.nextDouble();
                scanner.nextLine();

                int escolha;

                System.out.println("Qual o veículo deseja vender? ");
                System.out.println("1 - Carro");
                System.out.println("2 - Moto");
                System.out.println("3 - Van");
                escolha = scanner.nextInt();
                scanner.nextLine();

                switch (escolha) {
                    case 1:
                        mostrarCarros();
                        Carro carroParaVenda = carros.get(scanner.nextInt() - 1);
                        scanner.nextLine();

                        Venda novaVendaCarro = new Venda(carroParaVenda, comprador, valor, LocalDateTime.now());
                        vendas.add(novaVendaCarro);
                        carros.remove(carroParaVenda);
                        break;

                    case 2:
                        mostrarMotos();
                        Moto motoParaVenda = motos.get(scanner.nextInt() - 1);
                        scanner.nextLine();

                        Venda novaVendaMoto = new Venda(motoParaVenda, comprador, valor, LocalDateTime.now());
                        vendas.add(novaVendaMoto);
                        motos.remove(motoParaVenda);
                        break;

                    case 3:
                        mostrarVans();
                        Van vanParaVenda = vans.get(scanner.nextInt() - 1);
                        scanner.nextLine();

                        Venda novaVendaVan = new Venda(vanParaVenda, comprador, valor, LocalDateTime.now());
                        vendas.add(novaVendaVan);
                        vans.remove(vanParaVenda);
                        break;

                    default:
                        System.out.println("Opção Inválida! Tente novamente.");
                        break;
                }
                System.out.println("Venda executada com sucesso!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de inserir os dados corretamente!");
            scanner.nextLine(); // Limpa o buffer
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro: Índice inválido. Certifique-se de escolher uma opção correta!");
        } catch (Exception e) {
            System.out.println("Erro desconhecido: " + e.getMessage());
        }
    }

    private static void cadastrarCliente(Scanner scanner) {
        try {
            System.out.println("### Cadastro Cliente");

            System.out.println("Digite o nome do cliente: ");
            String nome = scanner.nextLine();

            System.out.println("Digite a idade do cliente: ");
            int idade = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o endereço do cliente: ");
            String endereco = scanner.nextLine();

            System.out.println("Digite o telefone para contato do cliente: ");
            String telefone = scanner.nextLine();

            System.out.println("Digite o email do cliente: ");
            String email = scanner.nextLine();

            System.out.println("Digite a altura do cliente: ");
            double altura = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Digite o peso do cliente: ");
            double peso = scanner.nextDouble();
            scanner.nextLine();

            Pessoa novoCliente = new Pessoa(nome, idade, endereco, telefone, email, altura, peso);
            clientes.add(novoCliente);

            System.out.println("Cliente: " + nome + " foi cadastrado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de inserir os dados corretamente!");
            scanner.nextLine(); // Limpa o buffer
        } catch (Exception e) {
            System.out.println("Erro desconhecido: " + e.getMessage());
        }
    }

    private static void gerarRelatorio() {
        if (vendas.isEmpty()) {
            System.out.println("Não existem vendas cadastradas!");
        } else {
            System.out.println("### Relatório de vendas ###");
            for (Venda venda : vendas) {
                System.out.println("Data: " + venda.getDataVenda());
                System.out.println("Veículo: " + venda.getVeiculo().getModelo() + " - " + venda.getVeiculo().getAno());
                System.out.println("Comprador: " + venda.getComprador().getNome() + " - " + venda.getComprador().getTel());
                System.out.println("Valor da venda: R$ " + venda.getValor());
                System.out.println("----------------------------------------------");
            }
        }
    }
}
