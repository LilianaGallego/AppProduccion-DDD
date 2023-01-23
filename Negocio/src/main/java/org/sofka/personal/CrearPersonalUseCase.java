package org.sofka.personal;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.personal.comandos.CrearPersonal;

/**
 * Caso de uso para crear el personal
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class CrearPersonalUseCase extends UseCase<RequestCommand<CrearPersonal>, ResponseEvents> {
    /**
     * Método para ejecutar el caso de uso
     *
     * @param crearPersonalRequestCommand
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    @Override
    public void executeUseCase(RequestCommand<CrearPersonal> crearPersonalRequestCommand) {
        var command = crearPersonalRequestCommand.getCommand();

        var personal = new Personal(command.getPersonalId(), command.getBpmPersonal());

        emit().onResponse(new ResponseEvents(personal.getUncommittedChanges()));
    }
}
