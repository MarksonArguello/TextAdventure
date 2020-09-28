package aplicacao;

import classes.tabuleiro.Tabuleiro;

import java.util.Scanner;

/**
 * Classe onde o jogo acontece.
 */
public class Game {
    private Scanner sc= new Scanner(System.in);
    public static Tabuleiro tabuleiro;

    /**
     * Construtor do jogo.
     */
    public Game() {
        System.out.println("Bem vindo ao Text Adventure");
        tabuleiro = new Tabuleiro(10, 5);
        jogar();
    }

    /**
     * Lê as informações do teclado e executa as ações até o jogo acabar
     * <p>
     *     Verifica se o jogo não acabou, caso não lê a ação do jogador.
     * </p>
     */
    private void jogar() {
        String acao;
        while (!fimDeJogo()) {
            do {
                System.out.print("Digite a ação: ");
                acao = sc.nextLine();
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


    /**
     * Verifica se o jogo acabou.
     * @return Booleano indicando se o jogo terminou.
     */
    private boolean fimDeJogo() {
        return tabuleiro.protagonista.morreu() || tabuleiro.venceu();
    }
}
