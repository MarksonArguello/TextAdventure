package classes.entidades.interfaces;

import classes.entidades.Entidade;


/**
 * Interface das entidades que causam dano.
 */
public interface EntidadesQueCausamDano {
    /**
     *
     * @param entidade entidade que vai ser atacada.
     */
    void atacar(Entidade entidade);

    /**
     * Retorna true se o objeto tem 0 ou menos de vida
     * false caso contrário
     * @return booleano informando se morreu.
     */
    boolean morreu();

}
