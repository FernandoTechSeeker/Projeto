package Unidade4;

public class Pessoa {
    private String nome;
    private int idade; 
    private String end; 
    private String tel; 
    private String email;
    private double altura;
    private double peso; 

    public Pessoa (String nome, int idade, String end, String tel, String email, double altura, double peso){
        this.nome = nome;
        this.idade = (idade);
        this.end =  end;
        this.tel = tel; 
        this.email = email;
        this.altura = altura;
        this.peso = peso;
    
    }
    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }
    public String getEnd() {
        return end;
    }
    public String getTel() {
        return tel;
    }
    public String getEmail() {
        return email;
    }
    public double getAltura() {
        return altura;
    }
    public double getPeso() {
        return peso;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setEnd(String end) {
        this.end = end;
    }public void setTel(String tel) {
        this.tel = tel;
    }public void setEmail(String email) {
        this.email = email;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void fazerAniversario(){
        idade++;
        System.out.println("Feliz aniversário, "+nome+". Agora você está com "+idade+" anos! Parabéns...!");
        
    }

    public void exibirInformacoes(){
        System.out.println("Nome:       "+nome);
        System.out.println("Idade:      "+idade);
        System.out.println("Endereço:   "+end);
        System.out.println("Telefona:   "+tel);
        System.out.println("Email:      "+email);
        System.out.println("Altura:     "+altura+" CM");
        System.out.println("Peso:       "+peso+" KG");

    }
}
