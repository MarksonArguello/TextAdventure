package classes.entidades.interfaces;

import classes.entidades.Entidade;

public interface EntidadesQueCausamDano {
    void atacar(Entidade entidade);
    boolean morreu();

}
