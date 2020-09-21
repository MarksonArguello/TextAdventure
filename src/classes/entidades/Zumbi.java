package classes.entidades;

import classes.entidades.interfaces.EntidadesQueCausamDano;

public class Zumbi extends Monstro implements EntidadesQueCausamDano {

    public Zumbi() {
        this.danoDeAtaque = 10;
        this.pontosDeVida = 60;
        this.tecnincaOfensiva = "mordida";
    }

    @Override
    public void atacar(Entidade entidade) {
        entidade.pontosDeVida -= this.danoDeAtaque;
    }
}
