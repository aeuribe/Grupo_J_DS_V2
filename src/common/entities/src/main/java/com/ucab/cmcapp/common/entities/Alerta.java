package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table (name = "ALerta")
public class Alerta {

    @Id
    @Column(name = "id_alerta")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long _id_alerta;

    @ManyToOne
    @JoinColumn (name = "id_dispositivo")
    private Dispositivo _id_dispositivo;

    @Column (name = "nombre")
    private String _nombre;

    @Column (name = "descripcion")
    private String _descripcion;

    public Alerta() {
    }

    public Alerta(long _id_alerta, Dispositivo _id_dispositivo, String _nombre, String _descripcion) {
        this._id_alerta = _id_alerta;
        this._id_dispositivo = _id_dispositivo;
        this._nombre = _nombre;
        this._descripcion = _descripcion;
    }

    public Alerta(long _id_alerta) {
        this._id_alerta = _id_alerta;
    }

    public long get_id_alerta() {
        return _id_alerta;
    }

    public void set_id_alerta(long _id_alerta) {
        this._id_alerta = _id_alerta;
    }

    public Dispositivo get_id_dispositivo() {
        return _id_dispositivo;
    }

    public void set_id_dispositivo(Dispositivo _id_dispositivo) {
        this._id_dispositivo = _id_dispositivo;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }
}
