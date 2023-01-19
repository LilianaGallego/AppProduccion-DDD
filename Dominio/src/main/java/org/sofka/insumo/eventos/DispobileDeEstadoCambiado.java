package org.sofka.insumo.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.insumo.values.Disponible;
import org.sofka.insumo.values.EstadoId;

public class DispobileDeEstadoCambiado extends DomainEvent {
    private final EstadoId estadoId;
    private final Disponible disponible;

    public DispobileDeEstadoCambiado(EstadoId estadoId, Disponible disponible){
        super("org.sofka.insumo.eventos.DispobileDeEstadoCambiado");
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
