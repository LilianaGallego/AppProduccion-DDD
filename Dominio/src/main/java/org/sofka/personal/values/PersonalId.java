package org.sofka.personal.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Objeto de valor personalId de la entidad Personal
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class PersonalId extends Identity {
    /**
     * Contructor vacío para PersonalId
     */
    public PersonalId(){

    }

    /**
     * Contructor para el objeto de valor PersonalId
     * @param id id del personal
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    private PersonalId(String id){
        super(id);
    }
    public static PersonalId of(String id){
        return new PersonalId(id);

    }
}
