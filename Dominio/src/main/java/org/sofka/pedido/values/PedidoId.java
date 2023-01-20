package org.sofka.pedido.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Objeto de valor PedidoId de la entidad Pedido
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class PedidoId extends Identity {
    /**
     * Contructo vacío para PedidoId
     */
    public PedidoId(){

    }
    /**
     *Contructor para el objeto de valor PedidoId
     * @param id id del pedido
     */
    private PedidoId(String id){
        super(id);
    }
    /**
     * Método estático para crear un objeto de valor de tipo PedidoId
     * @param id id del pedido
     * @return objeto de valor de tipo PeidoId
     */
    public static PedidoId of(String id){
        return new PedidoId(id);

    }
}
