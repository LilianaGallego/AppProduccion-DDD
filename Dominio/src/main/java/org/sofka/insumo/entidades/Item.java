package org.sofka.insumo.entidades;

import co.com.sofka.domain.generic.Entity;
import org.sofka.insumo.values.Cantidad;
import org.sofka.insumo.values.ItemId;
import org.sofka.insumo.values.Nombre;

/**
 * Entidad item del insumo
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class Item extends Entity<ItemId> {
    /**
     * Objeto valor nombre del item
     */
    private Nombre nombre;
    /**
     * Objeto valor cantidad del item
     */
    private Cantidad cantidad;

    /**
     * Método constructor del item del insumo
     *
     * @param itemId identificador del item
     * @param nombre objeto valor nombre del item
     * @param cantidad objeto valor cantidad del item
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Item(ItemId itemId, Nombre nombre, Cantidad cantidad) {
        super(itemId);
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
}
