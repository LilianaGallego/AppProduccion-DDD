package org.sofka.insumo.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.insumo.entidades.Estado;
import org.sofka.insumo.entidades.Item;
import org.sofka.insumo.values.Clasificacion;
import org.sofka.insumo.values.InsumoId;

import java.util.Set;

/**
 * Evento del insumo creado
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class InsumoCreado extends DomainEvent {
    private final InsumoId insumoId;
    private final Set<Item> items;
    private final Estado estado;
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
    public InsumoCreado(InsumoId insumoId, Set<Item> items, Estado estado, Clasificacion clasificacion) {
        super("org.sofka.insumo.eventos.InsumoCreado");
        this.insumoId = insumoId;
        this.items = items;
        this.estado = estado;
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

    public InsumoId getInsumoId() {
        return insumoId;
    }

    public Set<Item> getItems() {
        return items;
    }

    public Estado getEstado() {
        return estado;
    }
}
