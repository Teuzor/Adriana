import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int escolha;

        System.out.println("Informe o exercicio: ");
        System.out.println("========================== ");
        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Verificar Dívisivel ");

        System.out.println("2 - Inserir Senha ");

        System.out.println("3 - Aplicar Desconto ");

        System.out.println("4 - Temperatura ");

        System.out.println("5 - Dividir Camelos ");

        System.out.println("6 - Custo em Gasolina ");

        System.out.println("7 - Valor de Aluguel");

        escolha = sc.nextInt();

        if (escolha == 1) {
            Multiplo.executar();
        } else if (escolha == 2) {
            Senha.executar();
        } else if (escolha == 3) {
            Desconto.executar();
        } else if (escolha == 4) {
            Temperatura.executar();
        } else if (escolha == 5) {
            DivisaoCamelos.executar();
        } else if (escolha == 6) {
            Distancia.executar();
        } else if (escolha == 7) {
            Aluguel.executar();
        } else {
            System.out.println("Número incondizente");
        }


    }

    void main() {
    }
}
