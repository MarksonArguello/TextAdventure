package classes.entidades;


import classes.entidades.interfaces.EntidadesQueCausamDano;

public class Aranha extends Monstro implements EntidadesQueCausamDano {
    public Aranha() {
        this.danoDeAtaque = 5;
        this.pontosDeVida = 20;
        this.tecnincaOfensiva = "envenenamento";
    }

    @Override
    public void atacar(Entidade entidade) {
        entidade.pontosDeVida -= this.danoDeAtaque;
    }
}
