package org.example.Imagem4;

public class Referencia {
    private String fonte;
    private String categoria;
    private boolean ehDigital;

    public Referencia(String fonte, String categoria, boolean ehDigital) {
        this.fonte = fonte;
        this.categoria = categoria;
        this.ehDigital = ehDigital;
    }

    public void carregar() { System.out.println("Carregando referência de: " + fonte); }
    public void aplicarFiltro(String filtro) { System.out.println("Aplicando filtro '" + filtro + "'."); }
    public void exibirDetalhes() { System.out.println("Fonte: " + fonte + " | Categoria: " + categoria); }

    public String getFonte() { return fonte; }
    public void setFonte(String fonte) { this.fonte = fonte; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public boolean isEhDigital() { return ehDigital; }
    public void setEhDigital(boolean ehDigital) { this.ehDigital = ehDigital; }
}