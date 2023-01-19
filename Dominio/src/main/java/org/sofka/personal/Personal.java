package org.sofka.personal;

import co.com.sofka.domain.generic.AggregateEvent;
import org.sofka.personal.values.JefeId;
import org.sofka.personal.entidades.Manipulador;
import org.sofka.personal.eventos.PersonalCreado;
import org.sofka.personal.values.BpmPersonal;
import org.sofka.personal.values.PersonalId;

import java.util.Set;

public class Personal extends AggregateEvent<PersonalId> {
    protected BpmPersonal bpmPersonal;
    protected JefeId jefeId;
    protected Set<Manipulador> manipuladores;
    public Personal(PersonalId personaId, BpmPersonal bpmPersonal) {
        super(personaId);
        appendChange(new PersonalCreado(bpmPersonal)).apply();
    }


}
