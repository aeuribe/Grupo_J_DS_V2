package com.ucab.cmcapp.logic.dtos;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class Historial_ConexionDtoTest {

    @Test
    void get_hora_conexion() {
        Date horaConexion = new Date();
        Historial_ConexionDto historialConexionDto = new Historial_ConexionDto();
        historialConexionDto.set_hora_conexion(horaConexion);

        assertEquals(horaConexion, historialConexionDto.get_hora_conexion());
    }

    @Test
    void set_hora_conexion() {
        Date horaConexion = new Date();
        Historial_ConexionDto historialConexionDto = new Historial_ConexionDto();
        historialConexionDto.set_hora_conexion(horaConexion);

        assertEquals(horaConexion, historialConexionDto.get_hora_conexion());
    }

    @Test
    void constructor_with_id() {
        long id = 1;
        Historial_ConexionDto historialConexionDto = new Historial_ConexionDto(id);

        assertEquals(id, historialConexionDto.getId());
    }

    @Test
    void get_hora_desconexion() {
        Date horaDesconexion = new Date();
        Historial_ConexionDto historialConexionDto = new Historial_ConexionDto();
        historialConexionDto.set_hora_desconexion(horaDesconexion);

        assertEquals(horaDesconexion, historialConexionDto.get_hora_desconexion());
    }

    @Test
    void set_hora_desconexion() {
        Date horaDesconexion = new Date();
        Historial_ConexionDto historialConexionDto = new Historial_ConexionDto();
        historialConexionDto.set_hora_desconexion(horaDesconexion);

        assertEquals(horaDesconexion, historialConexionDto.get_hora_desconexion());
    }

    @Test
    void get_fecha() {
        Date fecha = new Date();
        Historial_ConexionDto historialConexionDto = new Historial_ConexionDto();
        historialConexionDto.set_fecha(fecha);

        assertEquals(fecha, historialConexionDto.get_fecha());
    }

    @Test
    void set_fecha() {
        Date fecha = new Date();
        Historial_ConexionDto historialConexionDto = new Historial_ConexionDto();
        historialConexionDto.set_fecha(fecha);

        assertEquals(fecha, historialConexionDto.get_fecha());
    }

    @Test
    void get_estado() {
        String estado = "Conectado";
        Historial_ConexionDto historialConexionDto = new Historial_ConexionDto();
        historialConexionDto.set_estado(estado);

        assertEquals(estado, historialConexionDto.get_estado());
    }

    @Test
    void set_estado() {
        String estado = "Conectado";
        Historial_ConexionDto historialConexionDto = new Historial_ConexionDto();
        historialConexionDto.set_estado(estado);

        assertEquals(estado, historialConexionDto.get_estado());
    }

    @Test
    void get_id_dispositivo() {
        DispositivoDto dispositivoDto = new DispositivoDto();
        dispositivoDto.setId(1);
        Historial_ConexionDto historialConexionDto = new Historial_ConexionDto();
        historialConexionDto.set_id_dispositivo(dispositivoDto);

        assertEquals(dispositivoDto, historialConexionDto.get_id_dispositivo());
    }

    @Test
    void set_id_dispositivo() {
        DispositivoDto dispositivoDto = new DispositivoDto();
        dispositivoDto.setId(1);
        Historial_ConexionDto historialConexionDto = new Historial_ConexionDto();
        historialConexionDto.set_id_dispositivo(dispositivoDto);

        assertEquals(dispositivoDto, historialConexionDto.get_id_dispositivo());
    }
}
