package com.ucab.cmcapp.common.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "Zona_de_Seguridad" )
public class Zona_de_Seguridad implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    @Column (name = "id_zona")
    private long _id_zona;
    @Column (name = "nombre")
    private String _nombre;

    @Column (name = "latitud")
    private Double _latitud;

    @Column (name = "longitud")
    private Double _longitud;

    public Zona_de_Seguridad() {
    }

    public Zona_de_Seguridad(long _id_zona, String _nombre, Double _latitud, Double _longitud) {
        this._id_zona = _id_zona;
        this._nombre = _nombre;
        this._latitud = _latitud;
        this._longitud = _longitud;
    }

    public Zona_de_Seguridad(long _id_zona) {
        this._id_zona = _id_zona;
    }

    public long get_id_zona() {
        return _id_zona;
    }

    public void set_id_zona(long _id_zona) {
        this._id_zona = _id_zona;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public Double get_latitud() {
        return _latitud;
    }

    public void set_latitud(Double _latitud) {
        this._latitud = _latitud;
    }

    public Double get_longitud() {
        return _longitud;
    }

    public void set_longitud(Double _longitud) {
        this._longitud = _longitud;
    }
}
