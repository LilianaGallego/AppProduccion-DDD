package org.sofka.pedido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.pedido.comandos.AgregarClienteDeCliente;

public class AgregarClienteDeClienteUseCase extends UseCase<RequestCommand<AgregarClienteDeCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarClienteDeCliente> agregarClienteDeClienteRequestCommand) {
        var command = agregarClienteDeClienteRequestCommand.getCommand();
        var pedido = Pedido.from(command.getPedidoId(),repository().getEventsBy(command.getPedidoId().value()));
        pedido.agregarClienteDeCliente(command.getClienteId(), command.getContacto());

        pedido.agregarClienteDeCliente(command.getClienteId(), command.getContacto());

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
