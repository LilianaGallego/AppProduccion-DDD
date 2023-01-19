package org.sofka.personal.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.personal.values.Bpm;
import org.sofka.personal.values.PersonalId;

public class ObservacionActualizada extends DomainEvent {
    private final Bpm bpm;
    private final PersonalId personalId;

    public ObservacionActualizada(Bpm bpm, PersonalId personalId) {
        super("org.sofka.personal.eventos.ObservacionActualizada");
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
