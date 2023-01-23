package org.sofka.personal;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.personal.comandos.AgregarManipuladorDeManipulador;
import org.sofka.personal.eventos.ManipuladorAgregado;
import org.sofka.personal.eventos.PersonalCreado;
import org.sofka.personal.values.Bpm;
import org.sofka.personal.values.PersonalId;
import org.sofka.personal.values.Seccion;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test del comportamiento agregar manipulador
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class AgregarManipuladorDeManipuladorUseCaseTest {
    /**
     * Variable de instancia del caso de uso Agregar manipulador
     */
    @InjectMocks
    private AgregarManipuladorDeManipuladorUseCase useCase;
    /**
     * Variable de instancia del DomainEventRepository
     */
    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarManipuladorHappyPass(){
        //arrange
        PersonalId personalId = PersonalId.of("ddddd");
        Seccion seccion = new Seccion("nnn");
        var command = new AgregarManipuladorDeManipulador( personalId,seccion);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPersonalId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ManipuladorAgregado) events.get(0);
        assertEquals("nnn", event.getSeccion().value());
        Mockito.verify(repository).getEventsBy("ddddd");

    }

    private List<DomainEvent> history() {
        PersonalId personalId = PersonalId.of("ddddd");
        Bpm bpm = new Bpm("DDD");
        var event = new PersonalCreado(bpm);
        event.setAggregateRootId(personalId.value());
        return List.of(event);
    }


}