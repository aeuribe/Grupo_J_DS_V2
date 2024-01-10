package com.ucab.cmcapp.logic.dtos;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class Historial_ConexionDto extends BaseDto{
    private Date _hora_conexion;
    private Date _hora_desconexion;
    private Date _fecha;
    private String _estado;
    private DispositivoDto _id_dispositivo;

    public Historial_ConexionDto() {
    }

    public Historial_ConexionDto(long id) {
        super(id);
    }

    public Date get_hora_conexion() {
        return _hora_conexion;
    }

    public void set_hora_conexion(Date _hora_conexion) {
        this._hora_conexion = _hora_conexion;
    }

    public Date get_hora_desconexion() {
        return _hora_desconexion;
    }

    public void set_hora_desconexion(Date _hora_desconexion) {
        this._hora_desconexion = _hora_desconexion;
    }

    public Date get_fecha() {
        return _fecha;
    }

    public void set_fecha(Date _fecha) {
        this._fecha = _fecha;
    }

    public String get_estado() {
        return _estado;
    }

    public void set_estado(String _estado) {
        this._estado = _estado;
    }

    public DispositivoDto get_id_dispositivo() {
        return _id_dispositivo;
    }

    public void set_id_dispositivo(DispositivoDto _id_dispositivo) {
        this._id_dispositivo = _id_dispositivo;
    }
}
