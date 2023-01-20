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
import org.sofka.pedido.comandos.AgregarEstadoDeEstado;
import org.sofka.pedido.entidades.Cliente;
import org.sofka.pedido.entidades.Estado;
import org.sofka.pedido.eventos.EstadoDeEstadoAgregado;
import org.sofka.pedido.eventos.PedidoCreado;
import org.sofka.pedido.values.*;
import org.sofka.personal.eventos.PersonalCreado;
import org.sofka.personal.values.Bpm;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarEstadoDeEstadoUseCaseTest {
    @InjectMocks
    private AgregarEstadoDeEstadoUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    public void agregarEstado(){
        PedidoId pedidoId = PedidoId.of("idPedido");
        EstadoId estadoId = EstadoId.of("idEstado");
        Completado completado = new Completado(true);

        var command = new AgregarEstadoDeEstado(pedidoId, estadoId, completado);

        when(repository.getEventsBy("idPedido")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPedidoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (EstadoDeEstadoAgregado)events.get(0);
        Assertions.assertEquals("idEstado", event.getEstadoId().value());
        Assertions.assertEquals(true, event.getCompletado().value());

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