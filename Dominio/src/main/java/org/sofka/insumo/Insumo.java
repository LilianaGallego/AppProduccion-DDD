package org.sofka.insumo;

import co.com.sofka.domain.generic.AggregateEvent;
import org.sofka.insumo.entidades.Estado;
import org.sofka.insumo.entidades.Item;
import org.sofka.insumo.eventos.InsumoCreado;
import org.sofka.insumo.values.Clasificacion;
import org.sofka.insumo.values.InsumoId;
import org.sofka.insumo.values.PedidoId;

import java.util.Set;

public class Insumo extends AggregateEvent<InsumoId> {
    protected Clasificacion clasificacion;
    protected Set<Item> items;
    protected Estado estado;
    protected PedidoId pedidoId;


    public Insumo(InsumoId insumoId, Clasificacion clasificacion) {
        super(insumoId);
        appendChange(new InsumoCreado(clasificacion)).apply();
    }

    public Insumo(InsumoId insumoId) {
        super(insumoId);

    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }
}
