package org.sofka.insumo.values;

import co.com.sofka.domain.generic.Identity;

public class InsumoId extends Identity {
    public InsumoId(){

    }
    private InsumoId(String id){
        super(id);
    }
    public static InsumoId of(String id){
        return new InsumoId(id);

    }
}
