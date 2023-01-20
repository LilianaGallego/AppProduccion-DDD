package org.sofka.insumo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.insumo.comandos.CrearInsumo;

public class CrearInsumoUseCase extends UseCase<RequestCommand<CrearInsumo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearInsumo> crearInsumoRequestCommand) {
        var command = crearInsumoRequestCommand.getCommand();

        var insumo = new Insumo(command.getInsumoId(),command.getItems(),command.getEstado(),command.getClasificacion());

        emit().onResponse(new ResponseEvents(insumo.getUncommittedChanges()));
    }
}
