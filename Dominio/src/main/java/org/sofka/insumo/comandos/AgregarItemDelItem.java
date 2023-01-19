package org.sofka.insumo.comandos;

import co.com.sofka.domain.generic.Command;
import org.sofka.insumo.values.InsumoId;
import org.sofka.insumo.values.ItemId;

public class AgregarItemDelItem extends Command {
    private final InsumoId insumoId;
    private final ItemId itemId;
    private final String nombre;
    private final String cantidad;

    public AgregarItemDelItem(InsumoId insumoId, ItemId itemId, String nombre, String cantidad){

        this.insumoId = insumoId;
        this.itemId = itemId;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public InsumoId getInsumoId() {
        return insumoId;
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
