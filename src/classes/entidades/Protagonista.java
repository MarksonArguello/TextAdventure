package classes.entidades;

import classes.entidades.interfaces.EntidadesQueCausamDano;
import classes.item.ItemDeRegeneracao;


/**
 * Classe que representa o protagonista.
 */
public class Protagonista extends Entidade implements EntidadesQueCausamDano {

    /**
     * Constutor de protagonista.
     * @param x Ponto x na posição no mapa
     * @param y Ponto y na posição no mapa
     */
    public Protagonista(int x, int y) {
        this.x = x;
        this.y = y;
        this.danoDeAtaque = 20;
        this.pontosDeVida = 80;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void atacar(Entidade entidade) {
        entidade.pontosDeVida -= this.danoDeAtaque;
       // System.out.println("Você feriu o monstro (HP: "+entidade.pontosDeVida+")");
    }

    /**
     * Move o personagem pelo tabuleiro
     * @param direcao Direção para qual o protagonista vai
     * @return inteiro 0 caso a diração não seja válida e 1 caso seja.
     */
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

    /**
     * Retorna o protagonista para a posição anterior, usado caso ele fuja ou encontre um muro.
     * @param x Ponto x na posição no mapa
     * @param y Ponto y na posição no mapa
     */
    public void retornarParaPosicaoAnterior(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Recupera a vida do protagonista caso ele encontre um item de regeneração.
     * @param itemDeRegeneracao Item de regenaração que será usado para recuperar a vida do protagonista
     */
    public void recuperarVida(ItemDeRegeneracao itemDeRegeneracao) {
        this.pontosDeVida += itemDeRegeneracao.getPontosDeRegenaracao();
        if (this.pontosDeVida > 80) this.pontosDeVida = 80;
        System.out.println("Sua vida foi recuperada: " + this.pontosDeVida + " HP");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean morreu() {
        return (this.pontosDeVida <= 0);
    }

    /**
     *
     * @return Ponto x na posição do mapa.
     */
    public int getX() {
        return this.x;
    }

    /**
     *
     * @return Ponto y na posição do mapa.
     */
    public int getY() {
        return this.y;
    }




}
