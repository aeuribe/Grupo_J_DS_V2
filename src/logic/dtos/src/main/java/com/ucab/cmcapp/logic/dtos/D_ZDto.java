package com.ucab.cmcapp.logic.dtos;

public class D_ZDto extends BaseDto{
    private Zona_de_SeguridadDto _id_zona;
    private DispositivoDto _id_dispositivo;

    public D_ZDto() {
    }

    public D_ZDto(long id, Zona_de_SeguridadDto _id_zona, DispositivoDto _id_dispositivo) {
        super(id);
        this._id_zona = _id_zona;
        this._id_dispositivo = _id_dispositivo;
    }

    public Zona_de_SeguridadDto get_id_zona() {
        return _id_zona;
    }

    public void set_id_zona(Zona_de_SeguridadDto _id_zona) {
        this._id_zona = _id_zona;
    }

    public DispositivoDto get_id_dispositivo() {
        return _id_dispositivo;
    }

    public void set_id_dispositivo(DispositivoDto _id_dispositivo) {
        this._id_dispositivo = _id_dispositivo;
    }
}
