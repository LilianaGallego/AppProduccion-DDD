package org.sofka.insumo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Disponible implements ValueObject<Boolean> {
    private final Boolean value;

    public Disponible(Boolean value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Boolean value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disponible that = (Disponible) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
