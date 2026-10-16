package org.example.Imagem3;

public class Escultura {
    private String estilo;
    private double alturaCm;
    private double pesoKg;

    public Escultura(String estilo, double alturaCm, double pesoKg) {
        this.estilo = estilo;
        this.alturaCm = alturaCm;
        this.pesoKg = pesoKg;
    }

    public void mover(String novoLocal) { System.out.println("Escultura movida para: " + novoLocal); }
    public void polir() { System.out.println("Escultura do estilo " + estilo + " polida."); }
    public double avaliarValor() { return alturaCm * 15.0; }

    public String getEstilo() { return estilo; }
    public double getAlturaCm() { return alturaCm; }
    public double getPesoKg() { return pesoKg; }
}