package org.sofka.pedido.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Objeto de valor clienteId de la entidad Cliente
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class ClienteId extends Identity {
    /**
     * Contructo vacío para ClienteId
     */
    public ClienteId(){

    }

    /**
     *Contructor para el objeto de valor ClienteId
     * @param id id del cliente
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    private ClienteId(String id){
        super(id);
    }

    /**
     * Método estático para crear un objeto de valor de tipo ClienteId
     * @param id id del cliente
     * @return objeto de valor de tipo ClienteId
     */
    public static ClienteId of(String id){
        return new ClienteId(id);

    }
}
