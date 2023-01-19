package org.sofka.insumo.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.insumo.values.Clasificacion;

/**
 * Evento del insumo creado
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class InsumoCreado extends DomainEvent {
    /**
     * Objeto Valor para clasificar el insumo
     */
    private final Clasificacion clasificacion;

    /**
     * Método constructor para el insumo creado
     *
     * @param clasificacion clasifica el insumo
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public InsumoCreado(Clasificacion clasificacion) {
        super("org.sofka.insumo.eventos.InsumoCreado");
        this.clasificacion = clasificacion;
    }

    /**
     * Método para saber la clase del insumo
     * @return retorna la clase del insumo
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Clasificacion getClasificacion() {
        return clasificacion;
    }
}
