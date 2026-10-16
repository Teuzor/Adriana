package org.example.Imagem1;

public class Loja {
    private String nome;
    private String cidade;
    private boolean aberta;

    public Loja(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
        this.aberta = false;
    }

    public void abrir() { this.aberta = true; }
    public void fechar() { this.aberta = false; }
    public void exibirStatus() { System.out.println("Loja " + nome + " em " + cidade + " - Aberta: " + aberta); }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public boolean isAberta() { return aberta; }
}