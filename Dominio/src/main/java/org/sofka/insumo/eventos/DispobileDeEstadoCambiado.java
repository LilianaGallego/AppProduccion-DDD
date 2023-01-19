package org.sofka.insumo.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.insumo.values.Disponible;
import org.sofka.insumo.values.EstadoId;

/**
 * Evento para el estado disponible cambiado
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class DispobileDeEstadoCambiado extends DomainEvent {
    /**
     * Identificador del estado del insumo
     */
    private final EstadoId estadoId;
    /**
     * Objeto valor del estado
     */
    private final Disponible disponible;

    /**
     * Método constructor para el estdo disponible cambiado
     *
     * @param estadoId identificador del estado
     * @param disponible objeto valor del estado
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public DispobileDeEstadoCambiado(EstadoId estadoId, Disponible disponible){
        super("org.sofka.insumo.eventos.DispobileDeEstadoCambiado");
        this.estadoId = estadoId;
        this.disponible = disponible;
    }

    /**
     * Método para obtener el estadoId
     * @return retorna el estadoId
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public EstadoId getEstadoId() {
        return estadoId;
    }

    /**
     * Método para saber si el insumo esta disponible
     * @return retorna disponible true or false
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Disponible getDisponible() {
        return disponible;
    }
}
