package Unidade4;

import java.time.LocalDateTime;

public class Venda {
    private Veiculo veiculo;
    private Pessoa comprador;
    private double valor; 
    private LocalDateTime dataVenda;
    private double precoCompra; 
    
    public Venda(Veiculo veiculo, Pessoa comprador, double valor, double precoCompra, LocalDateTime dataVenda) {
        this.veiculo = veiculo;
        this.comprador = comprador;
        this.valor = valor;
        this.precoCompra = precoCompra; 
        this.dataVenda = dataVenda;
    }

    // Getters e Setters
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Pessoa getComprador() {
        return comprador;
    }

    public double getValor() {
        return valor;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setComprador(Pessoa comprador) {
        this.comprador = comprador;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    
    public void exibirDetalhesVendas() {
        System.out.println("Detalhe da Venda:");
        System.out.println("Veículo: " + veiculo.getModelo() + " - Ano: " + veiculo.getAno());
        System.out.println("Comprador: " + comprador.getNome() + " - Contato: " + comprador.getTel());
        System.out.println("Preço de Compra: R$ " + precoCompra);
        System.out.println("Valor da Venda: R$ " + valor);

        double diferenca = valor - precoCompra; 
        if (diferenca > 0) {
            System.out.println("Resultado: Lucro de R$ " + diferenca);
        } else if (diferenca < 0) {
            System.out.println("Resultado: Prejuízo de R$ " + Math.abs(diferenca));
        } else {
            System.out.println("Resultado: Sem lucro nem prejuízo.");
        }

        System.out.println("Data da Venda: " + dataVenda);
    }
}
