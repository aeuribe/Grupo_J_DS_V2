package com.ucab.cmcapp.logic.dtos;
import java.util.Date;
import java.util.Set;

public class QuerellaDto extends BaseDto {

    private Date _fecha_caso;
    private String _descripcion;
    private long _distancia_alejamiento;
    private long _cuenta_atras;
    private long _inamovilidad;
    private PersonaDto id_victima;
    private PersonaDto id_agresor;

    public QuerellaDto(){}

    public QuerellaDto(long id) {
        super(id);
    }

    public Date get_fecha_caso() {
        return _fecha_caso;
    }

    public void set_fecha_caso(Date _fecha_caso) {
        this._fecha_caso = _fecha_caso;
    }

    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public long get_distancia_alejamiento() {
        return _distancia_alejamiento;
    }

    public void set_distancia_alejamiento(long _distancia_alejamiento) {
        this._distancia_alejamiento = _distancia_alejamiento;
    }

    public PersonaDto getId_victima() {
        return id_victima;
    }


    public void setId_victima(PersonaDto id_victima) {
        this.id_victima = id_victima;
    }

    public PersonaDto getId_agresor() {
        return id_agresor;
    }

    public void setId_agresor(PersonaDto id_agresor) {
        this.id_agresor = id_agresor;
    }

    public long get_cuenta_atras() {
        return _cuenta_atras;
    }

    public void set_cuenta_atras(long _cuenta_atras) {
        this._cuenta_atras = _cuenta_atras;
    }

    public long get_inamovilidad() {
        return _inamovilidad;
    }

    public void set_inamovilidad(long _inamovilidad) {
        this._inamovilidad = _inamovilidad;
    }
}
