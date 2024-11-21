package Unidade4;

public class Van  extends Veiculo{
    private int nPortas;
    private String tipoCombustivel;
    private int quantidadeAssento;

    public Van(String marca, String modelo, int ano, String cor, double preco, 
    int nPortas, String tipoCombustivel, int quantidadeAssento){

        super(marca, modelo, ano, cor, preco);
        this.nPortas = nPortas;
        this.tipoCombustivel = tipoCombustivel;
        this.quantidadeAssento = quantidadeAssento;
        
        }
        public void abrirPortaMalas(){
            System.out.println("Abrindo porta malas....");
    
        }
        public void fecharPortaMalas(){
            System.out.println("Fechando porta malas....");
        }
        public int getnPortas() {
            return nPortas;
        }
        public String getTipoCombustivel() {
            return tipoCombustivel;
        }
        public int getQuantidadeAcento() {
            return quantidadeAssento;
        }
        public void setnPortas(int nPortas) {
            this.nPortas = nPortas;
        }
        public void setTipoCombustivel(String tipoCombustivel) {
            this.tipoCombustivel = tipoCombustivel;
        }
        public void setQuantidadeAcento(int quantidadeAcento) {
            this.quantidadeAssento = quantidadeAssento;
        }
    
        @Override
        public void exibirInformacoes() {
            super.exibirInformacoes();  
            System.out.println("Numero de portas:            "+nPortas);
            System.out.println("Tipo de combustivél:         "+tipoCombustivel);
            System.out.println("Quantidades de assentos:   "+quantidadeAssento+" nessa Sprinter");
        
    }
    
}
