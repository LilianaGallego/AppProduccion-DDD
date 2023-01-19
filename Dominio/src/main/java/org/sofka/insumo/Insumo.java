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

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Insumo extends AggregateEvent<InsumoId> {
    protected Clasificacion clasificacion;
    protected Set<Item> items;
    protected Estado estado;
    //protected PedidoId pedidoId;


    public Insumo(InsumoId insumoId, Clasificacion clasificacion) {
        super(insumoId);
        appendChange(new InsumoCreado(clasificacion)).apply();
    }

    private Insumo(InsumoId insumoId) {
        super(insumoId);
        subscribe(new InsumoChange(this));

    }

    public static Insumo from(InsumoId insumoId, List<DomainEvent> events){
        var insumo = new Insumo(insumoId);
        events.forEach(insumo::applyEvent);
        return insumo;
    }

    public void agregarItemDeItem(ItemId itemId, String nombre, String cantidad){
        Objects.requireNonNull(itemId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(cantidad);
        appendChange(new ItemDelItemAgregado(itemId, nombre, cantidad)).apply();

    }

    public void agregarEstadoDeEstado(EstadoId estadoId, Disponible disponible){
        Objects.requireNonNull(estadoId);
        Objects.requireNonNull(disponible);
        appendChange(new EstadoDeEstadoAgregado(estadoId,disponible)).apply();

    }

    public void cambiarDisponibleDeEstado(EstadoId estadoId, Disponible disponible){
        Objects.requireNonNull(estadoId);
        Objects.requireNonNull(disponible);
        appendChange(new DispobileDeEstadoCambiado(estadoId,disponible)).apply();

    }


}
