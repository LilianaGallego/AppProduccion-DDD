package org.sofka.pedido.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.pedido.values.Completado;
import org.sofka.pedido.values.EstadoId;
import org.sofka.pedido.values.PedidoId;

public class EstadoDeEstadoAgregado extends DomainEvent {
    private final EstadoId estadoId;
    private final PedidoId pedidoId;
    private final Completado completado;

    public EstadoDeEstadoAgregado(EstadoId estadoId, PedidoId pedidoId, Completado completado){
        super("org.sofka.insumo.eventos.EstadoDeEstadoAgregado");

        this.estadoId = estadoId;
        this.pedidoId = pedidoId;
        this.completado = completado;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public EstadoId getEstadoId() {
        return estadoId;
    }

    public Completado getCompletado() {
        return completado;
    }

}
