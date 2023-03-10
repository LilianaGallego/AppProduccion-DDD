package org.sofka.personal;

import co.com.sofka.domain.generic.EventChange;
import org.sofka.personal.entidades.Jefe;
import org.sofka.personal.entidades.Manipulador;
import org.sofka.personal.eventos.JefeAgregado;
import org.sofka.personal.eventos.ManipuladorAgregado;
import org.sofka.personal.eventos.ObservacionActualizada;
import org.sofka.personal.eventos.PersonalCreado;

import java.util.HashSet;

public class PersonalChange extends EventChange {
    public PersonalChange(Personal personal) {
        apply((PersonalCreado event) -> {
            personal.bpm = event.getBpmPersonal();
            personal.manipuladores = new HashSet<>();
        });

        apply((ObservacionActualizada event)->{
            personal.bpm = event.getBpm();
        });

        apply((JefeAgregado event) -> {
            personal.jefe = new Jefe(event.getJefeId(), event.getExperiencia());
        });

        apply((ManipuladorAgregado event) -> {
            personal.manipuladores.add(new Manipulador(event.getManipuladorId(), event.getSeccion()));
        });
    }


}
