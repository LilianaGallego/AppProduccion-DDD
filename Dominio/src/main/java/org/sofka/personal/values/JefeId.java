package org.sofka.personal.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Objeto de valor jefeId de la entidad Jefe
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class JefeId extends Identity {
    /**
     * Contructor vacío para JefeId
     */
    public JefeId(){

    }

    /**
     * Contructor para el objeto de valor JefeId
     * @param id id del jefe
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    private JefeId(String id){
        super(id);
    }
    public static JefeId of(String id){
        return new JefeId(id);

    }
}
