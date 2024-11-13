package Unidade4;

public class Main { 
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("Chevrolet", "Onix", 2015, "Prata", 45000.00);
        Carro carro = new Carro("Chevrolet", "Onix", 2015, "Prata", 45000.00, 5, "Flex", 200);
        Moto moto = new Moto("Kawasaky ", "Ninja 900   ", 2019, "Verde", 55000.00, 900, true, "Head");
        Pessoa pessoa = new Pessoa("Fernando", 35, "José simões", "31989751548  ", "facnto08@gmaidl.covm    ", 174, 80);
        System.out.println(veiculo.getModelo());

        veiculo.exibirInformacoes();

        veiculo.acelerar(100);
        veiculo.frear(50);
        System.out.println();

        carro.exibirInformacoes();
        carro.abrirPortaMalas();
        carro.fecharPortaMalas();

        System.out.println();

        moto.exibirInformacoes();
        moto.empinar();

        pessoa.exibirInformacoes();
        pessoa.fazerAniversario();
        pessoa.exibirInformacoes();
       
    }
    
    
}
