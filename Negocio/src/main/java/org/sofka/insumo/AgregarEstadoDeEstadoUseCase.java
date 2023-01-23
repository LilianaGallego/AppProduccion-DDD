package org.sofka.insumo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.insumo.comandos.AgregarEstadoDeEstado;


/**
 * Caso de uso para agregar el estado del insumo
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class AgregarEstadoDeEstadoUseCase extends UseCase<RequestCommand<AgregarEstadoDeEstado>, ResponseEvents> {
    /**
     * Método para ejecutar el caso de uso
     *
     * @param agregarEstadoDeEstadoRequestCommand
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    @Override
    public void executeUseCase(RequestCommand<AgregarEstadoDeEstado>  agregarEstadoDeEstadoRequestCommand) {
        var command = agregarEstadoDeEstadoRequestCommand.getCommand();

        var insumo = Insumo.from(
                command.getInsumoId(), repository().getEventsBy(command.getInsumoId().value())
        );
        insumo.agregarEstadoDeEstado(command.getDisponible());
        emit().onResponse(new ResponseEvents(insumo.getUncommittedChanges()));
    }
}
