package classes.entidades;

import classes.entidades.interfaces.AnunciarAparecimento;

/**
 * Classe que representa todos os montros.
 */
public abstract class Monstro extends Entidade implements AnunciarAparecimento {
    protected String tecnincaOfensiva;
    /**
     * Constutor do monstro
     */
    public Monstro() {
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
     * @return Pontos de vida da entidade.
     */
    public int getPontosDeVida(){
        return this.pontosDeVida;
    }
}
