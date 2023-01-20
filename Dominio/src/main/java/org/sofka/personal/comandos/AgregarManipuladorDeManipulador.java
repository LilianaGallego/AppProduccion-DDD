package org.sofka.personal.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.personal.values.PersonalId;
import org.sofka.personal.values.Seccion;

public class AgregarManipuladorDeManipulador extends Command {
    private final PersonalId personalId;
    private final Seccion seccion;

    public AgregarManipuladorDeManipulador(PersonalId personalId, Seccion seccion) {
        this.personalId = personalId;
        this.seccion = seccion;
    }

    public PersonalId getPersonalId() {
        return personalId;
    }

    public Seccion getSeccion() {
        return seccion;
    }
}
