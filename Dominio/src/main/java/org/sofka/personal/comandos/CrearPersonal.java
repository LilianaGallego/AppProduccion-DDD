package org.sofka.personal.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.personal.values.Bpm;
import org.sofka.personal.values.PersonalId;

/**
 * Comando para crear el personal
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class CrearPersonal extends Command {
    /**
     * Identificador del perssonal
     *
     */
    private final PersonalId personalId;
    /**
     * Objeto valor Bpm del personal
     *
     */
    private final Bpm bpmPersonal;

    /**
     * Método constructor para agregar un manipulador
     *
     * @param personalId identificador del manipulador
     * @param bpmPersonal objeto valor del manipulador
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */

    public CrearPersonal(PersonalId personalId, Bpm bpmPersonal) {
        this.personalId = personalId;
        this.bpmPersonal = bpmPersonal;
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
     * Método para obtener el bpmPersonal
     * @return retorna el bpmPersonal
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Bpm getBpmPersonal() {
        return bpmPersonal;
    }
}
