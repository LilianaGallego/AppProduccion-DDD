package org.sofka.insumo;

import co.com.sofka.domain.generic.EventChange;
import org.sofka.insumo.eventos.InsumoCreado;

public class InsumoChange extends EventChange {
    public InsumoChange(Insumo insumo) {
        apply((InsumoCreado event) -> {
            insumo.clasificacion = event.getClasificacion();
        });
    }
}
