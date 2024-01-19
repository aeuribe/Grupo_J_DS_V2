package com.ucab.cmcapp.common.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZonaSeguridadTest {

    @Test
    void get_id_dispositivo() {
        // Arrange
        Dispositivo dispositivo = new Dispositivo(); // Puedes crear un objeto Dispositivo para las pruebas
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();
        zonaSeguridad.set_id_dispositivo(dispositivo);

        // Act
        Dispositivo resultado = zonaSeguridad.get_id_dispositivo();

        // Assert
        assertEquals(dispositivo, resultado);
    }

    @Test
    void set_id_dispositivo() {
        // Arrange
        Dispositivo dispositivo = new Dispositivo();
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();

        // Act
        zonaSeguridad.set_id_dispositivo(dispositivo);
        Dispositivo resultado = zonaSeguridad.get_id_dispositivo();

        // Assert
        assertEquals(dispositivo, resultado);
    }

    @Test
    void get_id_zona() {
        // Arrange
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();
        zonaSeguridad.set_id_zona(1);

        // Act
        long resultado = zonaSeguridad.get_id_zona();

        // Assert
        assertEquals(1, resultado);
    }

    @Test
    void set_id_zona() {
        // Arrange
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();

        // Act
        zonaSeguridad.set_id_zona(2);
        long resultado = zonaSeguridad.get_id_zona();

        // Assert
        assertEquals(2, resultado);
    }

    @Test
    void get_nombre() {
        // Arrange
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();
        zonaSeguridad.set_nombre("Zona1");

        // Act
        String resultado = zonaSeguridad.get_nombre();

        // Assert
        assertEquals("Zona1", resultado);
    }

    @Test
    void set_nombre() {
        // Arrange
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();

        // Act
        zonaSeguridad.set_nombre("Zona2");
        String resultado = zonaSeguridad.get_nombre();

        // Assert
        assertEquals("Zona2", resultado);
    }

    @Test
    void get_latitud_1() {
        // Arrange
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();
        zonaSeguridad.set_latitud_1(10.0);

        // Act
        Double resultado = zonaSeguridad.get_latitud_1();

        // Assert
        assertEquals(10.0, resultado);
    }

    @Test
    void set_latitud_1() {
        // Arrange
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();

        // Act
        zonaSeguridad.set_latitud_1(20.0);
        Double resultado = zonaSeguridad.get_latitud_1();

        // Assert
        assertEquals(20.0, resultado);
    }

    @Test
    void get_longitud_1() {
        // Arrange
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();
        zonaSeguridad.set_longitud_1(30.0);

        // Act
        Double resultado = zonaSeguridad.get_longitud_1();

        // Assert
        assertEquals(30.0, resultado);
    }

    @Test
    void set_longitud_1() {
        // Arrange
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();

        // Act
        zonaSeguridad.set_longitud_1(40.0);
        Double resultado = zonaSeguridad.get_longitud_1();

        // Assert
        assertEquals(40.0, resultado);
    }

    @Test
    void get_latitud_2() {
        // Arrange
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();
        zonaSeguridad.set_latitud_2(50.0);

        // Act
        Double resultado = zonaSeguridad.get_latitud_2();

        // Assert
        assertEquals(50.0, resultado);
    }

    @Test
    void set_latitud_2() {
        // Arrange
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();

        // Act
        zonaSeguridad.set_latitud_2(60.0);
        Double resultado = zonaSeguridad.get_latitud_2();

        // Assert
        assertEquals(60.0, resultado);
    }

    @Test
    void get_longitud_2() {
        // Arrange
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();
        zonaSeguridad.set_longitud_2(70.0);

        // Act
        Double resultado = zonaSeguridad.get_longitud_2();

        // Assert
        assertEquals(70.0, resultado);
    }

    @Test
    void set_longitud_2() {
        // Arrange
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();

        // Act
        zonaSeguridad.set_longitud_2(80.0);
        Double resultado = zonaSeguridad.get_longitud_2();

        // Assert
        assertEquals(80.0, resultado);
    }

    @Test
    void get_latitud_3() {
        // Arrange
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();
        zonaSeguridad.set_latitud_3(90.0);

        // Act
        Double resultado = zonaSeguridad.get_latitud_3();

        // Assert
        assertEquals(90.0, resultado);
    }

    @Test
    void set_latitud_3() {
        // Arrange
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();

        // Act
        zonaSeguridad.set_latitud_3(100.0);
        Double resultado = zonaSeguridad.get_latitud_3();

        // Assert
        assertEquals(100.0, resultado);
    }

    @Test
    void get_longitud_3() {
        // Arrange
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();
        zonaSeguridad.set_longitud_3(110.0);

        // Act
        Double resultado = zonaSeguridad.get_longitud_3();

        // Assert
        assertEquals(110.0, resultado);
    }

    @Test
    void set_longitud_3() {
        // Arrange
        ZonaSeguridad zonaSeguridad = new ZonaSeguridad();

        // Act
        zonaSeguridad.set_longitud_3(120.0);
        Double resultado = zonaSeguridad.get_longitud_3();

        // Assert
        assertEquals(120.0, resultado);
    }
}
