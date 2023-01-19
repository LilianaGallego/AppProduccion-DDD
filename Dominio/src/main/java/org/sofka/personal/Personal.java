package org.sofka.personal;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.insumo.Insumo;
import org.sofka.insumo.values.InsumoId;
import org.sofka.pedido.values.PedidoId;
import org.sofka.personal.entidades.Jefe;
import org.sofka.personal.eventos.JefeAgregado;
import org.sofka.personal.eventos.ManipuladorAgregado;
import org.sofka.personal.eventos.ObservacionActualizada;
import org.sofka.personal.values.*;
import org.sofka.personal.entidades.Manipulador;
import org.sofka.personal.eventos.PersonalCreado;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Personal extends AggregateEvent<PersonalId> {
    protected InsumoId insumoId;
    protected PedidoId pedidoId;
    protected Bpm bpm;
    protected Jefe jefe;
    protected Set<Manipulador> manipuladores;

    public Personal(PersonalId personalId, Bpm bpm) {
        super(personalId);
        appendChange(new PersonalCreado(bpm)).apply();
    }

    private Personal(PersonalId personalId){
        super(personalId);
        subscribe(new PersonalChange(this));
    }

    public static Personal from(PersonalId personalId, List<DomainEvent> events){
        var personl = new Personal(personalId);
        events.forEach(personl::applyEvent);
        return personl;
    }

    public void actualizarObservacion(Bpm bpm,PersonalId personalId){
        Objects.requireNonNull(personalId);
        Objects.requireNonNull(bpm);
        appendChange(new ObservacionActualizada(bpm, personalId)).apply();
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
