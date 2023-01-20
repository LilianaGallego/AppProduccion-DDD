package org.sofka.pedido.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.pedido.entidades.Cliente;
import org.sofka.pedido.values.ClienteId;
import org.sofka.pedido.values.Contacto;
import org.sofka.pedido.values.PedidoId;

/**
 * Comando para actualizar el contacto del cliente
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class ActualizarContactoDeCliente extends Command {
    /**
     * Identificador de pedido
     */
    private final PedidoId pedidoId;
    /**
     * Identificador de cliente
     */
    private final ClienteId clienteId;
    /**
     * Objeto de valor contacto
     */
    private final Contacto contacto;
    /**
     * Entidad cliente
     */
    private final Cliente cliente;

    /**
     * Constructor para la clase ActualizarContactoDeCliente
     * @param pedidoId id del pedido
     * @param clienteId id del cliente
     * @param contacto objeto de valor de tipo Contacto
     * @param cliente entidad cliente
     */
    public ActualizarContactoDeCliente(PedidoId pedidoId, ClienteId clienteId, Contacto contacto, Cliente cliente){
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.contacto = contacto;
        this.cliente = cliente;
    }

    /**
     * Método para obtener el id del pedido
     * @return id del pedido
     */
    public PedidoId getPedidoId() {
        return pedidoId;
    }
    /**
     * Método para obtener el id del cliente
     * @return id del cliente
     */
    public ClienteId getClienteId() {
        return clienteId;
    }
    /**
     * Método para obtener el objeto de valor Contacto
     * @return Contacto
     */
    public Contacto getContacto() {
        return contacto;
    }
    /**
     * Método para obtener la entidad Cliente
     * @return cliente
     */
    public Cliente getCliente() {
        return cliente;
    }
}
