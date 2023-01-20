package org.sofka.insumo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Objeto de valor cantidad de la entidad Item
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class Cantidad implements ValueObject<String> {
    /**
     * peso del item insumo
     */
    private final String peso;

    /**
     * Método constructor para la cantidad del item insumo
     *
     * @param peso peso del item insumo
     *
     * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
     * @author Daniel Pérez Vitola <dapevi97@gmail.com>
     *
     * @since 1.0.0
     */
    public Cantidad(String peso) {

        this.peso = peso;
    }

    @Override
    public String value() {
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
