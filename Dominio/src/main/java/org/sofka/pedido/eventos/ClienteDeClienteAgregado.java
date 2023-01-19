package org.sofka.pedido.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.pedido.values.ClienteId;
import org.sofka.pedido.values.Contacto;

public class ClienteDeClienteAgregado extends DomainEvent {
    private final ClienteId clienteId;
    private final Contacto contacto;

    public ClienteDeClienteAgregado(ClienteId clienteId, Contacto contacto){
        super("org.sofka.insumo.eventos.ClienteDeClienteAgregado");
        this.clienteId = clienteId;
        this.contacto = contacto;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Contacto getContacto() {
        return contacto;
    }
}
