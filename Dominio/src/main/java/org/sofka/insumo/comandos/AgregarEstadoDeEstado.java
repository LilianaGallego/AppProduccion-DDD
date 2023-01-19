package org.sofka.insumo.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.insumo.values.Disponible;
import org.sofka.insumo.values.EstadoId;
import org.sofka.insumo.values.InsumoId;

public class AgregarEstadoDeEstado extends Command {
    private final InsumoId insumoId;
    private final EstadoId estadoId;
    private final Disponible disponible;

    public AgregarEstadoDeEstado(InsumoId insumoId, EstadoId estadoId, Disponible disponible){

        this.insumoId = insumoId;
        this.estadoId = estadoId;
        this.disponible = disponible;
    }

    public InsumoId getInsumoId() {
        return insumoId;
    }

    public EstadoId getEstadoId() {
        return estadoId;
    }

    public Disponible getDisponible() {
        return disponible;
    }
}
