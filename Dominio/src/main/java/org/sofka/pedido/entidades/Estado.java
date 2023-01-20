package org.sofka.pedido.entidades;

import co.com.sofka.domain.generic.Entity;
import org.sofka.pedido.values.Completado;
import org.sofka.pedido.values.EstadoId;
import org.sofka.pedido.values.PedidoId;

public class Estado extends Entity<EstadoId> {

    private final EstadoId estadoId;
    private final PedidoId pedidoId;
    private final Completado completado;

    public Estado(EstadoId estadoId, PedidoId pedidoId, Completado completado){
        super(estadoId);
        this.estadoId = estadoId;
        this.pedidoId = pedidoId;
        this.completado = completado;
    }

    public EstadoId getEstadoId() {
        return estadoId;
    }

    public Completado getCompletado() {
        return completado;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }
}
