package org.sofka.insumo.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Objeto de valor InsumoId del AR Insumo
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class InsumoId extends Identity {

    /**
     * Método constructor vacio para el InsumoId
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public InsumoId(){

    }

    /**
     * Método constructor
     *
     * @param id identificador del insumo
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    private InsumoId(String id){
        super(id);
    }
    public static InsumoId of(String id){
        return new InsumoId(id);

    }
}
