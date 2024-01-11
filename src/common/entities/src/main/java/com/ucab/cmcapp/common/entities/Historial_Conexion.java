package com.ucab.cmcapp.common.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "Historial_Conexion" )
public class Historial_Conexion implements Serializable
{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    @Column (name = "id_historial")
    private long _id_historial;
    @Column (name = "hora_conexion")
    private Date _hora_conexion;
    @Column (name = "hora_desconexion")
    private Date _hora_desconexion;
    @Column (name = "_fecha")
    private Date _fecha;
    @Column (name = "_estado")
    private String _estado;
    @ManyToOne
    @JoinColumn ( name = "id_dispositivo")
    private Dispositivo _id_dispositivo;

    public Historial_Conexion() {
    }

    public Historial_Conexion(long _id_historial, Date _hora_conexion, Date _hora_desconexion, Date _fecha, String _estado, Dispositivo _id_dispositivo) {
        this._id_historial = _id_historial;
        this._hora_conexion = _hora_conexion;
        this._hora_desconexion = _hora_desconexion;
        this._fecha = _fecha;
        this._estado = _estado;
        this._id_dispositivo = _id_dispositivo;
    }

    public Historial_Conexion(long _id_historial) {
        this._id_historial = _id_historial;
    }

    public long get_id_historial() {
        return _id_historial;
    }

    public void set_id_historial(long _id_historial) {
        this._id_historial = _id_historial;
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

    public Dispositivo get_id_dispositivo() {
        return _id_dispositivo;
    }
    public void set_id_dispositivo(Dispositivo _id_dispositivo) {
        this._id_dispositivo = _id_dispositivo;
    }
}
