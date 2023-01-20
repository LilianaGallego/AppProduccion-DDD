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
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.personal.comandos.ActualizarObservacion;
import org.sofka.personal.eventos.ObservacionActualizada;
import org.sofka.personal.eventos.PersonalCreado;
import org.sofka.personal.values.*;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarObservacionUseCaseTest {

    @InjectMocks
    private ActualizarObservacionUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void actualizarObservacionHappyPass() {
        var command = new ActualizarObservacion( PersonalId.of("ddd"),Bpm.of("observación actualizada")

        );

        when(repository.getEventsBy("ddd")).thenReturn(history());

        useCase.addRepository(repository);

        var domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPersonalId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ObservacionActualizada) domainEvents.get(0);
        Assertions.assertEquals("observación actualizada", event.getBpm().value());

    }
    private List<DomainEvent> history() {
        var event = new PersonalCreado(
       Bpm.of("observación actualizada"));
        event.setAggregateRootId("ddd");
        return List.of(event);
    }
}