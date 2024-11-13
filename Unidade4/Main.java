package Unidade4;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main { 
    private static List<Carro> carros = new ArrayList<>();
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("Chevrolet", "Onix", 2015, "Prata", 45000.00);
        Carro carro = new Carro("Chevrolet", "Onix", 2015, "Prata", 45000.00, 5, "Flex", 200);
        Moto moto = new Moto("Kawasaky ", "Ninja 900   ", 2019, "Verde", 55000.00, 900, true, "Head");
        Pessoa pessoa = new Pessoa("Fernando", 35, "José simões", "31989751548  ", "facnto08@gmaidl.covm    ", 174, 80);
        Venda venda = new Venda(carro, pessoa, 50000, LocalDateTime.now());
       
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;
        do{
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
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 0:
                    System.out.println("Fechando o programa...");
                    break;
                default:
                System.out.println("Opção Inválida! Tente novamente.");
                    
            }
            
        }while(escolha != 0);

        scanner.close();
       
    }
    private static void mostrarVeiculos(){
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


    
    
}
