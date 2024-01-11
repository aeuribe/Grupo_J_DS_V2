package com.ucab.cmcapp.logic.dtos;

import java.util.Date;

public class EventoDto extends BaseDto
{
    private DispositivoDto _id_dispositivo;
    private Date _fecha;
    private String _hora;
    private String _tipo;

    public EventoDto() {
    }

    public EventoDto(long id) {
        super(id);
    }

    public DispositivoDto get_id_dispositivo() {
        return _id_dispositivo;
    }

    public void set_id_dispositivo(DispositivoDto _id_dispositivo) {
        this._id_dispositivo = _id_dispositivo;
    }

    public Date get_fecha() {
        return _fecha;
    }

    public void set_fecha(Date _fecha) {
        this._fecha = _fecha;
    }

    public String get_hora() {
        return _hora;
    }

    public void set_hora(String _hora) {
        this._hora = _hora;
    }

    public String get_tipo() {
        return _tipo;
    }

    public void set_tipo(String _tipo) {
        this._tipo = _tipo;
    }
}
