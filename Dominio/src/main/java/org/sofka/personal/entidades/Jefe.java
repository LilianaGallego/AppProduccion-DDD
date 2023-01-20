package org.sofka.personal.entidades;

import co.com.sofka.domain.generic.Entity;
import org.sofka.personal.values.Experiencia;
import org.sofka.personal.values.JefeId;

public class Jefe extends Entity<JefeId> {

    private Experiencia experiencia;
    private JefeId jefeId;

    public Jefe(JefeId jefeId, Experiencia experiencia) {
        super(jefeId);
        this.experiencia = experiencia;
    }

    public void agregarJefe(JefeId jefeId, Experiencia experiencia){
        this.jefeId = jefeId;
        this.experiencia = experiencia;

    }

    public Experiencia experiencia(){
        return experiencia;
    }
}
