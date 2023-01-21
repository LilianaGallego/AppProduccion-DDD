package org.sofka.personal.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.personal.values.PersonalId;
import org.sofka.personal.values.Seccion;

/**
 * Comando para agregar un manipulador
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class AgregarManipuladorDeManipulador extends Command {
    /**
     * Identificador del perssonal
     *
     */
    private final PersonalId personalId;
    /**
     * Objeto valor Seccion del manipulador
     *
     */
    private final Seccion seccion;

    /**
     * Método constructor para agregar un manipulador
     *
     * @param personalId identificador del estado
     * @param seccion objeto valor del manipulador
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public AgregarManipuladorDeManipulador(PersonalId personalId, Seccion seccion) {
        this.personalId = personalId;
        this.seccion = seccion;
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
     * Método para obtener la sección del manipulador
     * @return retorna la sección del manipulador
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Seccion getSeccion() {
        return seccion;
    }
}
