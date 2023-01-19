package org.sofka.insumo.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.insumo.values.Clasificacion;

public class InsumoCreado extends DomainEvent {
    private final Clasificacion clasificacion;
    public InsumoCreado(Clasificacion clasificacion) {
        super("org.sofka.insumo.eventos.InsumoCreado");
        this.clasificacion = clasificacion;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }
}
