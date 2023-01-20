package org.sofka.pedido.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.pedido.values.ClienteId;
import org.sofka.pedido.values.Contacto;
import org.sofka.pedido.values.Dieta;
import org.sofka.pedido.values.PedidoId;

public class AgregarClienteDeCliente extends Command {
    private final PedidoId pedidoId;
    private final ClienteId clienteId;
    private final Contacto contacto;
    private final Dieta dieta;

    public AgregarClienteDeCliente(PedidoId pedidoId, ClienteId clienteId, Contacto contacto, Dieta dieta){
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.contacto = contacto;
        this.dieta = dieta;
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

    public Dieta getDieta() {
        return dieta;
    }
}
