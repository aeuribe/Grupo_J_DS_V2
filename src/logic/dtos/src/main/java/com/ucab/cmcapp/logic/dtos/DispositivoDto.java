package com.ucab.cmcapp.logic.dtos;

public class DispositivoDto extends BaseDto{

    private String _modelo;
    private String _marca;
    private String _nunero_telefonico;

    private UsuarioDto _id_usuario;

    public DispositivoDto() {
    }

    public DispositivoDto(long _id_dispositivo) {
        super(_id_dispositivo);
    }


    public String get_modelo() {
        return _modelo;
    }

    public void set_modelo(String _modelo) {
        this._modelo = _modelo;
    }

    public String get_marca() {
        return _marca;
    }

    public void set_marca(String _marca) {
        this._marca = _marca;
    }

    public String get_nunero_telefonico() {
        return _nunero_telefonico;
    }

    public void set_nunero_telefonico(String _nunero_telefonico) {
        this._nunero_telefonico = _nunero_telefonico;
    }

    public UsuarioDto get_id_usuario() {
        return _id_usuario;
    }

    public void set_id_usuario(UsuarioDto _id_usuario) {
        this._id_usuario = _id_usuario;
    }
}
