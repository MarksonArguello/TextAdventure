package classes.entidades;


import classes.entidades.interfaces.AnunciarAparecimento;


public class Aranha extends Monstro implements AnunciarAparecimento {

    public Aranha() {
        this.x = x;
        this.y = y;
        this.danoDeAtaque = 5;
        this.pontosDeVida = 20;
        this.tecnincaOfensiva = "envenenamento";
    }

    @Override
    public void atacar(Entidade entidade) {
        System.out.println("A aranha atacou com "+ this.tecnincaOfensiva);
        entidade.pontosDeVida -= this.danoDeAtaque;
    }

    @Override
    public String anunciarApareciento() {
        System.out.println("Há uma aranha aqui: (ATK: "+this.danoDeAtaque+")" );
        return "a aranha";
    }
}
