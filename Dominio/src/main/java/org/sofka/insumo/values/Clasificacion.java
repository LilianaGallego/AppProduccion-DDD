package org.sofka.insumo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Clasificacion implements ValueObject<String> {
    private String clase;

    public Clasificacion(String clase) {
        this.clase = Objects.requireNonNull(clase);
    }

    @Override
    public String value() {
        return clase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clasificacion that = (Clasificacion) o;
        return Objects.equals(clase, that.clase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clase);
    }
}
