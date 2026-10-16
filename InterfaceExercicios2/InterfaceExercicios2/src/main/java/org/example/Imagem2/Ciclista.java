package org.example.Imagem2;

public class Ciclista {
    private String nome;
    private int idade;
    private boolean usaCapacete;

    public Ciclista(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.usaCapacete = true;
    }

    public void pedalar() { System.out.println(nome + " está pedalando pela trilha."); }
    public void equiparCapacete() { this.usaCapacete = true; }
    public void descansar() { System.out.println(nome + " parou para descansar."); }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public boolean isUsaCapacete() { return usaCapacete; }
}