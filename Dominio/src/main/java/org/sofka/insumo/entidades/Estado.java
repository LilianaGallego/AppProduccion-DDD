package org.sofka.insumo.entidades;

import co.com.sofka.domain.generic.Entity;
import org.sofka.insumo.values.Disponible;
import org.sofka.insumo.values.EstadoId;

import java.util.Objects;

public class Estado extends Entity<EstadoId> {
    private Disponible disponible;

    public Estado(EstadoId estadoId, Disponible disponible) {
        super(estadoId);
        this.disponible = disponible;
    }

    public void cambiarDisponible(Disponible disponible){
        this.disponible = Objects.requireNonNull(disponible);
    }

    public Disponible getDisponible() {
        return disponible;
    }
}
