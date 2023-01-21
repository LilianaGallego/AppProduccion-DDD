package org.sofka.personal.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.personal.values.Experiencia;
import org.sofka.personal.values.JefeId;

/**
 * Evento para el jefe agregado
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class JefeAgregado extends DomainEvent {
    /**
     * Identificador del jefe
     */
    private final JefeId jefeId;
    /**
     * Experiencia del jefe
     */
    private final Experiencia experiencia;


    /**
     * Método constructor para el jefe agregado
     *
     * @param jefeId identificador del jefe
     * @param experiencia objeto valor del jefe
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public JefeAgregado(JefeId jefeId, Experiencia experiencia) {
        super("org.sofka.personal.eventos.JefeAgregado");
        this.jefeId = jefeId;
        this.experiencia = experiencia;
    }

    /**
     * Método para obtener el jefeId
     * @return retorna el jefeId
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public JefeId getJefeId() {
        return jefeId;
    }

    /**
     * Método para obtener la experiencia del jefe
     * @return retorna la experiencia
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Experiencia getExperiencia() {
        return experiencia;
    }
}
