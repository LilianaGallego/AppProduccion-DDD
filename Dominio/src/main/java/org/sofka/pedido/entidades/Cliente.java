package org.sofka.pedido.entidades;

import co.com.sofka.domain.generic.Entity;
import org.sofka.pedido.values.ClienteId;
import org.sofka.pedido.values.Contacto;
import org.sofka.pedido.values.Dieta;
import org.sofka.pedido.values.PedidoId;

import java.util.Objects;

public class Cliente extends Entity<ClienteId> {
    private Dieta dieta;
    private final ClienteId clienteId;
    private final PedidoId pedidoId;
    private Contacto contacto;

    public Cliente(ClienteId clienteId, PedidoId pedidoId, Contacto contacto, Dieta dieta){
        super(clienteId);
        this.clienteId = clienteId;
        this.pedidoId = pedidoId;
        this.contacto = contacto;
        this.dieta = dieta;

    }

    public void actualizarContacto(Contacto contacto){
        this.contacto = Objects.requireNonNull(contacto);

    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
