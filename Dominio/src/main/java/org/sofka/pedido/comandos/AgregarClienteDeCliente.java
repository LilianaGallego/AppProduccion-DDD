package org.sofka.pedido.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.pedido.values.ClienteId;
import org.sofka.pedido.values.Contacto;
import org.sofka.pedido.values.Dieta;
import org.sofka.pedido.values.PedidoId;

/**
 * Comando para agregar un cliente
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class AgregarClienteDeCliente extends Command {
    /**
     * Identificador del pedido
     */
    private final PedidoId pedidoId;
    /**
     * Identificador del cliente
     */
    private final ClienteId clienteId;
    /**
     * Objeto de valor Contacto
     */
    private final Contacto contacto;
    /**
     * Objeto de valor Dieta
     */
    private final Dieta dieta;

    /**
     * Contructor poara la clase AgregarClienteDeCliente
     * @param pedidoId identificador del pedido
     * @param clienteId identificador del cliente
     * @param contacto objeto de valor Contacto
     * @param dieta objeto de valor Dieta
     */
    public AgregarClienteDeCliente(PedidoId pedidoId, ClienteId clienteId, Contacto contacto, Dieta dieta){
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.contacto = contacto;
        this.dieta = dieta;
    }

    /**
     * Método get para obtener el id del pedido
     * @return id del pedido
     */

    public PedidoId getPedidoId() {
        return pedidoId;
    }
    /**
     * Método get para obtener el id del pedido
     * @return id del pedido
     */

    public ClienteId getClienteId() {
        return clienteId;
    }
    /**
     * Método get para obtener el id del cliente
     * @return id del cliente
     */

    public Contacto getContacto() {
        return contacto;
    }
    /**
     * Método get para obtener objero de valor Dieta
     * @return objeto de valor Dieta
     */
    public Dieta getDieta() {
        return dieta;
    }
}
