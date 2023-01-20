package org.sofka.pedido.values;

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
     * Contructo vacío para EstadoId
     */
    public EstadoId(){

    }
    /**
     *Contructor para el objeto de valor EstadoId
     * @param id id del estado
     */
    private EstadoId(String id){
        super(id);
    }
    /**
     * Método estático para crear un objeto de valor de tipo EstadoId
     * @param id id del estado
     * @return objeto de valor de tipo EstadoId
     */
    public static EstadoId of(String id){
        return new EstadoId(id);

    }
}
