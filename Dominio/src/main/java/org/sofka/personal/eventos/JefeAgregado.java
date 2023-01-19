package org.sofka.personal.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.personal.values.Experiencia;
import org.sofka.personal.values.JefeId;

public class JefeAgregado extends DomainEvent {
    private final JefeId jefeId;
    private final Experiencia experiencia;


    public JefeAgregado(JefeId jefeId, Experiencia experiencia) {
        super("org.sofka.personal.eventos.jefeagregado");
        this.jefeId = jefeId;
        this.experiencia = experiencia;
    }
}
