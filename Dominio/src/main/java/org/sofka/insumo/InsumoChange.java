package org.sofka.insumo;

import co.com.sofka.domain.generic.EventChange;
import org.sofka.insumo.entidades.Estado;
import org.sofka.insumo.entidades.Item;
import org.sofka.insumo.eventos.DispobileDeEstadoCambiado;
import org.sofka.insumo.eventos.EstadoDeEstadoAgregado;
import org.sofka.insumo.eventos.InsumoCreado;
import org.sofka.insumo.eventos.ItemDelItemAgregado;

public class InsumoChange extends EventChange {
    public InsumoChange(Insumo insumo) {
        apply((InsumoCreado event) -> {
            insumo.clasificacion = event.getClasificacion();
        });

        apply((EstadoDeEstadoAgregado event) -> {
            insumo.estado = new Estado(event.getEstadoId(), event.getDisponible());
        });

        apply((DispobileDeEstadoCambiado event) -> {
            insumo.estado = new Estado(event.getEstadoId(), event.getDisponible());
        });

        apply((ItemDelItemAgregado event) -> {
            insumo.items.add(new Item(event.getItemId(), event.getNombre(), event.getCantidad()));
        });
    }
}
