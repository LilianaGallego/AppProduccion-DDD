package org.sofka.insumo;


import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.insumo.entidades.Estado;
import org.sofka.insumo.entidades.Item;
import org.sofka.insumo.eventos.DispobileDeEstadoCambiado;
import org.sofka.insumo.eventos.EstadoDeEstadoAgregado;
import org.sofka.insumo.eventos.InsumoCreado;
import org.sofka.insumo.eventos.ItemDelItemAgregado;
import org.sofka.insumo.values.*;
import org.sofka.pedido.values.PedidoId;
import org.sofka.personal.entidades.Manipulador;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Agregado root Insumo
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class Insumo extends AggregateEvent<InsumoId> {
    protected Set<Item> items;
    protected Estado estado;
    /**
     * Objeto Valor para clasificar el insumo
     */
    protected Clasificacion clasificacion;
    /**
     * Relación 1 a muchos  con la entidad item
     */

    /**
     * Relación 1 a 1 con la entidad Estado
     */




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
    public Insumo(InsumoId insumoId, Set<Item> items, Estado estado, Clasificacion clasificacion) {
        super(insumoId);
        this.items = items;
        this.estado = estado;
        appendChange(new InsumoCreado(insumoId,items,estado,clasificacion)).apply();
    }

    /**
     * Constructor privado para afectar los estados
     *
     * @param insumoId identificador del insumo
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    private Insumo(InsumoId insumoId) {
        super(insumoId);
        subscribe(new InsumoChange(this));

    }

    /**
     * Método para retornar los eventos de los insumos
     *
     * @param insumoId identificador del insumo
     * @param events lista de eventos
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public static Insumo from(InsumoId insumoId, List<DomainEvent> events){
        var insumo = new Insumo(insumoId);
        events.forEach(insumo::applyEvent);
        return insumo;
    }

    /**
     * Método  para agregar el item
     *
     * @param nombre nombre del item insumo
     * @param cantidad cantidad del item insumo
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public void agregarItemDeItem(Nombre nombre, InsumoId insumoId ,Cantidad cantidad){
        var itemId = new ItemId();
        Objects.requireNonNull(itemId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(cantidad);
        appendChange(new ItemDelItemAgregado(itemId, insumoId,nombre, cantidad)).apply();

    }

    /**
     * Método para agregar el estado
     *
     * @param disponible objeto valor del estado
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public void agregarEstadoDeEstado(Disponible disponible){
        var estadoId = new EstadoId();
        Objects.requireNonNull(estadoId);
        Objects.requireNonNull(disponible);
        appendChange(new EstadoDeEstadoAgregado(estadoId,disponible)).apply();

    }

    /**
     * Método para cambiar el estado disponible
     *
     * @param estadoId identificador del estado
     * @param disponible objeto valor del estado
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public void cambiarDisponibleDeEstado(EstadoId estadoId, Disponible disponible){
        Objects.requireNonNull(estadoId);
        Objects.requireNonNull(disponible);
        appendChange(new DispobileDeEstadoCambiado(estadoId,disponible)).apply();

    }

    public Set<Item> getItems(){
        return items;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }
}
