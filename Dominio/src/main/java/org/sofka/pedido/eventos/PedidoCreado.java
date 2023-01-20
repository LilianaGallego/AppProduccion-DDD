package org.sofka.pedido.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.pedido.entidades.Cliente;
import org.sofka.pedido.entidades.Estado;
import org.sofka.pedido.values.Cantidad;

public class PedidoCreado extends DomainEvent {
    private final Cantidad cantidad;
    private final Estado estado;
    private final Cliente cliente;

    public PedidoCreado(Cantidad cantidad, Estado estado, Cliente cliente) {
        super("org.sofka.pedido.eventos.PedidoCreado");
        this.cantidad = cantidad;
        this.estado = estado;
        this.cliente = cliente;
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
