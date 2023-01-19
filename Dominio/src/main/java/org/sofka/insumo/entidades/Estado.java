package org.sofka.insumo.entidades;

import co.com.sofka.domain.generic.Entity;
import org.sofka.insumo.values.Disponible;
import org.sofka.insumo.values.EstadoId;

import java.util.Objects;

/**
 * Entidad estado del insumo
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class Estado extends Entity<EstadoId> {
    /**
     * Objeto valor disponible del estado del insumo
     */
    private Disponible disponible;

    /**
     * Método constructor del estado del insumo
     *
     * @param estadoId identificador del estado
     * @param disponible objeto valor del estado
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Estado(EstadoId estadoId, Disponible disponible) {
        super(estadoId);
        this.disponible = disponible;
    }

    /**
     * Comportamiento de la entidad estado para cambiar disponible
     *
     * @param disponible objeto valor del estado
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public void cambiarDisponible(Disponible disponible){
        this.disponible = Objects.requireNonNull(disponible);
    }

    /**
     * Método para saber si el insumo esta disponible
     * @return retorna disponible true or false
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Disponible getDisponible() {
        return disponible;
    }
}
