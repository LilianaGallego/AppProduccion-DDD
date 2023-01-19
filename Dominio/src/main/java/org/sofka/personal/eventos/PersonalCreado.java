package org.sofka.personal.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.personal.values.BpmPersonal;

public class PersonalCreado extends DomainEvent {
    private final BpmPersonal bpmPersonal;

    public PersonalCreado(BpmPersonal bpmPersonal) {
        super("org.sofka.personal.eventos.personalcreado");
        this.bpmPersonal = bpmPersonal;
    }
}
