package org.example.Imagem1;

public class Terno {
    private String cor;
    private String tamanho;
    private double preco;

    public Terno(String cor, String tamanho, double preco) {
        this.cor = cor;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public void aplicarDesconto(double percentual) { this.preco -= this.preco * (percentual / 100); }
    public void reajustarPreco(double valor) { this.preco += valor; }
    public void exibirInfo() { System.out.println("Terno " + cor + " | Tam: " + tamanho + " | Preço: R$ " + preco); }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
}