package org.sofka.insumo;

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
import org.sofka.insumo.comandos.AgregarEstadoDeEstado;
import org.sofka.insumo.entidades.Estado;
import org.sofka.insumo.entidades.Item;
import org.sofka.insumo.eventos.EstadoDeEstadoAgregado;
import org.sofka.insumo.eventos.InsumoCreado;
import org.sofka.insumo.values.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarEstadoDeEstadoUseCaseTest {

    @InjectMocks
    private AgregarEstadoDeEstadoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarEstadoHappyPass(){
        //arrange
        InsumoId insumoId = InsumoId.of("ddddd");
        Disponible disponible = new Disponible(true);
        var command = new AgregarEstadoDeEstado( insumoId,disponible);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getInsumoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (EstadoDeEstadoAgregado)events.get(0);
        Assertions.assertEquals(true, event.getDisponible().value());

    }

    private List<DomainEvent> history() {
        InsumoId insumoId = InsumoId.of("idInsumo");
        Nombre nombre = new Nombre("carne");
        Cantidad cantidad = new Cantidad("1 bolsa");
        Item item = new Item(ItemId.of("idItem"),insumoId,nombre,cantidad);
        Set<Item> items = new HashSet<>();
        items.add(item);
        Disponible disponible = new Disponible(false);
        Estado estado = new Estado(EstadoId.of("idEstado"), disponible);
        Clasificacion clasificacion = new Clasificacion("granos");

        var event = new InsumoCreado(insumoId,items,estado,clasificacion);
        event.setAggregateRootId("idInsumo");
        return List.of(event);
    }


}