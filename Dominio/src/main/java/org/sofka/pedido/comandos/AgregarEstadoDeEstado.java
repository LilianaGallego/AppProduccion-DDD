package org.sofka.pedido.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.pedido.values.Completado;
import org.sofka.pedido.values.EstadoId;
import org.sofka.pedido.values.PedidoId;

public class AgregarEstadoDeEstado extends Command {

    private final PedidoId pedidoId;
    private final EstadoId estadoId;
    private final Completado completado;

    public AgregarEstadoDeEstado(PedidoId pedidoId, EstadoId estadoId, Completado completado){
        this.pedidoId = pedidoId;

        this.estadoId = estadoId;
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
