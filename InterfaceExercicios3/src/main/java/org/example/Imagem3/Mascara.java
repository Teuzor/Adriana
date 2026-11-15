package org.example.Imagem3;

public class Mascara {
    private String material;
    private String origemCultural;
    private boolean estaExposta;

    // Construtor vazio (essencial para mapeamento DAO)
    public Mascara() {}

    public Mascara(String material, String origemCultural) {
        this.material = material;
        this.origemCultural = origemCultural;
        this.estaExposta = false;
    }

    public void expor() { this.estaExposta = true; }
    public void recolher() { this.estaExposta = false; }
    public void restaurar() { System.out.println("Restaurando máscara de " + material + "."); }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public String getOrigemCultural() { return origemCultural; }
    public void setOrigemCultural(String origemCultural) { this.origemCultural = origemCultural; }

    public boolean isEstaExposta() { return estaExposta; }
    public void setEstaExposta(boolean estaExposta) { this.estaExposta = estaExposta; }
}