package Unidade4;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main { 
    private static List<Carro> carros = new ArrayList<>();
    private static List<Moto> motos = new ArrayList<>();
    private static List<Pessoa> clientes= new ArrayList<>();
    private static List<Venda> vendas= new ArrayList<>();

    public static void main(String[] args) {
        // Veiculo veiculo = new Veiculo("Chevrolet", "Onix", 2015, "Prata", 45000.00);
        // Carro carro = new Carro("Chevrolet", "Onix", 2015, "Prata", 45000.00, 5, "Flex", 200);
        // Moto moto = new Moto("Kawasaky ", "Ninja 900   ", 2019, "Verde", 55000.00, 900, true, "Head");
        // Pessoa pessoa = new Pessoa("Fernando", 35, "José simões", "31989751548  ", "facnto08@gmaidl.covm    ", 174, 80);
        // Venda venda = new Venda(carro, pessoa, 50000, LocalDateTime.now());
       
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;
        do{
            try{
            System.out.println("#### Menu Concessionária ");
            System.out.println("1 - Mostrar Veiculos ");
            System.out.println("2 - Comprar Veiculo ");
            System.out.println("3 - Vender Veiculo ");
            System.out.println("4 - Cadastrar Cliente ");
            System.out.println("5 - Gerar Relatório ");
            System.out.println("0 -Sair ");
            System.out.println("Escolha um opção: ");
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
                    cadrastrarCliente(scanner);
                    break;
                case 5:
                    gerarRelatorio();
                    break;
                case 0:
                    System.out.println("Fechando o programa...");
                    break;
                default:
                System.out.println("Opção Inválida! Tente novamente.");
                    
            }
            }  catch (InputMismatchException e){
                System.out.println("Erro: Entrada inválida. Cerfifique-se de inserir os dados corretamente!");
                
             
            }catch(Exception e){
                System.out.println("Erro desconhecido: "+e.getMessage());
            }
        }while(escolha != 0);

        scanner.close();
       
    }
    private static void mostrarVeiculos(){
        mostrarCarros();
        System.out.println("--------------------------");
        mostrarMotos();
    }

    private static void mostrarCarros(){
        if (!carros.isEmpty()) {
            System.out.println("### Lista de carros:  ###");
            int x = 1;
            for (Carro carro : carros) {
                System.out.println(x+" -  "+carro.getModelo()+" - "+carro.getAno());
                x++;
            }
        }else{
            System.out.println("Nenhum carro foi encontrado!");
        }
    }
    
    private static void mostrarMotos(){
        if (!motos.isEmpty()) {
            System.out.println("### Lista de motos:  ###");
            int x = 1;
            for (Moto moto : motos) {
                System.out.println(x+" -  "+moto.getModelo()+" - "+moto.getAno());
                x++;
            }
        }else{
            System.out.println("Nenhuma moto foi encontrado!");
        }

    }


    private static void comprarVeiculo(Scanner scanner) {
            try{
            System.out.println("### Compra de Veiculo ###");
            int escolha;

            System.out.println("Qual o novo Veiculo que deseja cadastrar? ");
            System.out.println("1 - Carro");
            System.out.println("2 - Moto");
            System.out.println( "0 - Voltar ao menu");
            escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha > 2) {
                throw new InputMismatchException();
            }

            while (escolha != 0) {
                System.out.println("Digite a marca do veículo: ");
                String marca = scanner.nextLine();

                System.err.println("Digite o modelo do veiculo: ");
                String modelo = scanner.nextLine();

                System.out.println("Digite o ano do veículo: ");
                int ano = scanner.nextInt();

                System.out.println("Digite a cor do veículo: ");
                String cor = scanner.nextLine();
                scanner.nextLine();
            
                System.out.println("Digite o preço do veículo: ");
                double preco = scanner.nextDouble();

                switch (escolha) {
                    case 1:
                        System.out.println("Digite o numero de portas do veículo: ");  
                        int nPortas = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Digite o tipo de combustível: ");
                        String tipoCombustivel = scanner.nextLine();

                        System.out.println("Digite a capacidade do porta malas do veículo: ");
                        int capacidadePortaMalas = scanner.nextInt();

                        Carro carro = new Carro(tipoCombustivel, modelo, ano, cor, preco, nPortas, tipoCombustivel, capacidadePortaMalas);
                        carros.add(carro);
                        System.out.println("Carro modelo: "+modelo+" cadastrado com sucesso:");
                        escolha = 0;
                        break;

                    case 2:
                    System.out.println("Digite as cilindradas do veículos: ");
                    int cilindradas = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("O veículo possui partida eletrica? S - sim, N - não");
                    String partida = scanner.nextLine();
                    boolean partidaEletrica; 
                    if (partida == "S" || partida == "s") {
                        partidaEletrica = true;
                    } else {
                        partidaEletrica = false;
                    }

                    System.out.println("Digite a categoria do veículo: ");
                    String categoria = scanner.nextLine();

                    Moto moto = new Moto(partida, modelo, ano, cor, preco, cilindradas, partidaEletrica, categoria);
                    motos.add(moto);
                    System.out.println("<Moto modelo: "+modelo+" cadastrada com sucesso:");
                    escolha = 0;
                    default:
                    System.out.println("Opção Inválida! Tente novamente.");

                        break;
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Erro: Entrada inválida. Cerfifique-se de inserir os dados corretamente!");
        
         
        }catch(Exception e){
            System.out.println("Erro desconhecido: "+e.getMessage());
        }
    }
     
    private static void venderVeiculo(Scanner scanner) {
        try{
            if (clientes.isEmpty() || (carros.isEmpty() && motos.isEmpty())) {
                if (clientes.isEmpty()) {
                    System.out.println("Não há clientes na base de dados!");
                }
                if (carros.isEmpty()) {
                    System.out.println("Não há carros disponiveis para vendas!");
                }
                if (motos.isEmpty()) {
                    System.out.println("Não há motos disponiveis para vendas!");
                }
            }else{
                mostrarClientes();
                Pessoa comprador = clientes.get(scanner.nextInt()-1);
                scanner.nextLine();

                System.out.println("Informe o valor da venda: R$");
                double valor = scanner.nextDouble();
                scanner.nextLine();

                int escolha; 

                System.out.println("Qual o novo veículo deseja vender? ");
                System.out.println("1 - Carro");
                System.out.println("2 - Moto");
                escolha = scanner.nextInt();
                scanner.nextLine();

                switch (escolha) {
                    case 1:
                        mostrarCarros();
                        Carro carroParaVenda = carros.get(scanner.nextInt() -1);
                        scanner.nextLine();

                        Venda novaVendaCarro = new Venda(carroParaVenda, comprador, valor, LocalDateTime.now());
                        vendas.add(novaVendaCarro);
                        carros.remove(carroParaVenda);
                        break;
                    case 2:
                        mostrarMotos();
                        Moto motoParaVenda = motos.get(scanner.nextInt() -1);
                        scanner.nextLine();

                        Venda novaVendaMoto = new Venda(motoParaVenda, comprador, valor, LocalDateTime.now());
                        vendas.add(novaVendaMoto);
                        motos.remove(motoParaVenda);

                    
                        break;
                }
                System.out.println("Venda executada com sucesso! ");
            }
        }catch (InputMismatchException e){
            System.out.println("Erro: Entrada inválida. Cerfifique-se de inserir os dados corretamente!");
            
        }catch(IndexOutOfBoundsException e ) {   
            System.out.println("Erro: Indice inválido. Certifique-se de escolher uma opção correta!");
        }catch(Exception e){
            System.out.println("Erro desconhecido: "+e.getMessage());
        }
    }                     
    private static void mostrarClientes(){
        if (!clientes.isEmpty()) {
            System.out.println("### Lista de clientes:  ###");
            int x = 1;
            for (Pessoa cliente : clientes) {
                System.out.println(x+" -  "+cliente.getNome()+" - "+cliente.getTel());
                x++;
            }
        }else{
            System.out.println("Nenhum cliente foi encontrado!");
        }

    }
    private static void cadrastrarCliente(Scanner scanner) {
        try{
            System.out.println("### Cadastro Cliente");

            System.out.println("Digite o nome do cliente: ");
            String nome = scanner.nextLine();

            System.out.println("Digite a idade do cliente: ");
            int idade = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o endereço do cliente: ");
            String end = scanner.nextLine();

            System.out.println("Digite o  telefone para contato do cliente: ");
            String tel = scanner.nextLine();

            System.out.println("Digite o email do cliente: ");
            String email = scanner.nextLine();

            System.out.println("Digite a altura do cliente: ");
            double altura = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Digite o peso do cliente: ");
            double peso = scanner.nextDouble();
            scanner.nextLine();

            Pessoa novoCliente = new Pessoa(nome, idade, end, tel, email, altura, peso);
            clientes.add(novoCliente);

            System.out.println("O Cliente: "+nome+", for cadatrad com sucesso!");
        }catch (InputMismatchException e){
            System.out.println("Erro: Entrada inválida. Cerfifique-se de inserir os dados corretamente!");
            
         
        }catch(Exception e){
            System.out.println("Erro desconhecido: "+e.getMessage());
        }
    }
    
    private static void gerarRelatorio() {
        if (vendas.isEmpty()) {
            System.out.println("Não existem vendas cadastradas! ");
        }else{
            System.out.println(" ### Relatório de vendas ###");
            System.out.println();

            for (Venda venda : vendas) {
                System.out.println("Data: "+venda.getDataVenda());
                System.out.println("Veículo: "+venda.getVeiculo().getModelo()+" - "+venda.getVeiculo().getAno());
                System.out.println("Comprador: "+venda.getComprador().getNome()+" - "+venda.getComprador().getTel());
                System.out.println("Valor da venda: R$"+venda.getValor());
                System.out.println("----------------------------------------------");
                System.out.println();
            }
        }

    }
    






}
