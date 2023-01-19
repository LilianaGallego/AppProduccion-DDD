package org.sofka.personal.entidades;
import co.com.sofka.domain.generic.Entity;
import org.sofka.personal.values.Seccion;
import org.sofka.personal.values.ManipuladorId;
public class Manipulador extends Entity<ManipuladorId> {

    private Seccion seccion ;
    private ManipuladorId manipuladorId;

     public Manipulador(ManipuladorId manipuladorId, Seccion seccion) {
        super(manipuladorId);
         this.seccion = seccion;
    }

    public void agregarManipulador(ManipuladorId manipuladorId, Seccion seccion){
        this.manipuladorId = manipuladorId;
        this.seccion = seccion;
    }

    public Seccion seccion(){
        return seccion;
    }
}
