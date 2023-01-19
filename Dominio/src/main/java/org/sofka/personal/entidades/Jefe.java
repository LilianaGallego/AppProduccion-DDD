package org.sofka.personal.entidades;

import co.com.sofka.domain.generic.Entity;
import org.sofka.personal.values.Experiencia;
import org.sofka.personal.values.JefeId;

public class Jefe extends Entity<JefeId> {
    private Experiencia experiencia;

    public Jefe(JefeId entityId, Experiencia experiencia) {
        super(entityId);
        this.experiencia = experiencia;
    }

    ///FALTA verificar
    public void agregarJefe(JefeId jefeId, Experiencia experiencia){

    }

    public Experiencia experiencia(){
        return experiencia;
    }
}
