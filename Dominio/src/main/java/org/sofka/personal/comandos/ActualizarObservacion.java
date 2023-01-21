package org.sofka.personal.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.personal.values.Bpm;
import org.sofka.personal.values.PersonalId;

/**
 * Comando para actualizar una observación
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class ActualizarObservacion extends Command {
    /**
     * Identificador del perssonal
     *
     */
    private final PersonalId personalId;
    /**
     * Objeto valor Bpm del personal
     *
     */
    private final Bpm bpm;

    /**
     * Método constructor para actualizar la observacion
     *
     * @param personalId identificador del estado
     * @param bpm objeto valor del estado
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public ActualizarObservacion( PersonalId personalId,Bpm bpm) {

        this.personalId = personalId;
        this.bpm = bpm;
    }

    /**
     * Método para obtener la observacion del personal
     * @return retorna el bpm
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Bpm getBpm() {
        return bpm;
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
}
