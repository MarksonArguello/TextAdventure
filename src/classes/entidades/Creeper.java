package classes.entidades;

import classes.entidades.interfaces.AnunciarAparecimento;


public class Creeper extends Monstro implements AnunciarAparecimento {

    public Creeper() {
        this.x = x;
        this.y = y;
        this.danoDeAtaque = 40;
        this.pontosDeVida = 25;
        this.tecnincaOfensiva = "explosão";
    }

    @Override
    public void atacar(Entidade entidade) {
        System.out.println("O creeper atacou com "+ this.tecnincaOfensiva + "\nO creeper morreu");
        entidade.pontosDeVida -= this.danoDeAtaque;
        this.pontosDeVida = 0;
    }

    @Override
    public String anunciarApareciento() {
        System.out.println("Há um creeper aqui: (ATK: "+this.danoDeAtaque+")");
        return "o creeper";
    }
}
