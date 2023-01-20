package org.sofka.pedido.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.pedido.entidades.Cliente;
import org.sofka.pedido.values.ClienteId;
import org.sofka.pedido.values.Contacto;
import org.sofka.pedido.values.PedidoId;

public class ActualizarContactoDeCliente extends Command {
    private final PedidoId pedidoId;
    private final ClienteId clienteId;
    private final Contacto contacto;
    private final Cliente cliente;

    public ActualizarContactoDeCliente(PedidoId pedidoId, ClienteId clienteId, Contacto contacto, Cliente cliente){
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.contacto = contacto;
        this.cliente = cliente;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
