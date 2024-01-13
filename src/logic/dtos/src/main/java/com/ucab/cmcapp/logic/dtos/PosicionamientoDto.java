package com.ucab.cmcapp.logic.dtos;

import java.util.Date;

public class PosicionamientoDto extends BaseDto
{
    private DispositivoDto _dispositivo;
    private Double _latitud;
    private Double _logitud;
    private Date _fecha;

    public PosicionamientoDto(){}

    public PosicionamientoDto( long id )
    {
        super( id );
    }

    public DispositivoDto get_dispositivo() {
        return _dispositivo;
    }

    public void set_dispositivo(DispositivoDto _dispositivo) {
        this._dispositivo = _dispositivo;
    }

    public Double get_latitud() {
        return _latitud;
    }

    public void set_latitud(Double _latitud) {
        this._latitud = _latitud;
    }

    public Double get_logitud() {
        return _logitud;
    }

    public void set_logitud(Double _logitud) {
        this._logitud = _logitud;
    }

    public Date get_fecha() {
        return _fecha;
    }

    public void set_fecha(Date _fecha) {
        this._fecha = _fecha;
    }
}
