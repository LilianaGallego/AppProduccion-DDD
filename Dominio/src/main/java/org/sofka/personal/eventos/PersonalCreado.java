package org.sofka.personal.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.personal.values.Bpm;

/**
 * Evento para el personal creado
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class PersonalCreado extends DomainEvent {
    /**
     * Objeto valor Bpm del personal
     *
     */
    private final Bpm bpmPersonal;

    /**
     * Método constructor para el manipulador agregado
     *
     * @param bpmPersonal objeto valor del manipulador
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public PersonalCreado(Bpm bpmPersonal) {
        super("org.sofka.personal.eventos.PersonalCreado");
        this.bpmPersonal = bpmPersonal;
    }

    /**
     * Método para obtener el bpmPersonal
     * @return retorna el bpmPersonal
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Bpm getBpmPersonal() {
        return bpmPersonal;
    }
}
