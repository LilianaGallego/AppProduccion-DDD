package org.sofka.personal.entidades;
import co.com.sofka.domain.generic.Entity;
import org.sofka.personal.values.Seccion;
import org.sofka.personal.values.ManipuladorId;

/**
 * Entidad Manipulador del Personal
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class Manipulador extends Entity<ManipuladorId> {

    /**
     * Objeto valor seccion del manipulador
     */
    private Seccion seccion ;
    /**
     * Identificador del manipulador
     */
    private ManipuladorId manipuladorId;

    /**
     * Método constructor del manipulador
     *
     * @param manipuladorId identificador del manipulador
     * @param seccion objeto valor del manipulador
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
     public Manipulador(ManipuladorId manipuladorId, Seccion seccion) {
        super(manipuladorId);
         this.seccion = seccion;
    }

    /**
     * Comportamiento de la entidad manipulador para agregar manipulador
     *
     * @param manipuladorId identificador del manipulador
     * @param seccion objeto valor del manipulador
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public void agregarManipulador(ManipuladorId manipuladorId, Seccion seccion){
        this.manipuladorId = manipuladorId;
        this.seccion = seccion;
    }

    /**
     * Pone la sección del manipulador como publica
     * @return retorna la sección del manipulador
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Seccion seccion(){
        return seccion;
    }
}
