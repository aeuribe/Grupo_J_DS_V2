package com.ucab.cmcapp.common.entities;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "QUERELLA")
public class Querella {

    @Id
    @Column (name = "id_querella")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long _id_querella;

    @Column ( name = "fecha_caso")
    private Date _fecha_caso;

    @Column ( name = "descripcion")
    private String _descripcion;

    @Column ( name = "distancia_alejamiento")
    private long _distancia_alejamiento;

    @Column ( name = "cuenta_atras")
    private long _cuenta_atras;

    @Column ( name = "inamovilidad")
    private long _inamovilidad;

    public Querella(long _id_querella, Date _fecha_caso, String _descripcion, long _distancia_alejamiento, long _cuenta_atras, long _inamovilidad) {
        this._id_querella = _id_querella;
        this._fecha_caso = _fecha_caso;
        this._descripcion = _descripcion;
        this._distancia_alejamiento = _distancia_alejamiento;
        this._cuenta_atras = _cuenta_atras;
        this._inamovilidad = _inamovilidad;
    }

    public Querella(long _id_querella) {
        this._id_querella = _id_querella;
    }

    public Querella(){}

    public void set_id_querella(long _id_querella) {
        this._id_querella = _id_querella;
    }

    public void set_fecha_caso(Date _fecha_caso) {
        this._fecha_caso = _fecha_caso;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public void set_distancia_alejamiento(long _distancia_alejamiento) {
        this._distancia_alejamiento = _distancia_alejamiento;
    }

    public void set_cuenta_atras(long _cuenta_atras) {
        this._cuenta_atras = _cuenta_atras;
    }

    public void set_inamovilidad(long _inamovilidad) {
        this._inamovilidad = _inamovilidad;
    }

    public long get_id_querella() {
        return _id_querella;
    }

    public Date get_fecha_caso() {
        return _fecha_caso;
    }

    public String get_descripcion() {
        return _descripcion;
    }

    public long get_distancia_alejamiento() {
        return _distancia_alejamiento;
    }

    public long get_cuenta_atras() {
        return _cuenta_atras;
    }

    public long get_inamovilidad() {
        return _inamovilidad;
    }
}
