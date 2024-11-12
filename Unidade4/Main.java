package Unidade4;

public class Main { 
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("Chevrolet", "Onix", 2015, "Prata", 45000.00);

        System.out.println(veiculo.getModelo());

        veiculo.exibirInformacoes();

        veiculo.acelerar(100);
    }
    
}
