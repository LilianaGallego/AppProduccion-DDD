package org.sofka.pedido.entidades;

import co.com.sofka.domain.generic.Entity;
import org.sofka.pedido.values.Completado;
import org.sofka.pedido.values.EstadoId;

public class Estado extends Entity<EstadoId> {

    private final Completado completado;

    public Estado(EstadoId estadoId, Completado completado){
        super(estadoId);
        this.completado = completado;
    }

    public Completado getCompletado() {
        return completado;
    }
}
