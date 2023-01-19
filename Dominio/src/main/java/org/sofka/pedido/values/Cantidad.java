package org.sofka.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cantidad implements ValueObject<String> {
    private String cantidad;

    public Cantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String value() {
        return cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cantidad cantidad1 = (Cantidad) o;
        return Objects.equals(cantidad, cantidad1.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantidad);
    }
}
