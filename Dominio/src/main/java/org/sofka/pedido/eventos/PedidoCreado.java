package org.sofka.pedido.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.pedido.entidades.Cliente;
import org.sofka.pedido.entidades.Estado;
import org.sofka.pedido.values.Cantidad;

import java.util.Objects;

/**
 * Evento para el pedido agregado
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class PedidoCreado extends DomainEvent {
    /**
     * Objeto de valor de tipo Cantidad
     */
    private final Cantidad cantidad;
    /**
     * Entidad de tipo Estado
     */
    private final Estado estado;
    /**
     * Entidad de tipo Cliente
     */
    private final Cliente cliente;

    /**
     * Contructor para la clase PedidoCreado
     * @param cantidad objeto de valor de tipo Cantidad
     * @param estado entidad de tipo Estado
     * @param cliente entidad de tipo Cliente
     */
    public PedidoCreado(Cantidad cantidad, Estado estado, Cliente cliente) {
        super("org.sofka.pedido.eventos.PedidoCreado");
        this.cantidad = Objects.requireNonNull(cantidad);
        this.estado = Objects.requireNonNull(estado);
        this.cliente = Objects.requireNonNull(cliente);
    }

    /**
     * Método get para obtener el objeto de valor de tipo Cantidad
     * @return objeto de valor de tipo Cantidad
     */
    public Cantidad getCantidad() {
        return cantidad;
    }

    /**
     * Método get para obtener la entidad de tipo Estado
     * @return entidad de tipo Estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Método get para obtener la entidad de tipo Cliente
     * @return entidad de tipo Cliente
     */
    public Cliente getCliente() {
        return cliente;
    }
}
