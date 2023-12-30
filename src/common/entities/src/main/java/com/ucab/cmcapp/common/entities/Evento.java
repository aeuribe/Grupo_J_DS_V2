package com.ucab.cmcapp.common.entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table (name = "Evento")
public class Evento {

    @Id
    @Column (name = "id_evento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id_evento;

    @ManyToOne
    @JoinColumn(name = "id_dispositivo")
    private Dispositivo _id_dispositivo;

    @Column(name = "fecha")
    private Date _fecha;

    @Column(name = "hora")
    private String _hora;

    @Column(name = "tipo")
    private String _tipo;

    public Evento() {
    }

    public Evento(long _id_evento, Dispositivo _id_dispositivo, Date _fecha, String _hora, String _tipo) {
        this._id_evento = _id_evento;
        this._id_dispositivo = _id_dispositivo;
        this._fecha = _fecha;
        this._hora = _hora;
        this._tipo = _tipo;
    }

    public Evento(long _id_evento) {
        this._id_evento = _id_evento;
    }

    public long get_id_evento() {
        return _id_evento;
    }

    public void set_id_evento(long _id_evento) {
        this._id_evento = _id_evento;
    }

    public Dispositivo get_id_dispositivo() {
        return _id_dispositivo;
    }

    public void set_id_dispositivo(Dispositivo _id_dispositivo) {
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
