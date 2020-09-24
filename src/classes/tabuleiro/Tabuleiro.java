package classes.tabuleiro;

import java.util.Random;
import java.util.Scanner;

import aplicacao.Game;
import classes.ObjetosDoMapa;
import classes.entidades.*;
import classes.item.ItemDeRegeneracao;


public class Tabuleiro {
    public Protagonista protagonista;
    static final int quantidadeDeEntidadesMaxima = 10;
    private int quantidadeDeMonstros;
    Random geradorDeNumeroAleatorio = new Random();
    ObjetosDoMapa[][] tabuleiro = new ObjetosDoMapa[10][10];

    public Tabuleiro(int quantidadeDeMonstros, int quantidadeDeItensDeRegeneracao) {
        quantidadeDeMonstros = Math.min(quantidadeDeMonstros, quantidadeDeEntidadesMaxima);
        quantidadeDeItensDeRegeneracao = Math.min(quantidadeDeItensDeRegeneracao, quantidadeDeEntidadesMaxima);
        this.quantidadeDeMonstros = quantidadeDeMonstros;
        colocarMuro();
        colocarMonstros();
        colocarItemDeRegeneracao(quantidadeDeItensDeRegeneracao);
        colocarProtagonista();
    }
    public int numeroAleatorio(int num) {
        return geradorDeNumeroAleatorio.nextInt(num);
    }

    public void verificarMonstros(){
        for (int linha = 0; linha < 10; linha++) {
            for (int coluna = 0; coluna < 10; coluna++) {
                if (tabuleiro[linha][coluna] == null)
                    System.out.print(". ");
                if (tabuleiro[linha][coluna] instanceof Monstro)
                    System.out.print("M ");

                if (tabuleiro[linha][coluna] instanceof Muro)
                    System.out.print("X ");

                if(tabuleiro[linha][coluna] instanceof ItemDeRegeneracao)
                    System.out.print("P ");

                if(linha == protagonista.getY() && coluna == protagonista.getX())
                    System.out.print("J ");
            }
            System.out.println();
        }
    }

    public void colocarMuro() {
        int linha, coluna;
        for (linha = 0; linha < 10; linha++) {
            for (coluna = 0; coluna < 10; coluna++) {
                if (linha == 0 || coluna == 0 || linha == 9 || coluna == 9) {
                     tabuleiro[linha][coluna] = new Muro();
                }
            }
        }
    }

    public void colocarMonstros() {
        int quantidadeDeMonstrosColocados = 0;
        while (quantidadeDeMonstrosColocados < this.quantidadeDeMonstros) {
            int x = numeroAleatorio(10);
            int y = numeroAleatorio(10);
            if (tabuleiro[y][x] == null) {
                quantidadeDeMonstrosColocados++;
                int tipoDeMonstro = numeroAleatorio(4);
                switch (tipoDeMonstro) {
                    case 0:
                        tabuleiro[y][x] = new Aranha();
                        break;
                    case 1:
                        tabuleiro[y][x] = new Creeper();
                        break;
                    case 2:
                        tabuleiro[y][x] = new Esqueleto();
                        break;
                    case 3:
                        tabuleiro[y][x] = new Zumbi();
                        break;
                }
            }
        }
    }

    public void colocarItemDeRegeneracao(int quantidadeDeItensDeRegeneracao) {
        int quantidadeDeItensColocados = 0;

        while (quantidadeDeItensColocados < quantidadeDeItensDeRegeneracao) {
            quantidadeDeItensColocados++;
            int x, y;
            do {
                x = numeroAleatorio(10);
                y = numeroAleatorio(10);
            } while(tabuleiro[y][x] != null);
            tabuleiro[y][x] = new ItemDeRegeneracao();
        }
    }

    public void colocarProtagonista() {
        int x = numeroAleatorio(10), y = numeroAleatorio(10);
        while (tabuleiro[y][x] != null) {
            x = numeroAleatorio(10);
            y = numeroAleatorio(10);
        }
        tabuleiro[y][x] = protagonista = new Protagonista(x, y);
    }

    public void moverInstanciaDoPersonagem(int y, int x){
        tabuleiro[this.protagonista.getY()][this.protagonista.getX()] = tabuleiro[y][x];
        tabuleiro[y][x] = null;
    }

    public int atualizarPosicaoProtagonista(String direcao) {
        int x  = this.protagonista.getX(), y = this.protagonista.getY();
        if (this.protagonista.andar(direcao) == 0)
            return 0;

        if (tabuleiro[this.protagonista.getY()][this.protagonista.getX()] == null){
            System.out.println("Não há nada aqui ("+this.protagonista.getY()+","+this.protagonista.getX()+")");
            moverInstanciaDoPersonagem(y, x);
        }


        if(tabuleiro[this.protagonista.getY()][this.protagonista.getX()] instanceof Muro) {
            System.out.println("Há um muro a frente");
            this.protagonista.retornarParaPosicaoAnterior(x, y);
            return 0;
        }
        if (tabuleiro[this.protagonista.getY()][this.protagonista.getX()] instanceof Monstro) {
            Monstro monstro = (Monstro) tabuleiro[this.protagonista.getY()][this.protagonista.getX()];
            if (!this.luta(monstro))
                this.protagonista.retornarParaPosicaoAnterior(x, y);
            else{
                tabuleiro[this.protagonista.getY()][this.protagonista.getX()] = null;
                moverInstanciaDoPersonagem(y, x);
            }

        }

        if (tabuleiro[this.protagonista.getY()][this.protagonista.getX()] instanceof ItemDeRegeneracao) {
            ItemDeRegeneracao itemDeRegeneracao = (ItemDeRegeneracao) tabuleiro[this.protagonista.getY()][this.protagonista.getX()];
            this.protagonista.recuperarVida(itemDeRegeneracao);
            moverInstanciaDoPersonagem(y, x);
        }


        return 1;
    }

    private boolean luta(Monstro monstro) {
        Scanner sc = new Scanner(System.in);
        String decisao;
        String tipoMonstro = monstro.anunciarApareciento();
        while (!monstro.morreu() && !this.protagonista.morreu()) {
            do {
                System.out.print("Decisão (atacar/fugir): ");
                decisao = sc.next();
            } while (!decisao.equals("fugir") && !decisao.equals("atacar"));

            if (decisao.equals("fugir")) return false;

            this.protagonista.atacar(monstro);


            if (!monstro.morreu()) {
                System.out.println("Você feriu "+tipoMonstro+" (HP: "+monstro.getPontosDeVida()+")");
                monstro.atacar(protagonista);
            }
            if(monstro.morreu()) {
                this.quantidadeDeMonstros--;
                System.out.println("Você matou "+tipoMonstro);
            }
        }
        return true;
    }
    public boolean venceu() {
        return this.quantidadeDeMonstros == 0;
    }


}
