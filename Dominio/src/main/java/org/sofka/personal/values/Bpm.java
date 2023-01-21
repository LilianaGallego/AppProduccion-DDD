package org.sofka.personal.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Objeto valor Bpm del personal
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class Bpm implements ValueObject<String> {

    /**
     * observación del objeto valor
     */
    private final String value;

    /**
     * Método constructor para la observación del bpm del personal
     *
     * @param value observacion para el objeto valor bpm
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
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
