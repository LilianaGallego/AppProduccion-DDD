package org.sofka.pedido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.pedido.comandos.ActualizarContactoDeCliente;
import org.sofka.pedido.entidades.Cliente;

/**
 * Caso de uso para actualizar el contacto del cliente
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class ActualizarContactoDeClienteUseCase extends UseCase<RequestCommand<ActualizarContactoDeCliente>, ResponseEvents> {
    /**
     * Método para ejecutar el caso de uso
     *
     * @param actualizarContactoDeClienteRequestCommand
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    @Override
    public void executeUseCase(RequestCommand<ActualizarContactoDeCliente> actualizarContactoDeClienteRequestCommand) {
        var command = actualizarContactoDeClienteRequestCommand.getCommand();

        var pedido = Pedido.from(command.getPedidoId(),repository().getEventsBy(command.getPedidoId().value()));
        pedido.actualizarContactoDeCliente(command.getClienteId(), command.getContacto(), command.getCliente());

        pedido.actualizarContactoDeCliente(command.getClienteId(),command.getContacto(),command.getCliente());

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
