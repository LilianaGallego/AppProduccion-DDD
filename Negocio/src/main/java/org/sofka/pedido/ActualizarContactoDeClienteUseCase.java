package org.sofka.pedido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.pedido.comandos.ActualizarContactoDeCliente;
import org.sofka.pedido.entidades.Cliente;

public class ActualizarContactoDeClienteUseCase extends UseCase<RequestCommand<ActualizarContactoDeCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarContactoDeCliente> actualizarContactoDeClienteRequestCommand) {
        var command = actualizarContactoDeClienteRequestCommand.getCommand();

        var pedido = Pedido.from(command.getPedidoId(),repository().getEventsBy(command.getPedidoId().value()));
        pedido.actualizarContactoDeCliente(command.getClienteId(), command.getContacto());

        pedido.actualizarContactoDeCliente(command.getClienteId(),command.getContacto());

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
