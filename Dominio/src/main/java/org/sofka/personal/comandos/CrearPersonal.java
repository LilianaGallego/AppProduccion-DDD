package org.sofka.personal.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.personal.values.BpmPersonal;
import org.sofka.personal.values.PersonalId;

public class CrearPersonal extends Command {
    private final PersonalId personalId;
    private final BpmPersonal bpmPersonal;


    public CrearPersonal(PersonalId personalId, BpmPersonal bpmPersonal) {
        this.personalId = personalId;
        this.bpmPersonal = bpmPersonal;
    }

    public PersonalId getPersonalId() {
        return personalId;
    }

    public BpmPersonal getBpmPersonal() {
        return bpmPersonal;
    }
}
