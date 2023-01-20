package org.sofka.pedido.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.pedido.entidades.Cliente;
import org.sofka.pedido.entidades.Estado;
import org.sofka.pedido.values.Cantidad;
import org.sofka.pedido.values.PedidoId;

public class CrearPedido extends Command {
    private final PedidoId pedidoId;
    private final Cantidad cantidad;
    private final Estado estado;
    private final Cliente cliente;

    public CrearPedido(PedidoId pedidoId, Cantidad cantidad, Estado estado, Cliente cliente) {
        this.pedidoId = pedidoId;
        this.cantidad = cantidad;
        this.estado = estado;
        this.cliente = cliente;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }

    public Estado getEstado() {
        return estado;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
