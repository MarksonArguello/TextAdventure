package classes.entidades;

import classes.entidades.interfaces.AnunciarAparecimento;

/**
 * Classe que representa um esqueleto.
 */
public class Esqueleto extends Monstro implements AnunciarAparecimento
{
    /**
     * Construtor do esqueleto.
     */
    public Esqueleto() {
        this.x = x;
        this.y = y;
        this.danoDeAtaque = 25;
        this.pontosDeVida = 40;
        this.tecnincaOfensiva = "flechada";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void atacar(Entidade entidade) {
        System.out.println("O esqueleto atacou com "+ this.tecnincaOfensiva);
        entidade.pontosDeVida -= this.danoDeAtaque;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String anunciarApareciento() {
        System.out.println("Há um esqueleto aqui: (ATK: "+this.danoDeAtaque+")" );
        return "o esqueleto";
    }
}
