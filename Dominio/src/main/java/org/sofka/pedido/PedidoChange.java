package org.sofka.pedido;

import co.com.sofka.domain.generic.EventChange;
import org.sofka.pedido.entidades.Cliente;
import org.sofka.pedido.entidades.Estado;
import org.sofka.pedido.eventos.ClienteDeClienteAgregado;
import org.sofka.pedido.eventos.ContactoDeClienteActualizado;
import org.sofka.pedido.eventos.EstadoDeEstadoAgregado;
import org.sofka.pedido.eventos.PedidoCreado;
import org.sofka.pedido.values.Completado;

public class PedidoChange extends EventChange {
    public PedidoChange(Pedido pedido){
        apply((PedidoCreado event)->{
            pedido.cantidad = event.getCantidad();
        });
        apply((EstadoDeEstadoAgregado event)->{
            pedido.estado = new Estado(event.getEstadoId(),event.getPedidoId(),event.getCompletado());
        });
        apply((ClienteDeClienteAgregado event)->{
            pedido.cliente = new Cliente(event.getClienteId(),event.getPedidoId(),event.getContacto(),event.getDieta());

        });
        apply((ContactoDeClienteActualizado event)->{
            pedido.cliente = event.getCliente();
        });

    }
}
