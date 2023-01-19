package org.sofka.insumo.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.insumo.values.ItemId;

/**
 * Evento para el item agregado
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class ItemDelItemAgregado extends DomainEvent {

    /**
     * Identificador del item
     */
    private final ItemId itemId;
    /**
     * Nombre del item insumo
     */
    private final String nombre;
    /**
     * Cantidad del item insumo
     */
    private final String cantidad;

    /**
     * Método constructor el item agregado
     *
     * @param itemId identificador del item
     * @param nombre nombre del item insumo
     * @param cantidad cantidad del item insumo
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public ItemDelItemAgregado(ItemId itemId, String nombre, String cantidad){
        super("org.sofka.insumo.eventos.ItemDelItemAgregado");

        this.itemId = itemId;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    /**
     * Método para obtener el itemId
     * @return retorna el itemId
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public ItemId getItemId() {
        return itemId;
    }

    /**
     * Método para obtener el nombre del item insumo
     * @return retorna el nombre del item insumo
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public String getNombre() {
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
    public String getCantidad() {
        return cantidad;
    }
}
