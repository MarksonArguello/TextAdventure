package classes.entidades;


import classes.entidades.interfaces.AnunciarAparecimento;

/**
 * Classe que representa uma aranha.
 */
public class Aranha extends Monstro implements AnunciarAparecimento {

    /**
     * Construtor da aranha.
     */
    public Aranha() {
        this.x = x;
        this.y = y;
        this.danoDeAtaque = 5;
        this.pontosDeVida = 20;
        this.tecnincaOfensiva = "envenenamento";
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void atacar(Entidade entidade) {
        System.out.println("A aranha atacou com "+ this.tecnincaOfensiva);
        entidade.pontosDeVida -= this.danoDeAtaque;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String anunciarApareciento() {
        System.out.println("Há uma aranha aqui: (ATK: "+this.danoDeAtaque+")" );
        return "a aranha";
    }
}
