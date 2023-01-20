package org.sofka.pedido.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.pedido.values.Completado;
import org.sofka.pedido.values.EstadoId;
import org.sofka.pedido.values.PedidoId;

import java.util.Objects;

/**
 * Evento para el estado agregado
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class EstadoDeEstadoAgregado extends DomainEvent {
    /**
     * Identificador del estado
     */
    private final EstadoId estadoId;
    /**
     * Identificador del pedido
     */
    private final PedidoId pedidoId;
    /**
     * Objeto valor de tipo Completado
     */
    private final Completado completado;

    /**
     * Contructor para crear la clase EstadoDeEstadoAgregado
     * @param estadoId id del estado
     * @param pedidoId id del pedido
     * @param completado objeto de valor de tipo Completado
     */

    public EstadoDeEstadoAgregado(EstadoId estadoId, PedidoId pedidoId, Completado completado){
        super("org.sofka.insumo.eventos.EstadoDeEstadoAgregado");

        this.estadoId = Objects.requireNonNull(estadoId);
        this.pedidoId = Objects.requireNonNull(pedidoId);
        this.completado = Objects.requireNonNull(completado);
    }

    /**
     * Método get para obtener el id del pedido
     * @return id del pedido
     */
    public PedidoId getPedidoId() {
        return pedidoId;
    }

    /**
     * Método get para obtener el id del estado
     * @return id del estado
     */
    public EstadoId getEstadoId() {
        return estadoId;
    }

    /**
     * Método get para obtener el objeto de valor de tipo Completado
     * @return objeto de valor de tipo Completado
     */
    public Completado getCompletado() {
        return completado;
    }

}
