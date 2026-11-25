package org.example.Imagem2;

public class Trilha {
    private String tipoTerreno;
    private double distanciaKm;
    private String dificuldade;

    // Construtor vazio (essencial para mapeamento DAO)
    public Trilha() {}

    public Trilha(String tipoTerreno, double distanciaKm, String dificuldade) {
        this.tipoTerreno = tipoTerreno;
        this.distanciaKm = distanciaKm;
        this.dificuldade = dificuldade;
    }

    public void iniciarPercurso() { System.out.println("Percurso iniciado no terreno: " + tipoTerreno); }
    public double calcularTempoEstimado() { return distanciaKm / 15.0; }
    public void exibirTrilha() { System.out.println("Trilha de " + distanciaKm + "km | Dificuldade: " + dificuldade); }

    public String getTipoTerreno() { return tipoTerreno; }
    public void setTipoTerreno(String tipoTerreno) { this.tipoTerreno = tipoTerreno; }

    public double getDistanciaKm() { return distanciaKm; }
    public void setDistanciaKm(double distanciaKm) { this.distanciaKm = distanciaKm; }

    public String getDificuldade() { return dificuldade; }
    public void setDificuldade(String dificuldade) { this.dificuldade = dificuldade; }
}