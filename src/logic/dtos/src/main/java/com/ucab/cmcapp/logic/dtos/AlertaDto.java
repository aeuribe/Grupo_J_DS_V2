package com.ucab.cmcapp.logic.dtos;

public class AlertaDto extends BaseDto
{
    private long _id_alerta;
    private DispositivoDto _id_dispositivo;
    private String _nombre;
    private String _descripcion;

    public AlertaDto() {
    }

    public AlertaDto(long id, long _id_alerta) {
        super(id);
        this._id_alerta = _id_alerta;
    }

    public long get_id_alerta() {
        return _id_alerta;
    }

    public void set_id_alerta(long _id_alerta) {
        this._id_alerta = _id_alerta;
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
