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
import org.sofka.insumo.comandos.CambiarDispobileDeEstado;
import org.sofka.insumo.entidades.Estado;
import org.sofka.insumo.entidades.Item;
import org.sofka.insumo.eventos.DispobileDeEstadoCambiado;
import org.sofka.insumo.eventos.InsumoCreado;
import org.sofka.insumo.values.*;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CambiarDisponibleDeEstadoUseCaseTest {
    @InjectMocks
    private CambiarDisponibleDeEstadoUseCase useCase;
    @Mock
    DomainEventRepository repository;
    @Test
    public void actualizarEstado(){
        InsumoId insumoId = InsumoId.of("idInsumo");
        EstadoId estadoId = EstadoId.of("idEstado");
        Disponible disponible = new Disponible(true);

        var command = new CambiarDispobileDeEstado(insumoId, estadoId,disponible);

        when(repository.getEventsBy("idInsumo")).thenReturn(insumos());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getInsumoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (DispobileDeEstadoCambiado)events.get(0);

        Assertions.assertEquals(true, event.getDisponible().value());



    }

    private List<DomainEvent> insumos() {
        InsumoId insumoId = InsumoId.of("idInsumo");
        Nombre nombre = new Nombre("carne");
        Cantidad cantidad = new Cantidad("1 bolsa");
        Item item = new Item(ItemId.of("idItem"),insumoId,nombre,cantidad);
        Set<Item> items = new HashSet<>();
        items.add(item);
        Disponible disponible = new Disponible(true);
        Estado estado = new Estado(EstadoId.of("idEstado"), disponible);
        Clasificacion clasificacion = new Clasificacion("granos");

        var event = new InsumoCreado(insumoId,items,estado,clasificacion);
        event.setAggregateRootId("idInsumo");
        return List.of(event);
    }


}