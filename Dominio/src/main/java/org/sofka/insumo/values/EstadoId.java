package org.sofka.insumo.values;


import co.com.sofka.domain.generic.Identity;

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
