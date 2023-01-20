package org.sofka.insumo;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sofka.insumo.comandos.CrearInsumo;
import org.sofka.insumo.eventos.InsumoCreado;
import org.sofka.insumo.values.Clasificacion;
import org.sofka.insumo.values.InsumoId;


class CrearInsumoUseCaseTest {
    private CrearInsumoUseCase useCase;
    @BeforeEach
    public void setUp() {
        useCase = new CrearInsumoUseCase();
    }

    @Test
    public void crearInsumoHappyPass() {
        //Arrange
        var insumoId = InsumoId.of("xxxxx");
        var clasificacion = new Clasificacion("qqqq");


        var command = new CrearInsumo(insumoId, clasificacion);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var insumoCreado = (InsumoCreado)events.get(0);
        Assertions.assertEquals("xxxxx", insumoCreado.aggregateRootId());
        Assertions.assertEquals("qqqq", insumoCreado.getClasificacion().value());

    }



}