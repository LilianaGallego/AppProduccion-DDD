package org.sofka.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

public class Contacto implements ValueObject<Contacto.Props> {
    private final String razonSocial;
    private final String telefono;
    private final String dirección;
    private final String ciudad;

    public Contacto(String razonSocial, String telefono, String dirección, String ciudad) {
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.dirección = dirección;
        this.ciudad = ciudad;
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
