package org.sofka.insumo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.insumo.comandos.CambiarDispobileDeEstado;

/**
 * Caso de uso para cambiar el estado disponible
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class CambiarDisponibleDeEstadoUseCase extends UseCase<RequestCommand<CambiarDispobileDeEstado>, ResponseEvents> {
    /**
     * Método para ejecutar el caso de uso
     *
     * @param cambiarDispobileDeEstadoRequestCommand
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    @Override
    public void executeUseCase(RequestCommand<CambiarDispobileDeEstado> cambiarDispobileDeEstadoRequestCommand) {
        var command = cambiarDispobileDeEstadoRequestCommand.getCommand();

        var insumo = Insumo.from(command.getInsumoId(),repository().getEventsBy(command.getInsumoId().value()));
        insumo.cambiarDisponibleDeEstado(command.getEstadoId(),command.getDisponible());

        emit().onResponse(new ResponseEvents(insumo.getUncommittedChanges()));

    }
}
