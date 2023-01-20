package org.sofka.pedido;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sofka.pedido.comandos.CrearPedido;
import org.sofka.pedido.entidades.Cliente;
import org.sofka.pedido.entidades.Estado;
import org.sofka.pedido.eventos.PedidoCreado;
import org.sofka.pedido.values.*;

import static org.junit.jupiter.api.Assertions.*;

class CrearPedidoUseCaseTest {
    private CrearPedidoUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearPedidoUseCase();
    }
    @Test
    public void crearPedido(){
        //arrange
        PedidoId pedidoId = PedidoId.of("idPedido");
        Cantidad cantidad = new Cantidad("2kg");
        Completado completado= new Completado(true);
        EstadoId estadoId = EstadoId.of("idEstado");
        Estado estado = new Estado(estadoId,pedidoId,completado);
        ClienteId clienteId = ClienteId.of("idCliente");
        Contacto contacto = new Contacto("Rs","321","calle","Med");
        Dieta dieta = new Dieta("arroz");
        Cliente cliente = new Cliente(clienteId,pedidoId,contacto,dieta);
        var command = new CrearPedido(pedidoId,cantidad, estado,cliente);
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var pedidoCreado = (PedidoCreado)events.get(0);
        Assertions.assertEquals("idPedido", pedidoCreado.aggregateRootId());
        Assertions.assertEquals("2kg", pedidoCreado.getCantidad().value());
        Assertions.assertEquals(true,pedidoCreado.getEstado().getCompletado().value());
        Assertions.assertEquals("idPedido", pedidoCreado.getEstado().getPedidoId().value());
        Assertions.assertEquals("idEstado",pedidoCreado.getEstado().getEstadoId().value());
        Assertions.assertEquals("idCliente", pedidoCreado.getCliente().getClienteId().value());
        Assertions.assertEquals("idPedido", pedidoCreado.getCliente().getPedidoId().value());
        Assertions.assertEquals("Rs", pedidoCreado.getCliente().getContacto().getRazonSocial());
        Assertions.assertEquals("321", pedidoCreado.getCliente().getContacto().getTelefono());
        Assertions.assertEquals("calle", pedidoCreado.getCliente().getContacto().getDirección());
        Assertions.assertEquals("Med", pedidoCreado.getCliente().getContacto().getCiudad());
        Assertions.assertEquals("arroz", pedidoCreado.getCliente().getDieta().value());
    }

}