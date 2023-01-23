package org.sofka.personal;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.personal.comandos.AgregarJefeDeJefe;

/**
 * Caso de uso para agregar el jefe
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class AgregarJefeDeJefeUseCase extends UseCase<RequestCommand<AgregarJefeDeJefe>, ResponseEvents> {
    /**
     * Método para ejecutar el caso de uso
     *
     * @param agregarJefeDeJefeRequestCommand
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
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
