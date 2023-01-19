package org.sofka.pedido.values;

import co.com.sofka.domain.generic.Identity;
import org.sofka.insumo.values.InsumoId;

public class EstadoId extends Identity {
    public EstadoId(){

    }
    private EstadoId(String id){
        super(id);
    }
    public static EstadoId of(String id){
        return new EstadoId(id);

    }
}
