package org.sofka.pedido.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.pedido.entidades.Cliente;
import org.sofka.pedido.entidades.Estado;
import org.sofka.pedido.values.Cantidad;
import org.sofka.pedido.values.PedidoId;

/**
 * Comando para agregar un pedido
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class CrearPedido extends Command {
    /**
     * Identifiador del pedido
     */
    private final PedidoId pedidoId;
    /**
     * Objeto de valor de tipo cantidad
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
     * Contructor para la clase CrearPedido
     * @param pedidoId id del pedido
     * @param cantidad objeto de valor de tipo Cantidad
     * @param estado entidad de tipo Estado
     * @param cliente entidad de tipo Cliente
     */
    public CrearPedido(PedidoId pedidoId, Cantidad cantidad, Estado estado, Cliente cliente) {
        this.pedidoId = pedidoId;
        this.cantidad = cantidad;
        this.estado = estado;
        this.cliente = cliente;
    }

    /**
     * Método get para obtener el id del cliente
     * @return id del cliente
     */
    public PedidoId getPedidoId() {
        return pedidoId;
    }
    /**
     * Método get para obtener el objeto de valor de tipo Cantidad
     * @return objeto de valor de tipo cantidad
     */
    public Cantidad getCantidad() {
        return cantidad;
    }
    /**
     * Método get para obtener la entida de tipo Estado
     * @return entidad de tipo Estado
     */
    public Estado getEstado() {
        return estado;
    }
    /**
     * Método get para obtener la entida de tipo Cliente
     * @return entidad de tipo Cliente
     */
    public Cliente getCliente() {
        return cliente;
    }
}
