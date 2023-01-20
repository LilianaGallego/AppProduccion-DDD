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
import org.sofka.personal.comandos.AgregarJefeDeJefe;
import org.sofka.personal.eventos.JefeAgregado;
import org.sofka.personal.eventos.PersonalCreado;
import org.sofka.personal.values.Bpm;
import org.sofka.personal.values.Experiencia;
import org.sofka.personal.values.PersonalId;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarJefeDeJefeUseCaseTest {
    @InjectMocks
    private AgregarJefeDeJefeUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarJefeHappyPass(){
        //arrange
        PersonalId personalId = PersonalId.of("ddddd");
        Experiencia experiencia = new Experiencia("nnn");
        var command = new AgregarJefeDeJefe( personalId,experiencia);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPersonalId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (JefeAgregado)events.get(0);
        Assertions.assertEquals("nnn", event.getExperiencia().value());

    }

    private List<DomainEvent> history() {
        Bpm bpm = new Bpm("DDD");
        var event = new PersonalCreado(
                bpm
        );
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }


}