package org.sofka.insumo.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.insumo.values.Disponible;
import org.sofka.insumo.values.EstadoId;
import org.sofka.insumo.values.InsumoId;

/**
 * Comando para agregar el estado del insumo
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class AgregarEstadoDeEstado extends Command {
    /**
     * Identificador del insumo
     */
    private final InsumoId insumoId;
    /**
     * Objeto valor del estado
     */
    private final Disponible disponible;

    /**
     * Método constructor para agregar el estado
     *
     * @param insumoId identificador del insumo
     * @param disponible objeto valor del estado
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public AgregarEstadoDeEstado(InsumoId insumoId, Disponible disponible){

        this.insumoId = insumoId;
        this.disponible = disponible;
    }

    /**
     * Método para obtener el insumoId
     * @return retorna el insumoId
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public InsumoId getInsumoId() {
        return insumoId;
    }

    /**
     * Método para saber si el insumo esta disponible
     * @return retorna disponible true or false
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Disponible getDisponible() {
        return disponible;
    }
}
