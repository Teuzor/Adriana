package org.example.Imagem4;

public class ModeloCabelo {
    private String estilo;
    private String comprimento;
    private boolean possuiFranja;

    public ModeloCabelo(String estilo, String comprimento, boolean possuiFranja) {
        this.estilo = estilo;
        this.comprimento = comprimento;
        this.possuiFranja = possuiFranja;
    }

    public void pentear() { System.out.println("Penteando cabelo no modelo: " + estilo); }
    public void cortar(String novoTamanho) { this.comprimento = novoTamanho; }
    public void tingir(String cor) { System.out.println("Tingindo o estilo " + estilo + " de " + cor); }

    public String getEstilo() { return estilo; }
    public String getComprimento() { return comprimento; }
    public boolean isPossuiFranja() { return possuiFranja; }
}