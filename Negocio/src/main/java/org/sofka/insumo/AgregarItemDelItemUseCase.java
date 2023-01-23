package org.sofka.insumo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.insumo.comandos.AgregarItemDelItem;

/**
 * Caso de uso para agregar el item del insumo
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class AgregarItemDelItemUseCase extends UseCase<RequestCommand<AgregarItemDelItem>, ResponseEvents> {
    /**
     * Método para ejecutar el caso de uso
     *
     * @param agregarItemDelItemRequestCommand
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    @Override
    public void executeUseCase(RequestCommand<AgregarItemDelItem> agregarItemDelItemRequestCommand) {
        var command = agregarItemDelItemRequestCommand.getCommand();
        Insumo insumo = Insumo.from(command.getInsumoId(), repository().getEventsBy(command.getInsumoId().value()));

        insumo.agregarItemDeItem(command.getNombre(),command.getInsumoId() ,command.getCantidad());

        emit().onResponse(new ResponseEvents(insumo.getUncommittedChanges()));

    }
}
