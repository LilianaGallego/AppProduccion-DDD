package org.sofka.pedido.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.pedido.values.Completado;
import org.sofka.pedido.values.EstadoId;

public class EstadoDeEstadoAgregado extends DomainEvent {
    private final EstadoId estadoId;
    private final Completado completado;

    public EstadoDeEstadoAgregado(EstadoId estadoId, Completado completado){
        super("org.sofka.insumo.eventos.EstadoDeEstadoAgregado");

        this.estadoId = estadoId;
        this.completado = completado;
    }

    public EstadoId getEstadoId() {
        return estadoId;
    }

    public Completado getCompletado() {
        return completado;
    }
}
