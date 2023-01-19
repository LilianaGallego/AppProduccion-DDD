package org.sofka.insumo.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.insumo.values.Clasificacion;
import org.sofka.insumo.values.InsumoId;

public class CrearInsumo extends Command {
    private final InsumoId insumoId;
    private final Clasificacion clasificacion;

    public CrearInsumo(InsumoId insumoId, Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
        this.insumoId = insumoId;
    }

    public InsumoId getInsumoId() {
        return insumoId;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }
}
