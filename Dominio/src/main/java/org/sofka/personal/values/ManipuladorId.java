package org.sofka.personal.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Objeto de valor manipuladorId de la entidad Manipulador
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class ManipuladorId extends Identity {
    /**
     * Contructo vacío para ManipuladorId
     */
    public ManipuladorId(){

    }

    /**
     * Contructor para el objeto de valor ManipuladorId
     * @param id id del manipulador
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    private ManipuladorId(String id){
        super(id);
    }
    public static ManipuladorId of(String id){
        return new ManipuladorId(id);

    }
}
