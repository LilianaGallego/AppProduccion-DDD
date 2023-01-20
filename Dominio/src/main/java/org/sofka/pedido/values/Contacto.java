package org.sofka.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Objeto de valor Contacto de la entidad Cliente
 *
 * @version 1.0.0 2023-01-19
 * @author Martha Liliana Gallego Murillo<lilianagallegom@gmail.com>
 * @author Daniel Pérez Vitola <dapevi97@gmail.com>

 * @since 1.0.0
 */
public class Contacto implements ValueObject<Contacto.Props> {
    /**
     * Nombre que aparece en Cámara y Comercio del cliente
     */
    private final String razonSocial;
    /**
     * Teléfono del cliente
     */
    private final String telefono;
    /**
     * Dirección del cliente
     */
    private final String dirección;
    /**
     * Ciudad en donde se encuentra el cliente
     */
    private final String ciudad;

    /**
     * Contructor para el objeto de valor Contacto
     * @param razonSocial razón social
     * @param telefono telefono del cliente
     * @param dirección dirección del cliente
     * @param ciudad ciudad del cliente
     */
    public Contacto(String razonSocial, String telefono, String dirección, String ciudad) {
        this.razonSocial = Objects.requireNonNull(razonSocial);
        this.telefono = Objects.requireNonNull(telefono);
        this.dirección = Objects.requireNonNull(dirección);
        this.ciudad = Objects.requireNonNull(ciudad);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String razonSocial() {
                return razonSocial;
            }

            @Override
            public String telefono() {
                return telefono;
            }

            @Override
            public String dirección() {
                return dirección;
            }

            @Override
            public String ciudad() {
                return ciudad;
            }
        };
    }
    public interface Props{
        String razonSocial();
        String telefono();
        String dirección();
        String ciudad();
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDirección() {
        return dirección;
    }

    public String getCiudad() {
        return ciudad;
    }
}
