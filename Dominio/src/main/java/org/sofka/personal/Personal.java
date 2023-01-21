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

/**
 * Agregado root Personal
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class Personal extends AggregateEvent<PersonalId> {
    /**
     * Identificador del personal
     */
    protected PersonalId personalId;
    /**
     * Relación con el insumo
     */
    protected InsumoId insumoId;
    /**
     * Relación con el pedido
     */
    protected PedidoId pedidoId;
    /**
     * Objeto Valor bpm del personal
     */
    protected Bpm bpm;
    /**
     * Relación con la entidad jefe 1 a 1
     */
    protected Jefe jefe;
    /**
     * Relación con la entidad manipulador 1 a muchos
     */
    protected Set<Manipulador> manipuladores;

    /**
     * Método constructor para crear un personal
     *
     * @param personalId identificador del personal
     * @param bpm observación del personal
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Personal(PersonalId personalId, Bpm bpm) {
        super(personalId);
        appendChange(new PersonalCreado(bpm)).apply();
    }

    /**
     * Constructor privado para afectar los estados
     *
     * @param personalId identificador del personal
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    private Personal(PersonalId personalId){
        super(personalId);
        subscribe(new PersonalChange(this));
    }

    /**
     * Método para retornar los eventos del personal
     *
     * @param personalId identificador del personal
     * @param events lista de eventos
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public static Personal from(PersonalId personalId, List<DomainEvent> events){
        var personl = new Personal(personalId);
        events.forEach(personl::applyEvent);
        return personl;
    }

    /**
     * Método  para actualizar una observacion en el OV BPM
     *
     * @param personalId identificador del personal
     * @param bpm observación del personal
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public void actualizarObservacion(PersonalId personalId,Bpm bpm){
        Objects.requireNonNull(personalId);
        Objects.requireNonNull(bpm);
        appendChange(new ObservacionActualizada(personalId,bpm)).apply();
    }


    /**
     * Método  para agregar el jefe
     *
     * @param experiencia experiencia del jefe
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public void agregarJefe( Experiencia experiencia){
        Objects.requireNonNull(experiencia);
        var jefeId = new JefeId();
        appendChange(new JefeAgregado(jefeId,experiencia)).apply();
    }

    /**
     * Método  para agregar el manipulador
     *
     * @param seccion sección del manipulador
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
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
