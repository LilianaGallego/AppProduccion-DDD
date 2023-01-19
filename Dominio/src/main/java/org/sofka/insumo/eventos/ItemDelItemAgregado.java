package org.sofka.insumo.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.insumo.values.ItemId;

public class ItemDelItemAgregado extends DomainEvent {

    private final ItemId itemId;
    private final String nombre;
    private final String cantidad;

    public ItemDelItemAgregado(ItemId itemId, String nombre, String cantidad){
        super("org.sofka.insumo.eventos.ItemDelItemAgregado");

        this.itemId = itemId;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public ItemId getItemId() {
        return itemId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCantidad() {
        return cantidad;
    }
}
