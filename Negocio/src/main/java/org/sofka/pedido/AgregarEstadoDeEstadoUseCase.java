package org.sofka.pedido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.pedido.comandos.AgregarEstadoDeEstado;

public class AgregarEstadoDeEstadoUseCase extends UseCase<RequestCommand<AgregarEstadoDeEstado>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarEstadoDeEstado> agregarEstadoDeEstadoRequestCommand) {
        var command = agregarEstadoDeEstadoRequestCommand.getCommand();
        var pedido = Pedido.from(command.getPedidoId(),repository().getEventsBy(command.getPedidoId().value()));
        pedido.agregarEstadoDeEstado(command.getEstadoId(),command.getPedidoId(),command.getCompletado());

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
