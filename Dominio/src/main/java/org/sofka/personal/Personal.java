package org.sofka.personal;

import co.com.sofka.domain.generic.AggregateEvent;
import org.sofka.personal.entidades.Jefe;
import org.sofka.personal.eventos.JefeAgregado;
import org.sofka.personal.eventos.ManipuladorAgregado;
import org.sofka.personal.values.*;
import org.sofka.personal.entidades.Manipulador;
import org.sofka.personal.eventos.PersonalCreado;

import java.util.Objects;
import java.util.Set;

public class Personal extends AggregateEvent<PersonalId> {
    protected BpmPersonal bpmPersonal;
    protected Jefe jefe;
    protected Set<Manipulador> manipuladores;

    public Personal(PersonalId personalId, BpmPersonal bpmPersonal) {
        super(personalId);
        appendChange(new PersonalCreado(bpmPersonal)).apply();
    }

    public BpmPersonal bpmPersonal(){
        return bpmPersonal;
    }


    public void agregarJefe(JefeId jefeId, Experiencia experiencia){
        Objects.requireNonNull(jefeId);
        Objects.requireNonNull(experiencia);
        appendChange(new JefeAgregado(jefeId,experiencia)).apply();
    }

    public void agregarManipulador(ManipuladorId manipuladorId, Seccion seccion){
        Objects.requireNonNull(manipuladorId);
        Objects.requireNonNull(seccion);
        appendChange(new ManipuladorAgregado(manipuladorId,seccion)).apply();
    }

}
