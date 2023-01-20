package org.sofka.pedido.entidades;


import co.com.sofka.domain.generic.Entity;
import org.sofka.pedido.values.ClienteId;
import org.sofka.pedido.values.Contacto;
import org.sofka.pedido.values.Dieta;
import org.sofka.pedido.values.PedidoId;


import java.util.Objects;

/**
 * Entidad Cliente del insumo
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class Cliente extends Entity<ClienteId> {
    /**
     * Objeto de valor de tipo Dieta
     */
    private Dieta dieta;
    /**
     * Identificador del cliente
     */
    private final ClienteId clienteId;
    /**
     * Identificador del pedido
     */
    private final PedidoId pedidoId;
    /**
     * Objeto de valor de tipo Contacto
     */
    private Contacto contacto;

    /**
     * Contructor para la entidad Cliente
     * @param clienteId id del cliente
     * @param pedidoId id del pedido
     * @param contacto objeto de valor de tipo Contacto
     * @param dieta objeto de valor de tipo Dieta
     */
    public Cliente(ClienteId clienteId, PedidoId pedidoId, Contacto contacto, Dieta dieta){
        super(clienteId);
        this.clienteId = Objects.requireNonNull(clienteId);
        this.pedidoId = Objects.requireNonNull(pedidoId);
        this.contacto = Objects.requireNonNull(contacto);
        this.dieta = Objects.requireNonNull(dieta);

    }

    /**
     * Método get para obtener el id del pedido
     * @return id del pedido
     */
    public PedidoId getPedidoId() {
        return pedidoId;
    }

    /**
     * Método get para obtener el objeto valor de tipo Dieta
     * @return objeto de valor de tipo Dieta
     */
    public Dieta getDieta() {
        return dieta;
    }
    /**
     * Método get para obtener el objeto valor de tipo Contacto
     * @return objeto de valor de tipo Contacto
     */
    public Contacto getContacto() {
        return contacto;
    }
    /**
     * Método get para obtener el id del cliente
     * @return id del cliente
     */
    public ClienteId getClienteId() {
        return clienteId;
    }
}
