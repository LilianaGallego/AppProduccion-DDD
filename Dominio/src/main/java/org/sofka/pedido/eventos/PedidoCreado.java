package org.sofka.pedido.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.pedido.values.Cantidad;

public class PedidoCreado extends DomainEvent {
    private final Cantidad cantidad;
    public PedidoCreado(Cantidad cantidad) {
        super("org.sofka.pedido.eventos.PedidoCreado");
        this.cantidad = cantidad;
    }
}
