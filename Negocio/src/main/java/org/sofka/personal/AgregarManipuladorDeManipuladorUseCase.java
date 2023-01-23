package org.sofka.personal;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.personal.comandos.AgregarManipuladorDeManipulador;

/**
 * Caso de uso para agregar el manipulador
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class AgregarManipuladorDeManipuladorUseCase extends UseCase<RequestCommand<AgregarManipuladorDeManipulador>, ResponseEvents> {
    /**
     * Método para ejecutar el caso de uso
     *
     * @param agregarManipuladorDeManipuladorRequestCommand
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    @Override
    public void executeUseCase(RequestCommand<AgregarManipuladorDeManipulador> agregarManipuladorDeManipuladorRequestCommand) {
        var command = agregarManipuladorDeManipuladorRequestCommand.getCommand();
        Personal personal = Personal.from(command.getPersonalId(), repository().getEventsBy(command.getPersonalId().value()));

        personal.agregarManipulador(command.getSeccion());

        emit().onResponse(new ResponseEvents(personal.getUncommittedChanges()));

    }
}
