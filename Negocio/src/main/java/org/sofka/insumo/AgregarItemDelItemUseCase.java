package org.sofka.insumo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.insumo.comandos.AgregarItemDelItem;

public class AgregarItemDelItemUseCase extends UseCase<RequestCommand<AgregarItemDelItem>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarItemDelItem> agregarItemDelItemRequestCommand) {
        var command = agregarItemDelItemRequestCommand.getCommand();
        Insumo insumo = Insumo.from(command.getInsumoId(), repository().getEventsBy(command.getInsumoId().value()));

        insumo.agregarItemDeItem(command.getNombre(),command.getInsumoId() ,command.getCantidad());

        emit().onResponse(new ResponseEvents(insumo.getUncommittedChanges()));

    }
}
