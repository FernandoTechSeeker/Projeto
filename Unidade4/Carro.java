package Unidade4;

public class Carro extends Veiculo{
    private int nPortas;
    private String tipoCombustivel;
    private int capacidadePortaMalas;

    public Carro(String marca, String modelo, int ano, String cor, double preco, 
    int nPortas, String tipoCombustivel, int capacidadePortaMalas){

        super(marca, modelo, ano, cor, preco);
        this.nPortas = nPortas;
        this.tipoCombustivel = tipoCombustivel;
        this.capacidadePortaMalas = capacidadePortaMalas;
    }

    public void abrirPortaMalas(){

    }
    public void fecharPortaMalas(){

    }
    
}
