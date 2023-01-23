package org.sofka.pedido;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.pedido.comandos.ActualizarContactoDeCliente;
import org.sofka.pedido.entidades.Cliente;
import org.sofka.pedido.entidades.Estado;
import org.sofka.pedido.eventos.ContactoDeClienteActualizado;
import org.sofka.pedido.eventos.PedidoCreado;
import org.sofka.pedido.values.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Test del comportamiento Actualizar contacto de cliente
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class ActualizarContactoDeClienteUseCaseTest {
    /**
     * Variable de instancia del caso de uso Actualizar contacto de cliente
     */
    @InjectMocks
    private ActualizarContactoDeClienteUseCase useCase;
    /**
     * Variable de instancia del DomainEventRepository
     */
    @Mock
    private DomainEventRepository repository;
    @Test
    public void actualizarContacto(){
        PedidoId pedidoId = PedidoId.of("idPedido");
        ClienteId clienteId = ClienteId.of("idCliente");
        Dieta dieta = new Dieta("arroz");

        Contacto contacto = new Contacto("Rs","321","calle","Med");
        Cliente cliente = new Cliente(clienteId,pedidoId,contacto,dieta);

        var command = new ActualizarContactoDeCliente(pedidoId, clienteId,contacto,cliente);

        when(repository.getEventsBy("idPedido")).thenReturn(pedidos());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPedidoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ContactoDeClienteActualizado)events.get(0);
        Assertions.assertEquals("Rs",event.getContacto().getRazonSocial());
    }

    private List<DomainEvent> pedidos() {
        PedidoId pedidoId = PedidoId.of("idPedido");
        Completado completado= new Completado(true);
        EstadoId estadoId = EstadoId.of("idEstadoHistory");
        Estado estado = new Estado(estadoId,pedidoId,completado);
        ClienteId clienteId = ClienteId.of("idCliente");
        Contacto contacto = new Contacto("Rss","321","calle","Med");
        Dieta dieta = new Dieta("arroz");
        Cantidad cantidad = new Cantidad("2kg");
        Cliente cliente = new Cliente(clienteId,pedidoId,contacto,dieta);
        var event = new PedidoCreado(cantidad,estado,cliente);
        event.setAggregateRootId("idPedido");
        return List.of(event);
    }

}