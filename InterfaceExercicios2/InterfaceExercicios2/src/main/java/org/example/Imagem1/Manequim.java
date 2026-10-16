package org.example.Imagem1;

public class Manequim {
    private String posicao;
    private String roupaVestida;
    private boolean emDestaque;

    public Manequim(String posicao, String roupaVestida) {
        this.posicao = posicao;
        this.roupaVestida = roupaVestida;
        this.emDestaque = false;
    }

    public void vestirRoupa(String novaRoupa) { this.roupaVestida = novaRoupa; }
    public void trocarPosicao(String novaPosicao) { this.posicao = novaPosicao; }
    public void alternarDestaque() { this.emDestaque = !this.emDestaque; }

    public String getPosicao() { return posicao; }
    public void setPosicao(String posicao) { this.posicao = posicao; }
    public String getRoupaVestida() { return roupaVestida; }
    public boolean isEmDestaque() { return emDestaque; }
}