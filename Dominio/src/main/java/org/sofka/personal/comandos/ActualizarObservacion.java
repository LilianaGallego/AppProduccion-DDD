package org.sofka.personal.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.personal.values.Bpm;
import org.sofka.personal.values.PersonalId;

public class ActualizarObservacion extends Command {
    private final Bpm bpm;
    private final PersonalId personalId;


    public ActualizarObservacion( PersonalId personalId,Bpm bpm) {

        this.personalId = personalId;
        this.bpm = bpm;
    }

    public Bpm getBpm() {
        return bpm;
    }

    public PersonalId getPersonalId() {
        return personalId;
    }
}
