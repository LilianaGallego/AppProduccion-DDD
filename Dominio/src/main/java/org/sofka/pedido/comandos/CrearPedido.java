package org.sofka.pedido.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.pedido.values.Cantidad;
import org.sofka.pedido.values.PedidoId;

public class CrearPedido extends Command {
    private final PedidoId pedidoId;
    private final Cantidad cantidad;

    public CrearPedido(PedidoId pedidoId, Cantidad cantidad) {
        this.pedidoId = pedidoId;
        this.cantidad = cantidad;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }
}
