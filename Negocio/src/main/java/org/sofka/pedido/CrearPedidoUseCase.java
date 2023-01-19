package org.sofka.pedido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.pedido.comandos.CrearPedido;

public class CrearPedidoUseCase extends UseCase<RequestCommand<CrearPedido>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearPedido> crearPedidoRequestCommand) {
        var command = crearPedidoRequestCommand.getCommand();
        var pedido = new Pedido(command.getPedidoId(), command.getCantidad());
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));

    }
}
