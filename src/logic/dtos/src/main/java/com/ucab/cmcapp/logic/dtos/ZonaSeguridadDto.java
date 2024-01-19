package com.ucab.cmcapp.logic.dtos;

import javax.persistence.Column;

public class ZonaSeguridadDto extends BaseDto{
    private String _nombre;

    private Double _latitud_1;

    private Double _longitud_1;

    private Double _latitud_2;

    private Double _longitud_2;

    private Double _latitud_3;

    private Double _longitud_3;

    private DispositivoDto _id_dispositivo;

    public DispositivoDto get_id_dispositivo() {
        return _id_dispositivo;
    }

    public void set_id_dispositivo(DispositivoDto _id_dispositivo) {
        this._id_dispositivo = _id_dispositivo;
    }

    public ZonaSeguridadDto() {
    }

    public ZonaSeguridadDto(long id) {
        super(id);
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

    public void set_latitud_1(Double _latitud_1) {
        this._latitud_1 = _latitud_1;
    }

    public Double get_longitud_1() {
        return _longitud_1;
    }

    public void set_longitud_1(Double _longitud_1) {
        this._longitud_1 = _longitud_1;
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
