package org.sofka.personal.entidades;

import co.com.sofka.domain.generic.Entity;
import org.sofka.personal.values.Experiencia;
import org.sofka.personal.values.JefeId;

/**
 * Entidad Jefe del Personal
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class Jefe extends Entity<JefeId> {

    /**
     * Objeto valor experiencia del jefe
     */
    private Experiencia experiencia;
    /**
     * Identificador del jefe
     */
    private JefeId jefeId;

    /**
     * Método constructor del jefe
     *
     * @param jefeId identificador del jefe
     * @param experiencia objeto valor del jefe
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Jefe(JefeId jefeId, Experiencia experiencia) {
        super(jefeId);
        this.experiencia = experiencia;
    }

    /**
     * Comportamiento de la entidad jefe para agregar jefe
     *
     * @param jefeId identificador del jefe
     * @param experiencia objeto valor del jefe
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public void agregarJefe(JefeId jefeId, Experiencia experiencia){
        this.jefeId = jefeId;
        this.experiencia = experiencia;

    }

    /**
     * Pone la experiencia del jefe como publica
     * @return retorna la experiencia del jefe
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Experiencia experiencia(){
        return experiencia;
    }
}
