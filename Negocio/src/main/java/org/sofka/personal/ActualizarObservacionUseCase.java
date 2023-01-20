package org.sofka.personal;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.personal.comandos.ActualizarObservacion;

public class ActualizarObservacionUseCase extends UseCase<RequestCommand<ActualizarObservacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarObservacion> actualizarObservacionRequestCommand) {
        var command = actualizarObservacionRequestCommand.getCommand();
        var personal = Personal.from(command.getPersonalId(),repository().getEventsBy(command.getPersonalId().value()));
        personal.actualizarObservacion(command.getPersonalId(),command.getBpm());
        emit().onResponse(new ResponseEvents(personal.getUncommittedChanges()));

    }
}
