package org.sofka.personal;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.personal.comandos.AgregarManipuladorDeManipulador;

public class AgregarManipuladorDeManipuladorUseCase extends UseCase<RequestCommand<AgregarManipuladorDeManipulador>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarManipuladorDeManipulador> agregarManipuladorDeManipuladorRequestCommand) {
        var command = agregarManipuladorDeManipuladorRequestCommand.getCommand();
        Personal personal = Personal.from(command.getPersonalId(), repository().getEventsBy(command.getPersonalId().value()));

        personal.agregarManipulador(command.getSeccion());

        emit().onResponse(new ResponseEvents(personal.getUncommittedChanges()));

    }
}
