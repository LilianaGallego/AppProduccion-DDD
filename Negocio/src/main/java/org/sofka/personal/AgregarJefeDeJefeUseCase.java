package org.sofka.personal;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.personal.comandos.AgregarJefeDeJefe;
import org.sofka.personal.entidades.Jefe;

public class AgregarJefeDeJefeUseCase extends UseCase<RequestCommand<AgregarJefeDeJefe>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarJefeDeJefe> agregarJefeDeJefeRequestCommand) {
        var command = agregarJefeDeJefeRequestCommand.getCommand();

        var personal = Personal.from(
                command.getPersonalId(), repository().getEventsBy(command.getPersonalId().value())
        );
        personal.agregarJefe(command.getExperiencia());

        emit().onResponse(new ResponseEvents(personal.getUncommittedChanges()));
    }
}
