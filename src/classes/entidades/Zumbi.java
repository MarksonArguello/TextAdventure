package classes.entidades;

import classes.entidades.interfaces.AnunciarAparecimento;

/**
 * Classe que representa um zumbi.
 */
public class Zumbi extends Monstro implements AnunciarAparecimento {

    /**
     * Construtor de zumbi.
     */
    public Zumbi() {
        this.x = x;
        this.y = y;
        this.danoDeAtaque = 10;
        this.pontosDeVida = 60;
        this.tecnincaOfensiva = "mordida";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void atacar(Entidade entidade) {
        System.out.println("O zumbi atacou com "+ this.tecnincaOfensiva);
        entidade.pontosDeVida -= this.danoDeAtaque;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String anunciarApareciento() {
        System.out.println("Há um zumbi aqui: (ATK: "+this.danoDeAtaque+")");
        return "o zumbi";
    }
}
