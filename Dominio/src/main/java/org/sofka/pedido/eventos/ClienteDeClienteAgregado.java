package org.sofka.pedido.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.pedido.values.ClienteId;
import org.sofka.pedido.values.Contacto;
import org.sofka.pedido.values.Dieta;
import org.sofka.pedido.values.PedidoId;

public class ClienteDeClienteAgregado extends DomainEvent {
    private final ClienteId clienteId;
    private final PedidoId pedidoId;
    private final Contacto contacto;
    private final Dieta dieta;

    public ClienteDeClienteAgregado(ClienteId clienteId, PedidoId pedidoId, Contacto contacto, Dieta dieta){
        super("org.sofka.insumo.eventos.ClienteDeClienteAgregado");
        this.clienteId = clienteId;
        this.pedidoId = pedidoId;
        this.contacto = contacto;
        this.dieta = dieta;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Dieta getDieta() {
        return dieta;
    }
}
