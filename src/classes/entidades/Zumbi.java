package classes.entidades;

import classes.entidades.interfaces.AnunciarAparecimento;


public class Zumbi extends Monstro implements AnunciarAparecimento {

    public Zumbi() {
        this.x = x;
        this.y = y;
        this.danoDeAtaque = 10;
        this.pontosDeVida = 60;
        this.tecnincaOfensiva = "mordida";
    }

    @Override
    public void atacar(Entidade entidade) {
        System.out.println("O zumbi atacou com "+ this.tecnincaOfensiva);
        entidade.pontosDeVida -= this.danoDeAtaque;
    }

    @Override
    public String anunciarApareciento() {
        System.out.println("Há um zumbi aqui: (ATK: "+this.danoDeAtaque+")");
        return "o zumbi";
    }
}
