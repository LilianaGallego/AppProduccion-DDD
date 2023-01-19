package org.sofka.pedido.entidades;

import co.com.sofka.domain.generic.Entity;
import org.sofka.pedido.values.ClienteId;
import org.sofka.pedido.values.Contacto;
import org.sofka.pedido.values.Dieta;

import java.util.Objects;

public class Cliente extends Entity<ClienteId> {
    private Dieta dieta;
    private Contacto contacto;

    public Cliente(ClienteId clienteId, Contacto contacto){
        super(clienteId);
        this.contacto = contacto;

    }

    public void actualizarContacto(Contacto contacto){
        this.contacto = Objects.requireNonNull(contacto);

    }

    public Dieta getDieta() {
        return dieta;
    }

    public Contacto getContacto() {
        return contacto;
    }
}
