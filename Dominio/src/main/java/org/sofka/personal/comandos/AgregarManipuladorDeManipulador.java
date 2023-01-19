package org.sofka.personal.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.personal.values.ManipuladorId;
import org.sofka.personal.values.PersonalId;
import org.sofka.personal.values.Seccion;

public class AgregarManipuladorDeManipulador extends Command {
    private final PersonalId personalId;
    private final ManipuladorId manipuladorId;
    private final Seccion seccion;

    public AgregarManipuladorDeManipulador(PersonalId personalId,ManipuladorId manipuladorId, Seccion seccion) {
        this.personalId = personalId;
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
