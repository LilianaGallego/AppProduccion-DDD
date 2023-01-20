package org.sofka.insumo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.insumo.comandos.CambiarDispobileDeEstado;

public class CambiarDisponibleDeEstadoUseCase extends UseCase<RequestCommand<CambiarDispobileDeEstado>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarDispobileDeEstado> cambiarDispobileDeEstadoRequestCommand) {
        var command = cambiarDispobileDeEstadoRequestCommand.getCommand();

        var insumo = Insumo.from(command.getInsumoId(),repository().getEventsBy(command.getInsumoId().value()));
        insumo.cambiarDisponibleDeEstado(command.getEstadoId(),command.getDisponible());

        emit().onResponse(new ResponseEvents(insumo.getUncommittedChanges()));

    }
}
