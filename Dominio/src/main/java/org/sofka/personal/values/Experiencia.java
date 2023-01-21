package org.sofka.personal.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Objeto valor Experiencia del Jefe
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class Experiencia implements ValueObject<String> {
    /**
     * Experiencia del jefe
     */
    private final String value;

    /**
     * Método constructor para la experiencia del jefe
     *
     * @param value observacion para el objeto valor bpm
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Experiencia(String value) {
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
        Experiencia that = (Experiencia) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
