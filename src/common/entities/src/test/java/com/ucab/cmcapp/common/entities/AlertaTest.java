package com.ucab.cmcapp.common.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AlertaTest {

    @Test
    void get_id_alerta() {
        // Arrange
        long idAlerta = 1;
        Alerta alerta = new Alerta(idAlerta);

        // Act
        long result = alerta.get_id_alerta();

        // Assert
        assertEquals(idAlerta, result);
    }

    @Test
    void set_id_alerta() {
        // Arrange
        long idAlerta = 1;
        Alerta alerta = new Alerta();

        // Act
        alerta.set_id_alerta(idAlerta);

        // Assert
        assertEquals(idAlerta, alerta.get_id_alerta());
    }

    @Test
    void get_id_dispositivo() {
        // Arrange
        Dispositivo dispositivoMock = mock(Dispositivo.class);
        Alerta alerta = new Alerta(1, dispositivoMock, "Nombre", "Descripción");

        // Act
        Dispositivo result = alerta.get_id_dispositivo();

        // Assert
        assertEquals(dispositivoMock, result);
    }

    @Test
    void set_id_dispositivo() {
        // Arrange
        Dispositivo dispositivoMock = mock(Dispositivo.class);
        Alerta alerta = new Alerta();

        // Act
        alerta.set_id_dispositivo(dispositivoMock);

        // Assert
        assertEquals(dispositivoMock, alerta.get_id_dispositivo());
    }

    @Test
    void get_nombre() {
        // Arrange
        String nombre = "Nombre de la alerta";
        Alerta alerta = new Alerta(1, new Dispositivo(), nombre, "Descripción");

        // Act
        String result = alerta.get_nombre();

        // Assert
        assertEquals(nombre, result);
    }

    @Test
    void set_nombre() {
        // Arrange
        String nombre = "Nombre de la alerta";
        Alerta alerta = new Alerta();

        // Act
        alerta.set_nombre(nombre);

        // Assert
        assertEquals(nombre, alerta.get_nombre());
    }

    @Test
    void get_descripcion() {
        // Arrange
        String descripcion = "Descripción de la alerta";
        Alerta alerta = new Alerta(1, new Dispositivo(), "Nombre", descripcion);

        // Act
        String result = alerta.get_descripcion();

        // Assert
        assertEquals(descripcion, result);
    }

    @Test
    void set_descripcion() {
        // Arrange
        String descripcion = "Descripción de la alerta";
        Alerta alerta = new Alerta();

        // Act
        alerta.set_descripcion(descripcion);

        // Assert
        assertEquals(descripcion, alerta.get_descripcion());
    }
}
