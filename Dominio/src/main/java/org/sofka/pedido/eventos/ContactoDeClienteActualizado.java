package org.sofka.pedido.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.pedido.entidades.Cliente;
import org.sofka.pedido.values.ClienteId;
import org.sofka.pedido.values.Contacto;

public class ContactoDeClienteActualizado extends DomainEvent {

    private final ClienteId clienteId;
    private final Contacto contacto;
    private final Cliente cliente;

    public ContactoDeClienteActualizado(ClienteId clienteId, Contacto contacto, Cliente cliente){
        super("org.sofka.insumo.eventos.ContactoDeClienteActualizado");
        this.clienteId = clienteId;
        this.contacto = contacto;
        this.cliente = cliente;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Contacto getContacto() {
        return contacto;
    }
}
