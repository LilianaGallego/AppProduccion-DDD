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
import org.sofka.pedido.comandos.AgregarClienteDeCliente;
import org.sofka.pedido.entidades.Cliente;
import org.sofka.pedido.entidades.Estado;
import org.sofka.pedido.eventos.ClienteDeClienteAgregado;
import org.sofka.pedido.eventos.PedidoCreado;
import org.sofka.pedido.values.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarClienteDeClienteUseCaseTest {
    @InjectMocks
    private AgregarClienteDeClienteUseCase useCase;
    @Mock
    DomainEventRepository repository;
    @Test
    public void crearCliente(){
        PedidoId pedidoId = PedidoId.of("idPedido");
        ClienteId clienteId = ClienteId.of("idCliente");
        Contacto contacto = new Contacto("Rs","321","calle","Med");
        Dieta dieta = new Dieta("arroz");


        var command = new AgregarClienteDeCliente(pedidoId,clienteId,contacto,dieta);

        when(repository.getEventsBy("idPedido")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPedidoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ClienteDeClienteAgregado)events.get(0);
        Assertions.assertEquals("idCliente", event.getClienteId().value());
        Assertions.assertEquals(contacto,event.getContacto());
    }

    private List<DomainEvent> history() {
        PedidoId pedidoId = PedidoId.of("idPedidoHistory");
        Completado completado= new Completado(true);
        EstadoId estadoId = EstadoId.of("idEstadoHistory");
        Estado estado = new Estado(estadoId,pedidoId,completado);
        ClienteId clienteId = ClienteId.of("idCliente");
        Contacto contacto = new Contacto("Rs","321","calle","Med");
        Dieta dieta = new Dieta("arroz");
        Cantidad cantidad = new Cantidad("2kg");
        Cliente cliente = new Cliente(clienteId,pedidoId,contacto,dieta);
        var event = new PedidoCreado(cantidad,estado,cliente);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}