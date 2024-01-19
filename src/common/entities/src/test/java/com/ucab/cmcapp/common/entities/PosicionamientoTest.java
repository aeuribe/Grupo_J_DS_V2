package com.ucab.cmcapp.common.entities;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PosicionamientoTest {

    @Test
    void constructorConParametros() {
        // Arrange
        long idPosicionamiento = 1L;
        Dispositivo dispositivo = new Dispositivo();
        Double latitud = 10.0;
        Double longitud = 20.0;
        Date fecha = new Date();

        // Act
        Posicionamiento posicionamiento = new Posicionamiento(idPosicionamiento, dispositivo, latitud, longitud, fecha);

        // Assert
        assertEquals(idPosicionamiento, posicionamiento.get_id_posicionamiento());
        assertEquals(dispositivo, posicionamiento.get_id_dispositivo());
        assertEquals(latitud, posicionamiento.get_latitud());
        assertEquals(longitud, posicionamiento.get_longitud());
        assertEquals(fecha, posicionamiento.get_fecha());
    }

    @Test
    void constructorConId() {
        // Arrange
        long idPosicionamiento = 1L;

        // Act
        Posicionamiento posicionamiento = new Posicionamiento(idPosicionamiento);

        // Assert
        assertEquals(idPosicionamiento, posicionamiento.get_id_posicionamiento());
    }
    @Test
    void get_id_posicionamiento() {
        // Arrange
        Posicionamiento posicionamiento = new Posicionamiento();
        posicionamiento.set_id_posicionamiento(1);

        // Act
        long idPosicionamiento = posicionamiento.get_id_posicionamiento();

        // Assert
        assertEquals(1, idPosicionamiento);
    }

    @Test
    void set_id_posicionamiento() {
        // Arrange
        Posicionamiento posicionamiento = new Posicionamiento();

        // Act
        posicionamiento.set_id_posicionamiento(1);
        long idPosicionamiento = posicionamiento.get_id_posicionamiento();

        // Assert
        assertEquals(1, idPosicionamiento);
    }

    @Test
    void get_id_dispositivo() {
        // Arrange
        Posicionamiento posicionamiento = new Posicionamiento();
        Dispositivo dispositivo = new Dispositivo();
        posicionamiento.set_id_dispositivo(dispositivo);

        // Act
        Dispositivo idDispositivo = posicionamiento.get_id_dispositivo();

        // Assert
        assertEquals(dispositivo, idDispositivo);
    }

    @Test
    void set_id_dispositivo() {
        // Arrange
        Posicionamiento posicionamiento = new Posicionamiento();
        Dispositivo dispositivo = new Dispositivo();

        // Act
        posicionamiento.set_id_dispositivo(dispositivo);
        Dispositivo idDispositivo = posicionamiento.get_id_dispositivo();

        // Assert
        assertEquals(dispositivo, idDispositivo);
    }

    @Test
    void get_latitud() {
        // Arrange
        Posicionamiento posicionamiento = new Posicionamiento();
        posicionamiento.set_latitud(10.0);

        // Act
        double latitud = posicionamiento.get_latitud();

        // Assert
        assertEquals(10.0, latitud);
    }

    @Test
    void set_latitud() {
        // Arrange
        Posicionamiento posicionamiento = new Posicionamiento();

        // Act
        posicionamiento.set_latitud(10.0);
        double latitud = posicionamiento.get_latitud();

        // Assert
        assertEquals(10.0, latitud);
    }

    @Test
    void get_longitud() {
        // Arrange
        Posicionamiento posicionamiento = new Posicionamiento();
        posicionamiento.set_longitud(20.0);

        // Act
        double longitud = posicionamiento.get_longitud();

        // Assert
        assertEquals(20.0, longitud);
    }

    @Test
    void set_longitud() {
        // Arrange
        Posicionamiento posicionamiento = new Posicionamiento();

        // Act
        posicionamiento.set_longitud(20.0);
        double longitud = posicionamiento.get_longitud();

        // Assert
        assertEquals(20.0, longitud);
    }

    @Test
    void get_fecha() {
        // Arrange
        Posicionamiento posicionamiento = new Posicionamiento();
        Date fecha = new Date();
        posicionamiento.set_fecha(fecha);

        // Act
        Date fechaObtenida = posicionamiento.get_fecha();

        // Assert
        assertEquals(fecha, fechaObtenida);
    }

    @Test
    void set_fecha() {
        // Arrange
        Posicionamiento posicionamiento = new Posicionamiento();
        Date fecha = new Date();

        // Act
        posicionamiento.set_fecha(fecha);
        Date fechaObtenida = posicionamiento.get_fecha();

        // Assert
        assertEquals(fecha, fechaObtenida);
    }
}
