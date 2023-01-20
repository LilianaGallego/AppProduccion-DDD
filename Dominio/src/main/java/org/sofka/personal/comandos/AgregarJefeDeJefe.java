package org.sofka.personal.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.personal.values.Experiencia;
import org.sofka.personal.values.PersonalId;

public class AgregarJefeDeJefe extends Command {
    private final PersonalId personalId;
    private final Experiencia experiencia;

    public AgregarJefeDeJefe(PersonalId personalId, Experiencia experiencia) {
        this.personalId = personalId;
        this.experiencia = experiencia;
    }

    public PersonalId getPersonalId() {
        return personalId;
    }


    public Experiencia getExperiencia() {
        return experiencia;
    }
}
