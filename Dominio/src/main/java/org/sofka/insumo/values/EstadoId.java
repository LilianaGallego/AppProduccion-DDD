package org.sofka.insumo.values;


import co.com.sofka.domain.generic.Identity;

/**
 * Objeto de valor EstadoId de la entidad Estado
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class EstadoId extends Identity {
    /**
     * Método constructor vacio para el EstadoId
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public EstadoId(){

    }

    /**
     * Método constructor
     *
     * @param id identificador del estado
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    private EstadoId(String id){
        super(id);
    }
    public static EstadoId of(String id){
        return new EstadoId(id);

    }
}
