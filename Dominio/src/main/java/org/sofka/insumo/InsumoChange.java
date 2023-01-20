package org.sofka.insumo;

import co.com.sofka.domain.generic.EventChange;
import org.sofka.insumo.entidades.Estado;
import org.sofka.insumo.entidades.Item;
import org.sofka.insumo.eventos.DispobileDeEstadoCambiado;
import org.sofka.insumo.eventos.EstadoDeEstadoAgregado;
import org.sofka.insumo.eventos.InsumoCreado;
import org.sofka.insumo.eventos.ItemDelItemAgregado;

import java.util.HashSet;

/**
 * Se aplican los eventos del dominio del Insumo
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class InsumoChange extends EventChange {
    public InsumoChange(Insumo insumo) {
        apply((InsumoCreado event) -> {
            insumo.clasificacion = event.getClasificacion();
            insumo.items = event.getItems();
            insumo.estado = event.getEstado();
        });

        apply((EstadoDeEstadoAgregado event) -> {
            insumo.estado = new Estado(event.getEstadoId(), event.getDisponible());
        });

        apply((DispobileDeEstadoCambiado event) -> {
            insumo.estado = new Estado(event.getEstadoId(), event.getDisponible());
        });

        apply((ItemDelItemAgregado event) -> {
            insumo.items.add(new Item(event.getItemId(),event.getInsumoId() ,event.getNombre(), event.getCantidad()));
        });
    }
}
