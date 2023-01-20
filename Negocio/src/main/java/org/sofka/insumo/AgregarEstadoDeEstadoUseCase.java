package org.sofka.insumo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.insumo.comandos.AgregarEstadoDeEstado;

public class AgregarEstadoDeEstadoUseCase extends UseCase<RequestCommand<AgregarEstadoDeEstado>, ResponseEvents> {
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
