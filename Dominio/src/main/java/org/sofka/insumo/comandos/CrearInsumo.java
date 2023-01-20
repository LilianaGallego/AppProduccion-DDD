package org.sofka.insumo.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.insumo.entidades.Estado;
import org.sofka.insumo.entidades.Item;
import org.sofka.insumo.values.Clasificacion;
import org.sofka.insumo.values.InsumoId;

import java.util.Set;

/**
 * Comando para crear el insumo
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class CrearInsumo extends Command {
    /**
     * Identificador del insumo
     */
    private final InsumoId insumoId;
    private final Set<Item> items;
    private final Estado estado;
    /**
     * Objeto Valor para clasificar el insumo
     */
    private final Clasificacion clasificacion;

    /**
     * Método constructor para crear un insumo
     *
     * @param insumoId identificador del insumo
     * @param clasificacion clasifica el insumo
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public CrearInsumo(InsumoId insumoId, Set<Item> items, Estado estado, Clasificacion clasificacion) {
        this.items = items;
        this.estado = estado;
        this.clasificacion = clasificacion;
        this.insumoId = insumoId;
    }

    /**
     * Método para obtener el insumoId
     * @return retorna el insumoId
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public InsumoId getInsumoId() {
        return insumoId;
    }

    /**
     * Método para saber la clase del insumo
     * @return retorna la clase del insumo
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public Set<Item> getItems() {
        return items;
    }

    public Estado getEstado() {
        return estado;
    }
}
