package org.sofka.personal.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.personal.values.ManipuladorId;
import org.sofka.personal.values.Seccion;

/**
 * Evento para el manipulador agregado
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class ManipuladorAgregado extends DomainEvent {
    /**
     * Identificador del manipulador
     */
    private final ManipuladorId manipuladorId;
    /**
     * Secciópn del manipulador
     */
    private final Seccion seccion;


    /**
     * Método constructor para el manipulador agregado
     *
     * @param manipuladorId identificador del manipulador
     * @param seccion objeto valor del manipulador
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public ManipuladorAgregado(ManipuladorId manipuladorId, Seccion seccion) {
        super("org.sofka.personal.eventos.ManipuladorAgregado");
        this.manipuladorId = manipuladorId;
        this.seccion = seccion;
    }

    /**
     * Método para obtener el identificador del manipulador
     * @return retorna el identificador del manipulador
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public ManipuladorId getManipuladorId() {
        return manipuladorId;
    }

    /**
     * Método para obtener la sección del manipulador
     * @return retorna la sección del manipulador
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Seccion getSeccion() {
        return seccion;
    }
}
