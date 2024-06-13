import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        List<String> pistas = new ArrayList<>();

        System.out.println("-----------------");
        System.out.println(" Qual é o filme? ");
        System.out.println("-----------------");

        System.out.println("Jogador 1 - Digite o nome do filme: ");
        String nomeFilme = sc.nextLine().toLowerCase();

        lerPistas(pistas, sc);

        System.out.println("--- Jogador 2 ---");

    boolean acertou = false;
    int pontuacao = 0;
    int tentativas = 0;

        for (tentativas = 0; tentativas < 5; tentativas++) {
            mostrarPistas(pistas, tentativas + 1);
            System.out.println("Jogador 2 - Digite a resposta: ");
            String resposta = sc.nextLine().toLowerCase();

            if (comparaFilme(nomeFilme, resposta)) {
                acertou = true;
                switch (tentativas) {
                    case 0:
                        pontuacao = 100;
                        break;
                    case 1:
                        pontuacao = 60;
                        break;
                    case 2:
                        pontuacao = 40;
                        break;
                    case 3:
                        pontuacao = 20;
                        break;
                    case 4:
                        pontuacao = 10;
                        break;
                }
                System.out.println("Você Acertou. Parabéns!");
                break;
            }else {
                System.out.println("Você errou! Tente novamente.");
            }
        }

        if (!acertou) {
            System.out.println("Que pena! Você não conseguiu adivinhar o nome do filme. O filme era: " + nomeFilme);
        }

        System.out.println("Sua pontuação: " + pontuacao + " pontos");

        sc.close();
    }

    public static void mostrarPistas (List<String> pistas, int numeroDePistas){
        for (int i = 0; i < numeroDePistas; i++) {
            System.out.println(pistas.get(i));
        }
    }

    public static void lerPistas (List<String> lerPistas, Scanner sc) {
    for (int i = 0; i < 5; i++) {
        System.out.print("Digite a pista #" + (i + 1) + ":");
        lerPistas.add(sc.nextLine());
        }
    }

    public static boolean comparaFilme (String filme1, String filme2){
        return filme1.equals(filme2);
    }
}