package org.sofka.personal.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class BpmPersonal implements ValueObject<String> {

    private final String value;

    public BpmPersonal(String value) {
        this.value = Objects.requireNonNull(value);
    }
    @Override
    public String value() {
        return null;
    }
}
