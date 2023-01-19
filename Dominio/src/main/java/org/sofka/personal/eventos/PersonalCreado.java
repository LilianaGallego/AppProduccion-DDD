package org.sofka.personal.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.personal.values.Bpm;

public class PersonalCreado extends DomainEvent {
    private final Bpm bpmPersonal;

    public PersonalCreado(Bpm bpmPersonal) {
        super("org.sofka.personal.eventos.PersonalCreado");
        this.bpmPersonal = bpmPersonal;
    }

    public Bpm getBpmPersonal() {
        return bpmPersonal;
    }
}
