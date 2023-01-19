package org.sofka.personal.values;

import co.com.sofka.domain.generic.Identity;

public class ManipuladorId extends Identity {
    public ManipuladorId(){

    }
    private ManipuladorId(String id){
        super(id);
    }
    public static ManipuladorId of(String id){
        return new ManipuladorId(id);

    }
}
