package org.sofka.personal.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.personal.values.Experiencia;
import org.sofka.personal.values.JefeId;

public class AgregarJefeDeJefe extends Command {
    private final JefeId jefeId;
    private final Experiencia experiencia;

    public AgregarJefeDeJefe(JefeId jefeId, Experiencia experiencia) {
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
