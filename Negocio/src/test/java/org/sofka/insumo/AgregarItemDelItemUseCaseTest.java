package org.sofka.insumo;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.insumo.comandos.AgregarItemDelItem;
import org.sofka.insumo.eventos.InsumoCreado;
import org.sofka.insumo.eventos.ItemDelItemAgregado;
import org.sofka.insumo.values.Cantidad;
import org.sofka.insumo.values.Clasificacion;
import org.sofka.insumo.values.InsumoId;
import org.sofka.insumo.values.Nombre;
import org.sofka.personal.AgregarManipuladorDeManipuladorUseCase;
import org.sofka.personal.comandos.AgregarManipuladorDeManipulador;
import org.sofka.personal.eventos.ManipuladorAgregado;
import org.sofka.personal.eventos.PersonalCreado;
import org.sofka.personal.values.Bpm;
import org.sofka.personal.values.PersonalId;
import org.sofka.personal.values.Seccion;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarItemDelItemUseCaseTest {

    @InjectMocks
    private AgregarItemDelItemUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarItemHappyPass(){
        //arrange
        InsumoId insumoId = InsumoId.of("ddddd");
        Nombre nombre = new Nombre("papa");
        Cantidad cantidad = new Cantidad("10.0");
        var command = new AgregarItemDelItem( insumoId,nombre, cantidad);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getInsumoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ItemDelItemAgregado) events.get(0);
        assertEquals("papa", event.getNombre().value());
        assertEquals("10.0", event.getCantidad().value());

        Mockito.verify(repository).getEventsBy("ddddd");

    }

    private List<DomainEvent> history() {
        InsumoId insumoId = InsumoId.of("ddddd");
        Clasificacion clasificacion = new Clasificacion("DDD");
        var event = new InsumoCreado(clasificacion);
        event.setAggregateRootId(insumoId.value());
        return List.of(event);
    }
}