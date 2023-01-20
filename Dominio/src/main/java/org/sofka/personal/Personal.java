package org.sofka.personal;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
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
    protected PersonalId personalId;
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

    public void actualizarObservacion(PersonalId personalId,Bpm bpm){
        Objects.requireNonNull(personalId);
        Objects.requireNonNull(bpm);
        appendChange(new ObservacionActualizada(personalId,bpm)).apply();
    }


    public void agregarJefe( Experiencia experiencia){
        Objects.requireNonNull(experiencia);
        var jefeId = new JefeId();
        appendChange(new JefeAgregado(jefeId,experiencia)).apply();
    }

    public void agregarManipulador(Seccion seccion){
        var manipuladorId = new ManipuladorId();
        appendChange(new ManipuladorAgregado(manipuladorId,seccion)).apply();
    }

    public Set<Manipulador> getManipuladores(){
        return manipuladores;
    }

    public Bpm getBpm() {
        return bpm;
    }
}
