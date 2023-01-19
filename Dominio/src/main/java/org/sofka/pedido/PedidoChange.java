package org.sofka.pedido;

import co.com.sofka.domain.generic.EventChange;
import org.sofka.pedido.eventos.PedidoCreado;

public class PedidoChange extends EventChange {
    public PedidoChange(Pedido pedido){
        apply((PedidoCreado event)->{
            pedido.cantidad = event.getCantidad();
        });

    }
}
