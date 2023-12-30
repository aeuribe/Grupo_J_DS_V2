package com.ucab.cmcapp.common.entities;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "Posicionamiento")
public class Posicionamiento {

    @Id
    @Column ( name = "id_posicionamiento")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long _id_posicionamiento;

    @ManyToOne
    @JoinColumn (name = "id_dispositivo")
    private Dispositivo _id_dispositivo;

    @Column (name = "latitud")
    private Double _latitud;

    @Column (name = "longitud")
    private Double _longitud;

    @Column (name = "fecha")
    private Date _fecha;

    public Posicionamiento() {
    }

    public Posicionamiento(long _id_posicionamiento, Dispositivo _id_dispositivo, Double _latitud, Double _longitud, Date _fecha) {
        this._id_posicionamiento = _id_posicionamiento;
        this._id_dispositivo = _id_dispositivo;
        this._latitud = _latitud;
        this._longitud = _longitud;
        this._fecha = _fecha;
    }

    public Posicionamiento(long _id_posicionamiento) {
        this._id_posicionamiento = _id_posicionamiento;
    }

    public long get_id_posicionamiento() {
        return _id_posicionamiento;
    }

    public void set_id_posicionamiento(long _id_posicionamiento) {
        this._id_posicionamiento = _id_posicionamiento;
    }

    public Dispositivo get_id_dispositivo() {
        return _id_dispositivo;
    }

    public void set_id_dispositivo(Dispositivo _id_dispositivo) {
        this._id_dispositivo = _id_dispositivo;
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

    public Date get_fecha() {
        return _fecha;
    }

    public void set_fecha(Date _fecha) {
        this._fecha = _fecha;
    }
}
