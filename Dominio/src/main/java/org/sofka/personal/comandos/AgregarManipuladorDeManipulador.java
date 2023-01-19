package org.sofka.personal.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.personal.values.ManipuladorId;
import org.sofka.personal.values.Seccion;

public class AgregarManipuladorDeManipulador extends Command {
    private final ManipuladorId manipuladorId;
    private final Seccion seccion;

    public AgregarManipuladorDeManipulador(ManipuladorId manipuladorId, Seccion seccion) {
        this.manipuladorId = manipuladorId;
        this.seccion = seccion;
    }

    public ManipuladorId getManipuladorId() {
        return manipuladorId;
    }

    public Seccion getSeccion() {
        return seccion;
    }
}
