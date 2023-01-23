package org.sofka.insumo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.insumo.comandos.CrearInsumo;

/**
 * Caso de uso para crear un insumo
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class CrearInsumoUseCase extends UseCase<RequestCommand<CrearInsumo>, ResponseEvents> {
    /**
     * Método para ejecutar el caso de uso
     *
     * @param crearInsumoRequestCommand
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    @Override
    public void executeUseCase(RequestCommand<CrearInsumo> crearInsumoRequestCommand) {
        var command = crearInsumoRequestCommand.getCommand();

        var insumo = new Insumo(command.getInsumoId(),command.getItems(),command.getEstado(),command.getClasificacion());

        emit().onResponse(new ResponseEvents(insumo.getUncommittedChanges()));
    }
}
