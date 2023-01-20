package org.sofka.personal.values;

import co.com.sofka.domain.generic.ValueObject;
import org.sofka.insumo.values.Clasificacion;

import java.util.Objects;

public class Bpm implements ValueObject<String> {

    private final String value;

    public Bpm(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bpm that = (Bpm) o;
        return Objects.equals(value, that.value);
    }

    public static Bpm of(String bpm){
        return new Bpm(bpm);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
