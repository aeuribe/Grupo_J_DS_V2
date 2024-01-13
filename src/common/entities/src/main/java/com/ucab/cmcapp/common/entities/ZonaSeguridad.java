package com.ucab.cmcapp.common.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "ZonaSeguridad" )
public class ZonaSeguridad implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    @Column (name = "id_zona")
    private long _id_zona;
    @Column (name = "nombre")
    private String _nombre;

    @Column (name = "latitud_1")
    private Double _latitud_1;

    @Column (name = "longitud_1")
    private Double _longitud_1;

    @Column (name = "latitud_2")
    private Double _latitud_2;

    @Column (name = "longitud_2")
    private Double _longitud_2;

    @Column (name = "latitud_3")
    private Double _latitud_3;

    @Column (name = "longitud_3")
    private Double _longitud_3;

    public ZonaSeguridad() {
    }

    public ZonaSeguridad(long _id_zona, String _nombre, Double _latitud, Double _longitud) {
        this._id_zona = _id_zona;
        this._nombre = _nombre;
        this._latitud_1 = _latitud;
        this._longitud_1 = _longitud;
        this._latitud_2 = _latitud;
        this._longitud_2 = _longitud;
        this._latitud_3 = _latitud;
        this._longitud_3 = _longitud;
    }

    public ZonaSeguridad(long _id_zona) {
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

    public Double get_latitud_1() {
        return _latitud_1;
    }

    public void set_latitud_1(Double _latitud) {
        this._latitud_1 = _latitud;
    }

    public Double get_longitud_1() {
        return _longitud_1;
    }

    public void set_longitud_1(Double _longitud) {
        this._longitud_1 = _longitud;
    }

    public Double get_latitud_2() {
        return _latitud_2;
    }

    public void set_latitud_2(Double _latitud_2) {
        this._latitud_2 = _latitud_2;
    }

    public Double get_longitud_2() {
        return _longitud_2;
    }

    public void set_longitud_2(Double _longitud_2) {
        this._longitud_2 = _longitud_2;
    }

    public Double get_latitud_3() {
        return _latitud_3;
    }

    public void set_latitud_3(Double _latitud_3) {
        this._latitud_3 = _latitud_3;
    }

    public Double get_longitud_3() {
        return _longitud_3;
    }

    public void set_longitud_3(Double _longitud_3) {
        this._longitud_3 = _longitud_3;
    }
}
