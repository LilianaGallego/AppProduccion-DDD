package org.sofka.insumo.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Objeto de valor ItemId de la entidad Item
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class ItemId extends Identity {

    /**
     * Método constructor vacio para el ItemId
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public ItemId(){

    }

    /**
     * Método constructor
     *
     * @param id identificador del item
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    private ItemId(String id){
        super(id);
    }
    public static ItemId of(String id){
        return new ItemId(id);

    }
}
