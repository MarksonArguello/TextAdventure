package classes.entidades;

import classes.entidades.interfaces.AnunciarAparecimento;

/**
 * Classe que representa um creeper
 */
public class Creeper extends Monstro implements AnunciarAparecimento {

    /**
     * Construtor do creeper
     */
    public Creeper() {
        this.x = x;
        this.y = y;
        this.danoDeAtaque = 35;
        this.pontosDeVida = 25;
        this.tecnincaOfensiva = "explosão";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void atacar(Entidade entidade) {
        System.out.println("O creeper atacou com "+ this.tecnincaOfensiva);
        entidade.pontosDeVida -= this.danoDeAtaque;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String anunciarApareciento() {
        System.out.println("Há um creeper aqui: (ATK: "+this.danoDeAtaque+")");
        return "o creeper";
    }
}
