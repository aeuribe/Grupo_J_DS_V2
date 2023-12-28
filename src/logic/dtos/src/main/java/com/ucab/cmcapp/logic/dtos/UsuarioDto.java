package com.ucab.cmcapp.logic.dtos;

public class UsuarioDto extends BaseDto{

    private long _id_usuario;
    private String _correo_electronico;
    private String _password;
    private String rol;
    private PersonaDto _persona;
    public void set_password(String _password) {
        this._password = _password;
    }

    public String get_password() {
        return _password;
    }


    public UsuarioDto(long id) {
        super(id);
    }

    public UsuarioDto() {
    }

    public long get_id_usuario() {
        return _id_usuario;
    }

    public String get_correo_electronico() {
        return _correo_electronico;
    }

    public String getRol() {
        return rol;
    }

    public PersonaDto get_persona() {
        return _persona;
    }

    public void set_id_usuario(long _id_usuario) {
        this._id_usuario = _id_usuario;
    }

    public void set_correo_electronico(String _correo_electronico) {
        this._correo_electronico = _correo_electronico;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void set_persona(PersonaDto _persona) {
        this._persona = _persona;
    }
}
