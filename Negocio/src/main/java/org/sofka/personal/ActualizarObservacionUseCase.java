package org.sofka.personal;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.personal.comandos.ActualizarObservacion;

/**
 * Caso de uso para actualizar la observación del personal
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class ActualizarObservacionUseCase extends UseCase<RequestCommand<ActualizarObservacion>, ResponseEvents> {
    /**
     * Método para ejecutar el caso de uso
     *
     * @param actualizarObservacionRequestCommand
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    @Override
    public void executeUseCase(RequestCommand<ActualizarObservacion> actualizarObservacionRequestCommand) {
        var command = actualizarObservacionRequestCommand.getCommand();
        var personal = Personal.from(command.getPersonalId(),repository().getEventsBy(command.getPersonalId().value()));
        personal.actualizarObservacion(command.getPersonalId(),command.getBpm());
        emit().onResponse(new ResponseEvents(personal.getUncommittedChanges()));

    }
}
