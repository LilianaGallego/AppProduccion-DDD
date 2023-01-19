package org.sofka.personal.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.personal.values.Experiencia;
import org.sofka.personal.values.JefeId;
import org.sofka.personal.values.PersonalId;

public class AgregarJefeDeJefe extends Command {
    private final PersonalId personalId;
    private final JefeId jefeId;
    private final Experiencia experiencia;

    public AgregarJefeDeJefe(PersonalId personalId,JefeId jefeId, Experiencia experiencia) {
        this.personalId = personalId;
        this.jefeId = jefeId;
        this.experiencia = experiencia;
    }


    public JefeId getJefeId() {
        return jefeId;
    }

    public Experiencia getExperiencia() {
        return experiencia;
    }
}
