package com.ucab.cmcapp.logic.dtos;

public class EventoDto extends BaseDto
{
    private long _id_evento;
    private DispositivoDto _id_dispositivo;
    private String _nombre;
    private String _descripcion;

    public EventoDto() {
    }

    public EventoDto(long id) {
        super(id);
    }

    public long get_id_evento() {
        return _id_evento;
    }

    public void set_id_evento(long _id_evento) {
        this._id_evento = _id_evento;
    }

    public DispositivoDto get_id_dispositivo() {
        return _id_dispositivo;
    }

    public void set_id_dispositivo(DispositivoDto _id_dispositivo) {
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
