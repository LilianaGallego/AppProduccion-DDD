package org.sofka.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Objeto de valor cantidad de la entidad Pedido
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class Cantidad implements ValueObject<String> {
    /**
     * Cantidad del Pedido
     */
    private String cantidad;

    /**
     * Contructor para el objeto de valor Cantidad
     * @param cantidad cantidad
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Cantidad(String cantidad) {
        this.cantidad = Objects.requireNonNull(cantidad);
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
