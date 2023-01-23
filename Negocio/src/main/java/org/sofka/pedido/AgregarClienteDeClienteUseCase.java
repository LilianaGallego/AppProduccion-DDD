package org.sofka.pedido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.pedido.comandos.AgregarClienteDeCliente;

/**
 * Caso de uso para agregar el cliente
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class AgregarClienteDeClienteUseCase extends UseCase<RequestCommand<AgregarClienteDeCliente>, ResponseEvents> {
    /**
     * Método para ejecutar el caso de uso
     *
     * @param agregarClienteDeClienteRequestCommand
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    @Override
    public void executeUseCase(RequestCommand<AgregarClienteDeCliente> agregarClienteDeClienteRequestCommand) {
        var command = agregarClienteDeClienteRequestCommand.getCommand();
        var pedido = Pedido.from(command.getPedidoId(),repository().getEventsBy(command.getPedidoId().value()));
        pedido.agregarClienteDeCliente(command.getClienteId(),command.getPedidoId(), command.getContacto(), command.getDieta());

        pedido.agregarClienteDeCliente(command.getClienteId(),command.getPedidoId() ,command.getContacto(), command.getDieta());

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
