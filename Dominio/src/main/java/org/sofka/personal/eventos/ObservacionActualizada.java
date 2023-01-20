package org.sofka.personal.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.personal.values.Bpm;
import org.sofka.personal.values.PersonalId;

public class ObservacionActualizada extends DomainEvent {
    private final PersonalId personalId;

    private final Bpm bpm;

    public ObservacionActualizada(PersonalId personalId, Bpm bpm) {
        super("org.sofka.personal.eventos.ObservacionActualizada");
        this.personalId = personalId;
        this.bpm = bpm;
    }

    public PersonalId getPersonalId() {
        return personalId;
    }

    public Bpm getBpm() {
        return bpm;
    }


}
