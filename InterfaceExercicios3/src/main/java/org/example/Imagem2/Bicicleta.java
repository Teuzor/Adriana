package org.example.Imagem2;

public class Bicicleta {
    private String modelo;
    private int marchaAtual;
    private double velocidade;

    // Construtor vazio (essencial para mapeamento DAO)
    public Bicicleta() {}

    public Bicicleta(String modelo, int marchaAtual, double velocidade) {
        this.modelo = modelo;
        this.marchaAtual = marchaAtual;
        this.velocidade = velocidade;
    }

    public void acelerar(double incremento) { this.velocidade += incremento; }
    public void frear(double decremento) { this.velocidade = Math.max(0, this.velocidade - decremento); }
    public void mudarMarcha(int novaMarcha) { this.marchaAtual = novaMarcha; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getMarchaAtual() { return marchaAtual; }
    public void setMarchaAtual(int marchaAtual) { this.marchaAtual = marchaAtual; }

    public double getVelocidade() { return velocidade; }
    public void setVelocidade(double velocidade) { this.velocidade = velocidade; }
}