package org.sofka.insumo.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.insumo.values.Disponible;
import org.sofka.insumo.values.EstadoId;

public class EstadoDeEstadoAgregado extends DomainEvent {
    private final EstadoId estadoId;
    private final Disponible disponible;

    public EstadoDeEstadoAgregado(EstadoId estadoId, Disponible disponible){
        super("org.sofka.insumo.eventos.EstadoDeEstadoAgregado");
        this.estadoId = estadoId;
        this.disponible = disponible;
    }

    public EstadoId getEstadoId() {
        return estadoId;
    }

    public Disponible getDisponible() {
        return disponible;
    }
}
