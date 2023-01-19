package org.sofka.personal.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.personal.values.ManipuladorId;
import org.sofka.personal.values.Seccion;

public class ManipuladorAgregado extends DomainEvent {
    private final ManipuladorId manipuladorId;
    private final Seccion seccion;


    public ManipuladorAgregado(ManipuladorId manipuladorId, Seccion seccion) {
        super("org.sofka.personal.eventos.manipuladoragregado");
        this.manipuladorId = manipuladorId;
        this.seccion = seccion;
    }
}
