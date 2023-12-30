package com.ucab.cmcapp.logic.dtos;

import java.util.Date;

public class PosicionamientoDto extends BaseDto
{
    private long _id_posicionamiento;
    private DispositivoDto _dispositivo;
    private String _latitud;
    private String _logitud;
    private Date _fecha;

    public PosicionamientoDto(){

    }

    public PosicionamientoDto(long _id_posicionamiento){
        super( _id_posicionamiento );
    }

    public long get_id_posicionamiento() {
        return _id_posicionamiento;
    }

    public void set_id_posicionamiento(long _id_posicionamiento) {
        this._id_posicionamiento = _id_posicionamiento;
    }

    public DispositivoDto get_dispositivo() {
        return _dispositivo;
    }

    public void set_dispositivo(DispositivoDto _dispositivo) {
        this._dispositivo = _dispositivo;
    }

    public String get_latitud() {
        return _latitud;
    }

    public void set_latitud(String _latitud) {
        this._latitud = _latitud;
    }

    public String get_logitud() {
        return _logitud;
    }

    public void set_logitud(String _logitud) {
        this._logitud = _logitud;
    }

    public Date get_fecha() {
        return _fecha;
    }

    public void set_fecha(Date _fecha) {
        this._fecha = _fecha;
    }
}
