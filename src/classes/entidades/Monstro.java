package classes.entidades;

import classes.entidades.interfaces.AnunciarAparecimento;


public abstract class Monstro extends Entidade implements AnunciarAparecimento {
    protected String tecnincaOfensiva;

    public Monstro() {
    }

    public boolean morreu() {
        return (this.pontosDeVida <= 0);
    }

    public int getPontosDeVida(){
        return this.pontosDeVida;
    }
}
