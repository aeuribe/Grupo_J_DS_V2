package com.ucab.cmcapp.logic.dtos;

import java.util.Set;

public class DispositivoDto extends BaseDto{

    private String _modelo;
    private String _marca;
    private String _numero_telefonico;
    private UsuarioDto _id_usuario;
    private Set<ZonaSeguridadDto> _zonas;
    private Set<AlertaDto> _alertas;
    private Set<EventoDto> _eventos;

    public Set<ZonaSeguridadDto> get_zonas() {
        return _zonas;
    }

    public void set_zonas(Set<ZonaSeguridadDto> _zonas) {
        this._zonas = _zonas;
    }

    public Set<AlertaDto> get_alertas() {
        return _alertas;
    }

    public void set_alertas(Set<AlertaDto> _alertas) {
        this._alertas = _alertas;
    }

    public Set<EventoDto> get_eventos() {
        return _eventos;
    }

    public void set_eventos(Set<EventoDto> _eventos) {
        this._eventos = _eventos;
    }

    public DispositivoDto() {
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

    public UsuarioDto get_id_usuario() {
        return _id_usuario;
    }

    public void set_id_usuario(UsuarioDto _id_usuario) {
        this._id_usuario = _id_usuario;
    }
}
