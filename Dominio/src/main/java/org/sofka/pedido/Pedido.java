package org.sofka.pedido;


import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.pedido.eventos.ClienteDeClienteAgregado;
import org.sofka.pedido.eventos.ContactoDeClienteActualizado;
import org.sofka.pedido.eventos.EstadoDeEstadoAgregado;
import org.sofka.pedido.eventos.PedidoCreado;
import org.sofka.pedido.values.PedidoId;
import org.sofka.pedido.values.Cantidad;
import org.sofka.pedido.values.EstadoId;
import org.sofka.pedido.values.ClienteId;
import org.sofka.pedido.values.Dieta;
import org.sofka.pedido.values.Completado;
import org.sofka.pedido.values.Contacto;
import org.sofka.pedido.entidades.Cliente;
import org.sofka.pedido.entidades.Estado;

import java.util.List;
import java.util.Objects;

/**
 * Agregado root Pedido
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class Pedido extends AggregateEvent<PedidoId> {
    /**
     * Entidad Estado
     */
    protected Estado estado;
    /**
     * Entidad Cliente
     */
    protected Cliente cliente;
    /**
     * Objeto de valor Cantidad
     */
    protected Cantidad cantidad;

    /**
     * Contructor del agregado root Pedido
     * @param pedidoId id del pedido
     * @param cantidad objeto de valor de tipo Cantidad
     * @param estado entidad de tipo Entidad
     * @param cliente entidad de tipo Cliente
     */
    public Pedido(PedidoId pedidoId, Cantidad cantidad, Estado estado, Cliente cliente) {
        super(pedidoId);
        appendChange(new PedidoCreado(cantidad,estado,cliente)).apply();
    }
    /**
     * Constructor privado para afectar los estados
     *
     * @param pedidoId identificador del insumo
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    private Pedido(PedidoId pedidoId) {
        super(pedidoId);
        subscribe(new PedidoChange(this));

    }

    /**
     * Factoría para el agregado root Pedido
     * @param pedidoId id del pedido
     * @param events lista tipo DomainEvents
     * @return entidad tipo Pedido
     */
    public static Pedido from(PedidoId pedidoId, List<DomainEvent> events){
        var pedido = new Pedido(pedidoId);
        events.forEach(pedido::applyEvent);
        return pedido;
    }

    /**
     * Método para agregar un estado en la entidad Estado
     * @param estadoId id del estado
     * @param pedidoId id del pedido
     * @param completado objeto de valor de tipo Completado
     */
    public void agregarEstadoDeEstado(EstadoId estadoId, PedidoId pedidoId, Completado completado){
        Objects.requireNonNull(estadoId);
        Objects.requireNonNull(completado);
        appendChange(new EstadoDeEstadoAgregado(estadoId,pedidoId ,completado)).apply();
    }

    /**
     * Método para agregar un cliente
     * @param clienteId id del cliente
     * @param pedidoId id del pedido
     * @param contacto objeto de valor de tipo Contacto
     * @param dieta objeto de valor de tipo Dieta
     */
    public void agregarClienteDeCliente(ClienteId clienteId,PedidoId pedidoId, Contacto contacto, Dieta dieta){
        Objects.requireNonNull(clienteId);
        Objects.requireNonNull(contacto);
        appendChange(new ClienteDeClienteAgregado(clienteId,pedidoId, contacto,dieta)).apply();
    }

    /**
     * Método para actualizar un contacto de la entidad Cliente
     * @param clienteId id del cliente
     * @param contacto objeto de valor de tipo Contacto
     * @param cliente entidad de tipo Cliente
     */
    public void actualizarContactoDeCliente(ClienteId clienteId, Contacto contacto, Cliente cliente){
        Objects.requireNonNull(clienteId);
        Objects.requireNonNull(contacto);
        appendChange(new ContactoDeClienteActualizado(clienteId, contacto,cliente)).apply();
    }


}
