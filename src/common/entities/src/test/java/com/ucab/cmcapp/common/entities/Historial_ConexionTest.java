package com.ucab.cmcapp.common.entities;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class Historial_ConexionTest {

    @Test
    void constructorHistorialConexion() {
        // Arrange
        long idHistorial = 1;
        Date horaConexion = new Date();
        Date horaDesconexion = new Date();
        Date fecha = new Date();
        String estado = "Conectado";
        Dispositivo dispositivoMock = new Dispositivo();

        // Act
        Historial_Conexion historialConexion = new Historial_Conexion(idHistorial, horaConexion, horaDesconexion, fecha, estado, dispositivoMock);

        // Assert
        assertEquals(idHistorial, historialConexion.get_id_historial());
        assertEquals(horaConexion, historialConexion.get_hora_conexion());
        assertEquals(horaDesconexion, historialConexion.get_hora_desconexion());
        assertEquals(fecha, historialConexion.get_fecha());
        assertEquals(estado, historialConexion.get_estado());
        assertEquals(dispositivoMock, historialConexion.get_id_dispositivo());
    }

    @Test
    void get_id_historial() {
        // Arrange
        long idHistorial = 1;
        Historial_Conexion historialConexion = new Historial_Conexion(idHistorial);

        // Act
        long resultIdHistorial = historialConexion.get_id_historial();

        // Assert
        assertEquals(idHistorial, resultIdHistorial);
    }

    @Test
    void set_id_historial() {
        // Arrange
        long idHistorial = 1;
        Historial_Conexion historialConexion = new Historial_Conexion();

        // Act
        historialConexion.set_id_historial(idHistorial);
        long resultIdHistorial = historialConexion.get_id_historial();

        // Assert
        assertEquals(idHistorial, resultIdHistorial);
    }

    @Test
    void get_hora_conexion() {
        // Arrange
        Date horaConexion = new Date();
        Historial_Conexion historialConexion = new Historial_Conexion(1, horaConexion, null, null, null, null);

        // Act
        Date resultHoraConexion = historialConexion.get_hora_conexion();

        // Assert
        assertEquals(horaConexion, resultHoraConexion);
    }

    @Test
    void set_hora_conexion() {
        // Arrange
        Date horaConexion = new Date();
        Historial_Conexion historialConexion = new Historial_Conexion();

        // Act
        historialConexion.set_hora_conexion(horaConexion);
        Date resultHoraConexion = historialConexion.get_hora_conexion();

        // Assert
        assertEquals(horaConexion, resultHoraConexion);
    }

    @Test
    void get_hora_desconexion() {
        // Arrange
        Date horaDesconexion = new Date();
        Historial_Conexion historialConexion = new Historial_Conexion(1, null, horaDesconexion, null, null, null);

        // Act
        Date resultHoraDesconexion = historialConexion.get_hora_desconexion();

        // Assert
        assertEquals(horaDesconexion, resultHoraDesconexion);
    }

    @Test
    void set_hora_desconexion() {
        // Arrange
        Date horaDesconexion = new Date();
        Historial_Conexion historialConexion = new Historial_Conexion();

        // Act
        historialConexion.set_hora_desconexion(horaDesconexion);
        Date resultHoraDesconexion = historialConexion.get_hora_desconexion();

        // Assert
        assertEquals(horaDesconexion, resultHoraDesconexion);
    }

    @Test
    void get_fecha() {
        // Arrange
        Date fecha = new Date();
        Historial_Conexion historialConexion = new Historial_Conexion(1, null, null, fecha, null, null);

        // Act
        Date resultFecha = historialConexion.get_fecha();

        // Assert
        assertEquals(fecha, resultFecha);
    }

    @Test
    void set_fecha() {
        // Arrange
        Date fecha = new Date();
        Historial_Conexion historialConexion = new Historial_Conexion();

        // Act
        historialConexion.set_fecha(fecha);
        Date resultFecha = historialConexion.get_fecha();

        // Assert
        assertEquals(fecha, resultFecha);
    }

    @Test
    void get_estado() {
        // Arrange
        String estado = "Conectado";
        Historial_Conexion historialConexion = new Historial_Conexion(1, null, null, null, estado, null);

        // Act
        String resultEstado = historialConexion.get_estado();

        // Assert
        assertEquals(estado, resultEstado);
    }

    @Test
    void set_estado() {
        // Arrange
        String estado = "Conectado";
        Historial_Conexion historialConexion = new Historial_Conexion();

        // Act
        historialConexion.set_estado(estado);
        String resultEstado = historialConexion.get_estado();

        // Assert
        assertEquals(estado, resultEstado);
    }

    @Test
    void set_id_dispositivo() {
        // Arrange
        Dispositivo dispositivoMock = new Dispositivo();
        Historial_Conexion historialConexion = new Historial_Conexion();

        // Act
        historialConexion.set_id_dispositivo(dispositivoMock);
        Dispositivo resultDispositivo = historialConexion.get_id_dispositivo();

        // Assert
        assertEquals(dispositivoMock, resultDispositivo);
    }

}
