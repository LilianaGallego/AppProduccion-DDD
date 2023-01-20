package org.sofka.pedido.entidades;

import co.com.sofka.domain.generic.Entity;
import org.sofka.pedido.values.Completado;
import org.sofka.pedido.values.EstadoId;
import org.sofka.pedido.values.PedidoId;

/**
 * Entidad Estado del insumo
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class Estado extends Entity<EstadoId> {
    /**
     * Identificador del estado
     */
    private final EstadoId estadoId;
    /**
     * Identificador del pedido
     */
    private final PedidoId pedidoId;
    /**
     * Objeto de valor de tipo Completado
     */
    private final Completado completado;

    /**
     * Constructor de la entidad Estado
     * @param estadoId id del estado
     * @param pedidoId id del pedido
     * @param completado objeto de valor de tipo Completado
     */
    public Estado(EstadoId estadoId, PedidoId pedidoId, Completado completado){
        super(estadoId);
        this.estadoId = estadoId;
        this.pedidoId = pedidoId;
        this.completado = completado;
    }

    /**
     * Método get para obtener el id del estado
     * @return id del estado
     */
    public EstadoId getEstadoId() {
        return estadoId;
    }

    /**
     * Método para obtener el objeto de tipo Completado
     * @return objeto de valor de tipo Completado
     */
    public Completado getCompletado() {
        return completado;
    }
    /**
     * Método get para obtener el id del pedido
     * @return id del pedido
     */
    public PedidoId getPedidoId() {
        return pedidoId;
    }
}
