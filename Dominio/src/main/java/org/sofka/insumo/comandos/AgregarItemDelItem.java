package org.sofka.insumo.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.insumo.values.Cantidad;
import org.sofka.insumo.values.InsumoId;
import org.sofka.insumo.values.Nombre;

/**
 * Comando para agregar el item del insumo
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class AgregarItemDelItem extends Command {
    /**
     * Identificador del insumo
     */
    private final InsumoId insumoId;

    /**
     * Nombre del item insumo
     */
    private final Nombre nombre;
    /**
     * Cantidad del item insumo
     */
    private final Cantidad cantidad;

    /**
     * Método constructor para agregar el item
     *
     * @param insumoId identificador del insumo
     * @param nombre nombre del item insumo
     * @param cantidad cantidad del item insumo
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public AgregarItemDelItem(InsumoId insumoId, Nombre nombre, Cantidad cantidad){

        this.insumoId = insumoId;
        this.nombre = nombre;
        this.cantidad = cantidad;
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
     * Método para obtener el nombre del item insumo
     * @return retorna el nombre del item insumo
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Nombre getNombre() {
        return nombre;
    }

    /**
     * Método para obtener la cantidd del item insumo
     * @return retorna la cantidad del item insumo
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Cantidad getCantidad() {
        return cantidad;
    }
}
