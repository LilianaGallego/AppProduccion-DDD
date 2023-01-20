package org.sofka.pedido.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.pedido.entidades.Cliente;
import org.sofka.pedido.values.ClienteId;
import org.sofka.pedido.values.Contacto;

import java.util.Objects;

/**
 * Evento para el contacto del cliente actualizado
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class ContactoDeClienteActualizado extends DomainEvent {
    /**
     * Identificador del cliente
     */
    private final ClienteId clienteId;
    /**
     * Objeto de valor de tipo Contacto
     */
    private final Contacto contacto;
    /**
     * Entidad de tipo Cliente
     */
    private final Cliente cliente;

    /**
     * Contructor de la clase ContactoDeClienteActualizado
     * @param clienteId id del cliente
     * @param contacto objeto de valor de tipo Contacto
     * @param cliente Entidad de tipo Cliente
     */
    public ContactoDeClienteActualizado(ClienteId clienteId, Contacto contacto, Cliente cliente){
        super("org.sofka.insumo.eventos.ContactoDeClienteActualizado");
        this.clienteId = Objects.requireNonNull(clienteId);
        this.contacto = Objects.requireNonNull(contacto);
        this.cliente = Objects.requireNonNull(cliente);
    }

    /**
     * Método get para obtener el id del cliente
     * @return id del cliente
     */
    public ClienteId getClienteId() {
        return clienteId;
    }

    /**
     * Método para obtener la entidad de tipo Cliente
     * @return entida de tipo Cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Método para obtener el objeto de valor de tipo Contacto
     * @return objeto de valor de tipo Contacto
     */
    public Contacto getContacto() {
        return contacto;
    }
}
