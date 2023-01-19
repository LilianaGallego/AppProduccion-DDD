package org.sofka.insumo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cantidad implements ValueObject<Double> {
    private final Double peso;

    public Cantidad(Double peso) {

        this.peso = peso;
    }

    @Override
    public Double value() {
        return peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cantidad cantidad = (Cantidad) o;
        return Objects.equals(peso, cantidad.peso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peso);
    }
}
