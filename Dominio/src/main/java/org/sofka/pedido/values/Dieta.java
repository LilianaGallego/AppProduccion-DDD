package org.sofka.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Objeto de valor Dieta de la entidad Cliente
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class Dieta implements ValueObject<String> {
    /**
     * String de la dieta
     */
    private final String dieta;

    /**
     * Contructor de Dieta
     * @param dieta string de la dieta
     */
    public Dieta(String dieta) {
        this.dieta = Objects.requireNonNull(dieta);
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
