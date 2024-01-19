package com.ucab.cmcapp.common.entities;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table ( name = "Dispositivo",  uniqueConstraints = @UniqueConstraint(columnNames = "_numero_telefonico"))
public class Dispositivo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    @Column (name = "id_dispositivo")
    private long _id_dispositivo;
    @Column (name = "modelo")
    private String _modelo;
    @Column (name = "marca")
    private String _marca;


    @Column (name = "_numero_telefonico", nullable = false)
    private String _numero_telefonico;

    @OneToOne
    @JoinColumn ( name = "id_usuario")
    private Usuario _id_usuario;


    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumn (name = "id_alerta")
    private Set<Alerta> _alertasAsociadas = new HashSet<>();

    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumn (name = "id_evento")
    private Set<Evento> _eventosAsociados = new HashSet<>();

    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumn (name = "id_posicionamiento")
    private Set<Evento> _posAsociado = new HashSet<>();

    public Dispositivo() {
    }

    public Dispositivo(long _id_dispositivo, String _modelo, String _marca, String _numero_telefonico, Usuario _id_usuario) {
        this._id_dispositivo = _id_dispositivo;
        this._modelo = _modelo;
        this._marca = _marca;
        this._numero_telefonico = _numero_telefonico;
        this._id_usuario = _id_usuario;
    }

    public void addEventosAsociados(Evento evento)
    {
        _eventosAsociados.add(evento);
    }

    public Set<Evento> getEventosAsociados() {
        return _eventosAsociados;
    }

    public void setEventosAsociados(Set<Evento> eventosAsociados) {
        this._eventosAsociados = eventosAsociados;
    }

    public void addAlertasAsociadas(Alerta alerta)
    {
        _alertasAsociadas.add(alerta);
    }

    public Set<Alerta> getAlertasAsociadas() {
        return _alertasAsociadas;
    }

    public void setAlertasAsociadas(Set<Alerta> alertasAsociadas) {
        this._alertasAsociadas = alertasAsociadas;
    }

    public Dispositivo(long _id_dispositivo) {
        this._id_dispositivo = _id_dispositivo;
    }

    public long get_id_dispositivo() {
        return _id_dispositivo;
    }

    public void set_id_dispositivo(long _id_dispositivo) {
        this._id_dispositivo = _id_dispositivo;
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

    public String get_numero_telefonico() {
        return _numero_telefonico;
    }

    public void set_numero_telefonico(String _numero_telefonico) {
        this._numero_telefonico = _numero_telefonico;
    }

    public Usuario get_id_usuario() {
        return _id_usuario;
    }

    public void set_id_usuario(Usuario _id_usuario) {
        this._id_usuario = _id_usuario;
    }
}
