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
import org.sofka.insumo.entidades.Estado;
import org.sofka.insumo.entidades.Item;
import org.sofka.insumo.eventos.InsumoCreado;
import org.sofka.insumo.eventos.ItemDelItemAgregado;
import org.sofka.insumo.values.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Test del comportamiento Agregar item
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */

@ExtendWith(MockitoExtension.class)
class AgregarItemDelItemUseCaseTest {

    /**
     * Variable de instancia del caso de uso Agregar item
     */
    @InjectMocks
    private AgregarItemDelItemUseCase useCase;

    /**
     * Variable de instancia del DomainEventRepository
     */
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
        Nombre nombre = new Nombre("carne");
        Cantidad cantidad = new Cantidad("1 bolsa");
        Item item = new Item(ItemId.of("idItem"),insumoId,nombre,cantidad);
        Set<Item> items = new HashSet<>();
        items.add(item);
        Clasificacion clasificacion = new Clasificacion("DDD");
        Disponible disponible = new Disponible(true);
        Estado estado = new Estado(EstadoId.of("idEstado"), disponible);

        var event = new InsumoCreado(insumoId,items,estado,clasificacion);
        event.setAggregateRootId(insumoId.value());
        return List.of(event);
    }
}