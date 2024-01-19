package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "USUARIO", uniqueConstraints = @UniqueConstraint(columnNames = "correo_electronico"))
public class Usuario {

    @Id
    @Column (name = "id_usuario")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long _id_usuario;

    @Column (name = "correo_electronico")
    private String _correo_electronico;

    @Column (name = "password")
    private String _password;

    @Column (name = "rol")
    private String _rol;

    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona _persona;

    public Usuario() {
    }

    public Usuario(long _id_usuario, String _correo_electronico, String _password, String _rol, Persona _persona) {
        this._id_usuario = _id_usuario;
        this._correo_electronico = _correo_electronico;
        this._password = _password;
        this._rol = _rol;
        this._persona = _persona;
    }

    public Usuario(String _correo_electronico) {
        this._correo_electronico = _correo_electronico;
    }

    public Persona get_persona() {
        return _persona;
    }
    public long get_id_usuario() {
        return _id_usuario;
    }

    public String get_correo_electronico() {
        return _correo_electronico;
    }

    public String get_password() {
        return _password;
    }

    public String get_rol() {
        return _rol;
    }

    public Usuario(long _id_usuario) {
        this._id_usuario = _id_usuario;
    }
    public void set_persona(Persona _persona) {
        this._persona = _persona;
    }

    public void set_id_usuario(long _id_usuario) {
        this._id_usuario = _id_usuario;
    }

    public void set_correo_electronico(String _correo_electronico) {
        this._correo_electronico = _correo_electronico;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public void set_rol(String _rol) {
        this._rol = _rol;
    }
}
