package org.sofka.personal.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.personal.values.Bpm;
import org.sofka.personal.values.PersonalId;

/**
 * Evento para la observacion actualizada
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class ObservacionActualizada extends DomainEvent {
    /**
     * Identificador del perssonal
     *
     */
    private final PersonalId personalId;
    /**
     * Objeto valor Bpm del personal
     *
     */
    private final Bpm bpm;

    /**
     * Método constructor para el estdo disponible cambiado
     *
     * @param personalId identificador del personal
     * @param bpm objeto valor del personal
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public ObservacionActualizada(PersonalId personalId, Bpm bpm) {
        super("org.sofka.personal.eventos.ObservacionActualizada");
        this.personalId = personalId;
        this.bpm = bpm;
    }

    /**
     * Método para obtener el personalId
     * @return retorna el personalId
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public PersonalId getPersonalId() {
        return personalId;
    }

    /**
     * Método para obtener la observacion del personal
     * @return retorna el bpm
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Bpm getBpm() {
        return bpm;
    }


}
