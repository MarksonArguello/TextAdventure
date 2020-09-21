package classes.entidades;

import classes.entidades.interfaces.EntidadesQueCausamDano;

public class Protagonista extends Entidade implements EntidadesQueCausamDano {

    public Protagonista() {
        this.danoDeAtaque = 20;
        this.pontosDeVida = 80;
    }

    @Override
    public void atacar(Entidade entidade) {
        entidade.pontosDeVida -= this.danoDeAtaque;
    }


}
