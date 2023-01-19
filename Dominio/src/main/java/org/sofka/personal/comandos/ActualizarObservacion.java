package org.sofka.personal.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.personal.values.Bpm;
import org.sofka.personal.values.PersonalId;

public class ActualizarObservacion extends Command {
    private final Bpm bpm;
    private final PersonalId personalId;


    public ActualizarObservacion(Bpm bpm, PersonalId personalId) {
        this.bpm = bpm;
        this.personalId = personalId;
    }

    public Bpm getBpm() {
        return bpm;
    }

    public PersonalId getPersonalId() {
        return personalId;
    }
}
