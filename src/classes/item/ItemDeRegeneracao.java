package classes.item;

import classes.ObjetosDoMapa;

/**
 * Classe que representa um item de regeneração.
 */
public class ItemDeRegeneracao extends ObjetosDoMapa {
    private int pontosDeRegeneracao;

    /**
     * Construtor do item de regeneração.
     */
    public ItemDeRegeneracao() {
        this.pontosDeRegeneracao = 35;
    }

    /**
     *
     * @return Pontos de vida que o item recupera.
     */
    public int getPontosDeRegenaracao() {
        return pontosDeRegeneracao;
    }
}
