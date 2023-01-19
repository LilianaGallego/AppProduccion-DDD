package org.sofka.insumo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Objeto de valor del AR Insumo
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class Clasificacion implements ValueObject<String> {
    /**
     * clase de insumo
     */
    private String clase;

    /**
     * Método constructor para la clase de insumo
     *
     * @param clase peso del item insumo
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
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
