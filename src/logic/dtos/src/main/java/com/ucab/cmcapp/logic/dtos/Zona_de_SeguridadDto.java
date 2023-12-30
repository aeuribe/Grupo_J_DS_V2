package com.ucab.cmcapp.logic.dtos;

public class Zona_de_SeguridadDto extends BaseDto{

    private long _id_zona;
    private String _nombre;
    private Double _latitud;
    private Double _longitud;

    public Zona_de_SeguridadDto() {
    }

    public Zona_de_SeguridadDto(long id, long _id_zona) {
        super(id);
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
