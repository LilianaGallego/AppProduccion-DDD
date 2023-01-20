package org.sofka.pedido.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.pedido.values.Completado;
import org.sofka.pedido.values.EstadoId;
import org.sofka.pedido.values.PedidoId;

/**
 * Comando para agregar el estado
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class AgregarEstadoDeEstado extends Command {
    /**
     * Identificador del pedido
     */
    private final PedidoId pedidoId;
    /**
     * Identificador del estado
     */
    private final EstadoId estadoId;
    /**
     * Objeto de valor Completado
     */
    private final Completado completado;

    /**
     * Contructor para la clase AgregarEstadoDeEstado
     * @param pedidoId id del pedido
     * @param estadoId id del estado
     * @param completado objeto de valor de tipo Completado
     */
    public AgregarEstadoDeEstado(PedidoId pedidoId, EstadoId estadoId, Completado completado){
        this.pedidoId = pedidoId;

        this.estadoId = estadoId;
        this.completado = completado;
    }

    /**
     * Método get para obtener el id del pedido
     * @return id del pedido
     */
    public PedidoId getPedidoId() {
        return pedidoId;
    }
    /**
     * Método get para obtener el id del cliente
     * @return id del cliente
     */
    public EstadoId getEstadoId() {
        return estadoId;
    }
    /**
     * Método get para obtener el objeto de valor compltado
     * @return objeto de valor de tipo Completado
     */
    public Completado getCompletado() {
        return completado;
    }
}
