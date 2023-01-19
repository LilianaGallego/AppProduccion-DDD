package org.sofka.pedido;


import co.com.sofka.domain.generic.AggregateRoot;
import org.sofka.pedido.eventos.PedidoCreado;
import org.sofka.pedido.values.PedidoId;
import org.sofka.pedido.entidades.Cliente;
import org.sofka.pedido.entidades.Estado;
import org.sofka.pedido.values.Cantidad;

public class Pedido extends AggregateRoot<PedidoId> {
    protected Estado estado;
    protected Cliente cliente;
    protected Cantidad cantidad;

    public Pedido(PedidoId pedidoId, Cantidad cantidad) {
        super(pedidoId);
        appendChange(new PedidoCreado(cantidad)).apply();
    }

    public Cantidad getCantidad() {
        return cantidad;
    }
}
