package org.sofka.personal;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.personal.comandos.CrearPersonal;

public class CrearPersonalUseCase extends UseCase<RequestCommand<CrearPersonal>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearPersonal> crearPersonalRequestCommand) {
        var command = crearPersonalRequestCommand.getCommand();

        var personal = new Personal(command.getPersonalId(), command.getBpmPersonal());

        emit().onResponse(new ResponseEvents(personal.getUncommittedChanges()));
    }
}
