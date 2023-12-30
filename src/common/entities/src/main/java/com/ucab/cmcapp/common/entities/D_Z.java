package com.ucab.cmcapp.common.entities;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table ( name = "D_Z")
public class D_Z implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn ( name = "id_zona")
    private Zona_de_Seguridad _id_zona;

    @Id
    @ManyToOne
    @JoinColumn ( name = "id_dispositivo")
    private Dispositivo _id_dispositivo;

    public D_Z() {
    }

    public D_Z(Zona_de_Seguridad _id_zona, Dispositivo _id_dispositivo) {
        this._id_zona = _id_zona;
        this._id_dispositivo = _id_dispositivo;
    }

    public Zona_de_Seguridad get_id_zona() {
        return _id_zona;
    }

    public void set_id_zona(Zona_de_Seguridad _id_zona) {
        this._id_zona = _id_zona;
    }

    public Dispositivo get_id_dispositivo() {
        return _id_dispositivo;
    }

    public void set_id_dispositivo(Dispositivo _id_dispositivo) {
        this._id_dispositivo = _id_dispositivo;
    }
}
