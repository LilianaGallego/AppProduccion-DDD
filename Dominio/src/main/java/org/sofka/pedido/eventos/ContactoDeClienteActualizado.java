package org.sofka.pedido.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.pedido.values.ClienteId;
import org.sofka.pedido.values.Contacto;

public class ContactoDeClienteActualizado extends DomainEvent {

    private final ClienteId clienteId;
    private final Contacto contacto;

    public ContactoDeClienteActualizado(ClienteId clienteId, Contacto contacto){
        super("org.sofka.insumo.eventos.ContactoDeClienteActualizado");
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
