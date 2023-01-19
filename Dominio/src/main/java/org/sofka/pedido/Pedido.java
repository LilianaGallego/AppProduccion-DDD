package org.sofka.pedido;


import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.pedido.eventos.ClienteDeClienteAgregado;
import org.sofka.pedido.eventos.ContactoDeClienteActualizado;
import org.sofka.pedido.eventos.EstadoDeEstadoAgregado;
import org.sofka.pedido.eventos.PedidoCreado;
import org.sofka.pedido.values.*;
import org.sofka.pedido.entidades.Cliente;
import org.sofka.pedido.entidades.Estado;

import java.util.List;
import java.util.Objects;

public class Pedido extends AggregateEvent<PedidoId> {
    protected Estado estado;
    protected Cliente cliente;
    protected Cantidad cantidad;

    public Pedido(PedidoId pedidoId, Cantidad cantidad) {
        super(pedidoId);
        appendChange(new PedidoCreado(cantidad)).apply();
    }
    private Pedido(PedidoId pedidoId) {
        super(pedidoId);
        subscribe(new PedidoChange(this));

    }

    public static Pedido from(PedidoId pedidoId, List<DomainEvent> events){
        var pedido = new Pedido(pedidoId);
        events.forEach(pedido::applyEvent);
        return pedido;
    }

    public void agregarEstadoDeEstado(EstadoId estadoId, Completado completado){
        Objects.requireNonNull(estadoId);
        Objects.requireNonNull(completado);
        appendChange(new EstadoDeEstadoAgregado(estadoId, completado)).apply();
    }

    public void agregarClienteDeCliente(ClienteId clienteId, Contacto contacto){
        Objects.requireNonNull(clienteId);
        Objects.requireNonNull(contacto);
        appendChange(new ClienteDeClienteAgregado(clienteId, contacto)).apply();
    }

    public void ActualizarContactoDeCliente(ClienteId clienteId, Contacto contacto){
        Objects.requireNonNull(clienteId);
        Objects.requireNonNull(contacto);
        appendChange(new ContactoDeClienteActualizado(clienteId, contacto)).apply();
    }


}
