package org.sofka.insumo;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sofka.insumo.comandos.CrearInsumo;
import org.sofka.insumo.entidades.Estado;
import org.sofka.insumo.entidades.Item;
import org.sofka.insumo.eventos.InsumoCreado;
import org.sofka.insumo.values.*;

import java.util.HashSet;
import java.util.Set;


class CrearInsumoUseCaseTest {
    private CrearInsumoUseCase useCase;
    @BeforeEach
    public void setUp() {
        useCase = new CrearInsumoUseCase();
    }

    @Test
    public void crearInsumoHappyPass() {
        //Arrange
        var insumoId = InsumoId.of("idInsumo");
        Nombre nombre = new Nombre("carne");
        Cantidad cantidad = new Cantidad("1 bolsa");
        Item item = new Item(ItemId.of("idItem"),insumoId,nombre,cantidad);
        Set<Item> items = new HashSet<>();
        items.add(item);
        Disponible disponible = new Disponible(true);
        Estado estado = new Estado(EstadoId.of("idEstado"), disponible);
        var clasificacion = new Clasificacion("qqqq");


        var command = new CrearInsumo(insumoId,items,estado,clasificacion);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var insumoCreado = (InsumoCreado)events.get(0);
        Assertions.assertEquals("idInsumo", insumoCreado.aggregateRootId());
        Assertions.assertEquals("qqqq", insumoCreado.getClasificacion().value());

    }



}