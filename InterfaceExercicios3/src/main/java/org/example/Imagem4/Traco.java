package org.example.Imagem4;

public class Traco {
    private double espessuraMm;
    private String cor;
    private boolean ehSuave;

    public Traco(double espessuraMm, String cor, boolean ehSuave) {
        this.espessuraMm = espessuraMm;
        this.cor = cor;
        this.ehSuave = ehSuave;
    }

    public void engrossar(double valor) { this.espessuraMm += valor; }
    public void suavizar() { this.ehSuave = true; }
    public void alterarCor(String novaCor) { this.cor = novaCor; }

    public double getEspessuraMm() { return espessuraMm; }
    public String getCor() { return cor; }
    public boolean isEhSuave() { return ehSuave; }
}