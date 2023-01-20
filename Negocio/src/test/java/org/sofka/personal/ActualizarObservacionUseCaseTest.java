package org.sofka.personal;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.personal.comandos.ActualizarObservacion;
import org.sofka.personal.comandos.CrearPersonal;
import org.sofka.personal.eventos.JefeAgregado;
import org.sofka.personal.eventos.ManipuladorAgregado;
import org.sofka.personal.eventos.ObservacionActualizada;
import org.sofka.personal.eventos.PersonalCreado;
import org.sofka.personal.values.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ActualizarObservacionUseCaseTest {

    @InjectMocks
    private ActualizarObservacionUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarObservacionHappyPass() {
        PersonalId personalId = new PersonalId().of("ddd");
        Bpm bpm = new Bpm("observación actualizada");

        var command = new ActualizarObservacion( bpm,personalId);

        Mockito.when(repository.getEventsBy("ddd")).thenReturn(List.of(
                new PersonalCreado(new Bpm("observación actualizada")),
                new JefeAgregado(JefeId.of("dkkd"),new Experiencia("mmm")),
                new ManipuladorAgregado(ManipuladorId.of("ooo"),new Seccion("mmm"))
                        ));

        useCase.addRepository(repository);

        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor("ddd")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ObservacionActualizada) domainEvents.get(0);
        assertEquals("observación actualizada", event.getBpm().value());
        Mockito.verify(repository).getEventsBy("ddd");
    }
}