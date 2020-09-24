package aplicacao;

import classes.entidades.Protagonista;
import classes.tabuleiro.Tabuleiro;

import java.util.Scanner;

public class Game {
    private Scanner sc= new Scanner(System.in);
    public static Tabuleiro tabuleiro;

    public Game() {
        System.out.println("Bem vindo ao Text Adventure");
        tabuleiro = new Tabuleiro(10, 5);
        jogar();
    }

    private void jogar() {
        String acao;
        while (!fimDeJogo()) {
            do {
                System.out.print("Digite a ação: ");
                acao = sc.next();
                if (acao.equals("monstros")) {
                    tabuleiro.verificarMonstros();
                }
            } while(tabuleiro.atualizarPosicaoProtagonista(acao) == 0);
        }
        if (tabuleiro.protagonista.morreu())
            System.out.println("Você morreu\nGame Over");
        else
            System.out.println("Você Venceu");
    }



    private boolean fimDeJogo() {
        return tabuleiro.protagonista.morreu() || tabuleiro.venceu();
    }
}
