package classes.entidades;

import classes.entidades.interfaces.EntidadesQueCausamDano;
import classes.item.ItemDeRegeneracao;

public class Protagonista extends Entidade implements EntidadesQueCausamDano {


    public Protagonista(int x, int y) {
        this.x = x;
        this.y = y;
        this.danoDeAtaque = 20;
        this.pontosDeVida = 80;
    }

    @Override
    public void atacar(Entidade entidade) {
        entidade.pontosDeVida -= this.danoDeAtaque;
       // System.out.println("Você feriu o monstro (HP: "+entidade.pontosDeVida+")");
    }

    public int andar(String direcao) {
        switch (direcao) {
            case "frente":
                this.y--;
                break;
            case "direita":
                this.x++;
                break;
            case "trás":
                this.y++;
                break;
            case "esquerda":
                this.x--;
                break;
            default:
                return 0;
        }
        return 1;
    }

    public void retornarParaPosicaoAnterior(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public void recuperarVida(ItemDeRegeneracao itemDeRegeneracao) {
        this.pontosDeVida += itemDeRegeneracao.getPontosDeRegenaracao();
        if (this.pontosDeVida > 80) this.pontosDeVida = 80;
        System.out.println("Sua vida foi recuperada: " + this.pontosDeVida + " HP");
    }

    public boolean morreu() {
        return (this.pontosDeVida <= 0);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }




}
