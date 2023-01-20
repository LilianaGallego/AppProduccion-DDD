package org.sofka.personal;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sofka.personal.comandos.CrearPersonal;
import org.sofka.personal.eventos.PersonalCreado;
import org.sofka.personal.values.Bpm;
import org.sofka.personal.values.PersonalId;


class CrearPersonalUseCaseTest {
    private CrearPersonalUseCase useCase;
    @BeforeEach
    public void setUp() {
        useCase = new CrearPersonalUseCase();
    }

    @Test
    public void crearPersonalHappyPass() {
        //Arrange
        var personalId = PersonalId.of("xxxxx");
        var bpm = new Bpm("qqqq");


        var command = new CrearPersonal(personalId, bpm);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var personalCreado = (PersonalCreado)events.get(0);
        Assertions.assertEquals("xxxxx", personalCreado.aggregateRootId());
        Assertions.assertEquals("qqqq", personalCreado.getBpmPersonal().value());

    }

}