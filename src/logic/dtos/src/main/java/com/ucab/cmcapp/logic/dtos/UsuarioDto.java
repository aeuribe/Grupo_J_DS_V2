package com.ucab.cmcapp.logic.dtos;

public class UsuarioDto extends BaseDto{

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


    public UsuarioDto(long _id_usuario) {
        super(_id_usuario);
    }

    public UsuarioDto() {
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
