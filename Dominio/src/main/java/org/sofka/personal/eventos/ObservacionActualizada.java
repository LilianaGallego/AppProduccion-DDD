package org.sofka.personal.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.personal.values.Bpm;
import org.sofka.personal.values.PersonalId;

public class ObservacionActualizada extends DomainEvent {
    private final Bpm bpm;

    public ObservacionActualizada(Bpm bpm) {
        super("org.sofka.personal.eventos.ObservacionActualizada");
        this.bpm = bpm;
    }

    public Bpm getBpm() {
        return bpm;
    }


}
