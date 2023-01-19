package org.sofka.personal.values;

import co.com.sofka.domain.generic.Identity;

public class PersonalId extends Identity {
    public PersonalId(){

    }
    private PersonalId(String id){
        super(id);
    }
    public static PersonalId of(String id){
        return new PersonalId(id);

    }
}
