package org.sofka.insumo.entidades;

import co.com.sofka.domain.generic.Entity;
import org.sofka.insumo.values.ItemId;

public class Item extends Entity<ItemId> {
    private String nombre;
    private String cantidad;

    public Item(ItemId itemId, String nombre, String cantidad) {
        super(itemId);
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
}
