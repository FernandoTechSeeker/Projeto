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
                System.out.println("7 - Sugerir Veículo por Biotipo do Cliente");
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
                        case 7:
    if (!clientes.isEmpty()) {
        mostrarClientes(); // Exibe a lista de clientes
        System.out.println("Escolha um cliente pelo índice: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        if (indice > 0 && indice <= clientes.size()) {
            Pessoa clienteEscolhido = clientes.get(indice - 1);
            sugerirVeiculoPorBiotipo(clienteEscolhido);
        } else {
            System.out.println("Erro: Cliente não encontrado!");
        }
    } else {
        System.out.println("Não há clientes cadastrados para sugerir veículos.");
    }
    break;

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
        System.out.println("--------------------------");
    
        
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
        System.out.println("--------------------------");
    
        
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
                    System.out.println("Não há carros disponíveis para venda!");
                }
                if (motos.isEmpty()) {
                    System.out.println("Não há motos disponíveis para venda!");
                }
                if (vans.isEmpty()) {
                    System.out.println("Não há vans disponíveis para venda!");
                }
            } else {
                // Mostrar clientes para escolher um comprador
                mostrarClientes();
                System.out.println("Escolha o cliente pelo índice: ");
                Pessoa comprador = clientes.get(scanner.nextInt() - 1);
                scanner.nextLine();
    
                System.out.println("Informe o valor da venda: R$ ");
                double valor = scanner.nextDouble();
                scanner.nextLine();
    
                // Perguntar qual veículo deseja vender
                System.out.println("Qual o tipo de veículo a ser vendido?");
                System.out.println("1 - Carro");
                System.out.println("2 - Moto");
                System.out.println("3 - Van");
                int escolha = scanner.nextInt();
                scanner.nextLine();
    
                switch (escolha) {
                    case 1:
                        if (!carros.isEmpty()) {
                          
                            System.out.println("### Lista de Carros: ###");
                            int x = 1;
                            for (Carro carro : carros) {
                                System.out.println(x + " - " + carro.getModelo() + " | Ano: " + carro.getAno() + " | Preço: R$" + carro.getPreco());
                                x++;
                            }
                            System.out.println("Escolha o carro pelo índice: ");
                            Carro carroParaVenda = carros.get(scanner.nextInt() - 1);
                            scanner.nextLine();
    
                            Venda novaVendaCarro = new Venda(carroParaVenda, comprador, valor, LocalDateTime.now());
                            vendas.add(novaVendaCarro);
                            carros.remove(carroParaVenda);
                            System.out.println("Venda realizada com sucesso!");
                        } else {
                            System.out.println("Não há carros disponíveis para venda!");
                        }
                        break;
    
                    case 2:
                        if (!motos.isEmpty()) {
                            
                            System.out.println("### Lista de Motos: ###");
                            int x = 1;
                            for (Moto moto : motos) {
                                System.out.println(x + " - " + moto.getModelo() + " | Ano: " + moto.getAno() + " | Preço: R$" + moto.getPreco());
                                x++;
                            }
                            System.out.println("Escolha a moto pelo índice: ");
                            Moto motoParaVenda = motos.get(scanner.nextInt() - 1);
                            scanner.nextLine();
    
                            Venda novaVendaMoto = new Venda(motoParaVenda, comprador, valor, LocalDateTime.now());
                            vendas.add(novaVendaMoto);
                            motos.remove(motoParaVenda);
                            System.out.println("Venda realizada com sucesso!");
                        } else {
                            System.out.println("Não há motos disponíveis para venda!");
                        }
                        break;
    
                    case 3:
                        if (!vans.isEmpty()) {
                            
                            System.out.println("### Lista de Vans: ###");
                            int x = 1;
                            for (Van van : vans) {
                                System.out.println(x + " - " + van.getModelo() + " | Ano: " + van.getAno() + " | Preço: R$" + van.getPreco());
                                x++;
                            }
                            System.out.println("Escolha a van pelo índice: ");
                            Van vanParaVenda = vans.get(scanner.nextInt() - 1);
                            scanner.nextLine();
    
                            Venda novaVendaVan = new Venda(vanParaVenda, comprador, valor, LocalDateTime.now());
                            vendas.add(novaVendaVan);
                            vans.remove(vanParaVenda);
                            System.out.println("Venda realizada com sucesso!");
                        } else {
                            System.out.println("Não há vans disponíveis para venda!");
                        }
                        break;
    
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de inserir os dados corretamente!");
            scanner.nextLine(); 
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
    private static void sugerirVeiculoPorBiotipo(Pessoa cliente) {
        System.out.println("Analisando biotipo do cliente...");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Altura: " + cliente.getAltura() + " cm");
        System.out.println("Peso: " + cliente.getPeso() + " kg");
        System.out.println("Idade: " + cliente.getIdade() + " anos");
    
        // Lógica de sugestão
        if (cliente.getAltura() > 180 || cliente.getPeso() > 90) {
            System.out.println("Sugerimos uma Van para o cliente: mais espaçosa e confortável!");
        } else if (cliente.getIdade() < 25 && cliente.getPeso() < 80) {
            System.out.println("Sugerimos uma Moto para o cliente: prática e ideal para jovens!");
        } else {
            System.out.println("Sugerimos um Carro para o cliente: ideal para uso geral!");
        }
    }
    
  


}
