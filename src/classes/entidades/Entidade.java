package classes.entidades;


import classes.ObjetosDoMapa;

/**
 * Classe para respresentar todas as entidades que possuem ponto de vida e dano de ataque.
 */
public abstract class Entidade extends ObjetosDoMapa {
    protected int pontosDeVida;
    protected int danoDeAtaque;

    /**
     * Construtor de entidade.
     */
    public Entidade() {
    }


}
