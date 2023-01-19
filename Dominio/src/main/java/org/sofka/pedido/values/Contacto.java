package org.sofka.pedido.values;

public class Contacto {
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
}
