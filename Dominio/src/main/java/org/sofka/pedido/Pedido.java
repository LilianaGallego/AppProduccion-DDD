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

    public Pedido(PedidoId pedidoId, Cantidad cantidad, Estado estado, Cliente cliente) {
        super(pedidoId);
        appendChange(new PedidoCreado(cantidad,estado,cliente)).apply();
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

    public void agregarEstadoDeEstado(EstadoId estadoId, PedidoId pedidoId, Completado completado){
        Objects.requireNonNull(estadoId);
        Objects.requireNonNull(completado);
        appendChange(new EstadoDeEstadoAgregado(estadoId,pedidoId ,completado)).apply();
    }

    public void agregarClienteDeCliente(ClienteId clienteId,PedidoId pedidoId, Contacto contacto, Dieta dieta){
        Objects.requireNonNull(clienteId);
        Objects.requireNonNull(contacto);
        appendChange(new ClienteDeClienteAgregado(clienteId,pedidoId, contacto,dieta)).apply();
    }

    public void actualizarContactoDeCliente(ClienteId clienteId, Contacto contacto){
        Objects.requireNonNull(clienteId);
        Objects.requireNonNull(contacto);
        appendChange(new ContactoDeClienteActualizado(clienteId, contacto)).apply();
    }


}
