package org.sofka.personal.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.personal.values.Experiencia;
import org.sofka.personal.values.PersonalId;

/**
 * Comando para agregar el personal jefe
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class AgregarJefeDeJefe extends Command {
    /**
     * Identificador del personal
     */
    private final PersonalId personalId;
    /**
     * Experiencia del jefe
     */
    private final Experiencia experiencia;

    /**
     * Método constructor para agregar el jefe
     *
     * @param personalId identificador del personal
     * @param experiencia objeto valor experiencia del jefe
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public AgregarJefeDeJefe(PersonalId personalId, Experiencia experiencia) {
        this.personalId = personalId;
        this.experiencia = experiencia;
    }

    /**
     * Método para obtener el personalId
     * @return retorna el personalId
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public PersonalId getPersonalId() {
        return personalId;
    }


    /**
     * Método para obtener la experiencia del jefe
     * @return retorna la experiencia
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Experiencia getExperiencia() {
        return experiencia;
    }
}
