package org.sofka.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Dieta implements ValueObject<String> {
    private final String dieta;

    public Dieta(String dieta) {
        this.dieta = dieta;
    }

    @Override
    public String value() {
        return dieta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dieta dieta1 = (Dieta) o;
        return Objects.equals(dieta, dieta1.dieta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dieta);
    }
}
