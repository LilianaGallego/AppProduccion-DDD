package org.sofka.personal.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.personal.values.Bpm;
import org.sofka.personal.values.PersonalId;

public class CrearPersonal extends Command {
    private final PersonalId personalId;
    private final Bpm bpmPersonal;


    public CrearPersonal(PersonalId personalId, Bpm bpmPersonal) {
        this.personalId = personalId;
        this.bpmPersonal = bpmPersonal;
    }

    public PersonalId getPersonalId() {
        return personalId;
    }

    public Bpm getBpmPersonal() {
        return bpmPersonal;
    }
}
