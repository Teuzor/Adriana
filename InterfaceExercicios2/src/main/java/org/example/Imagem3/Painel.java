package org.example.Imagem3;

public class Painel {
    private int quantidadeItens;
    private String texturaFundo;
    private boolean fixadoNaParede;

    public Painel(String texturaFundo) {
        this.quantidadeItens = 0;
        this.texturaFundo = texturaFundo;
        this.fixadoNaParede = true;
    }

    public void adicionarItem() { this.quantidadeItens++; }
    public void removerItem() { if (this.quantidadeItens > 0) this.quantidadeItens--; }
    public void limparPainel() { this.quantidadeItens = 0; }

    public int getQuantidadeItens() { return quantidadeItens; }
    public String getTexturaFundo() { return texturaFundo; }
    public boolean isFixadoNaParede() { return fixadoNaParede; }
}