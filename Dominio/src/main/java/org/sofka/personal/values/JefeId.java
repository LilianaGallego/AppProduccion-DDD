package org.sofka.personal.values;

import co.com.sofka.domain.generic.Identity;

public class JefeId extends Identity {
    public JefeId(){

    }
    private JefeId(String id){
        super(id);
    }
    public static JefeId of(String id){
        return new JefeId(id);

    }
}
