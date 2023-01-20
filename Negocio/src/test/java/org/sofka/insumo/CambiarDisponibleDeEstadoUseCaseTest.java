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
import org.sofka.insumo.eventos.DispobileDeEstadoCambiado;
import org.sofka.insumo.eventos.InsumoCreado;
import org.sofka.insumo.values.Clasificacion;
import org.sofka.insumo.values.Disponible;
import org.sofka.insumo.values.EstadoId;
import org.sofka.insumo.values.InsumoId;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CambiarDisponibleDeEstadoUseCaseTest {
//    @InjectMocks
//    private CambiarDisponibleDeEstadoUseCase useCase;
//    @Mock
//    DomainEventRepository repository;
//    @Test
//    public void actualizarEstado(){
//        InsumoId insumoId = InsumoId.of("idInsumo");
//        EstadoId estadoId = EstadoId.of("idEstado");
//        Disponible disponible = new Disponible(true);
//
//        var command = new CambiarDispobileDeEstado(insumoId, estadoId,disponible);
//
//        when(repository.getEventsBy("idInsumo")).thenReturn(insumos());
//        useCase.addRepository(repository);
//
//        var events = UseCaseHandler.getInstance()
//                .setIdentifyExecutor(command.getInsumoId().value())
//                .syncExecutor(useCase, new RequestCommand<>(command))
//                .orElseThrow()
//                .getDomainEvents();
//
//        var event = (DispobileDeEstadoCambiado)events.get(0);
//
//        Assertions.assertEquals(true, event.getDisponible().value());



   // }

//    private List<DomainEvent> insumos() {
//        Clasificacion cantidad = new Clasificacion("granos");
//
//        var event = new InsumoCreado(cantidad);
//        event.setAggregateRootId("idInsumo");
//        return List.of(event);
//    }


}