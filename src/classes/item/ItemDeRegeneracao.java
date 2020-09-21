package classes.item;

import classes.ObjetosDoMapa;


public class ItemDeRegeneracao extends ObjetosDoMapa {
    private int pontosDeRegeneracao;

    public ItemDeRegeneracao() {
        this.pontosDeRegeneracao = 35;
    }

    public int getPontosDeRegenaracao() {
        return pontosDeRegeneracao;
    }
}
