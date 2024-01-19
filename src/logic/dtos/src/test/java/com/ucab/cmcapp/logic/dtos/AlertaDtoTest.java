package com.ucab.cmcapp.logic.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlertaDtoTest {

    @Test
    void constructorWithId() {
        // Arrange
        long id = 123;

        // Act
        AlertaDto alertaDto = new AlertaDto(id);

        // Assert
        assertEquals(id, alertaDto.getId());
    }

    @Test
    void get_id_dispositivo() {
        // Arrange
        AlertaDto alertaDto = new AlertaDto();
        DispositivoDto dispositivoDto = new DispositivoDto();
        alertaDto.set_id_dispositivo(dispositivoDto);

        // Act
        DispositivoDto result = alertaDto.get_id_dispositivo();

        // Assert
        assertEquals(dispositivoDto, result);
    }

    @Test
    void set_id_dispositivo() {
        // Arrange
        AlertaDto alertaDto = new AlertaDto();
        DispositivoDto dispositivoDto = new DispositivoDto();

        // Act
        alertaDto.set_id_dispositivo(dispositivoDto);

        // Assert
        assertEquals(dispositivoDto, alertaDto.get_id_dispositivo());
    }

    @Test
    void get_nombre() {
        // Arrange
        AlertaDto alertaDto = new AlertaDto();
        String nombre = "Nombre de la alerta";
        alertaDto.set_nombre(nombre);

        // Act
        String result = alertaDto.get_nombre();

        // Assert
        assertEquals(nombre, result);
    }

    @Test
    void set_nombre() {
        // Arrange
        AlertaDto alertaDto = new AlertaDto();
        String nombre = "Nombre de la alerta";

        // Act
        alertaDto.set_nombre(nombre);

        // Assert
        assertEquals(nombre, alertaDto.get_nombre());
    }

    @Test
    void get_descripcion() {
        // Arrange
        AlertaDto alertaDto = new AlertaDto();
        String descripcion = "Descripción de la alerta";
        alertaDto.set_descripcion(descripcion);

        // Act
        String result = alertaDto.get_descripcion();

        // Assert
        assertEquals(descripcion, result);
    }

    @Test
    void set_descripcion() {
        // Arrange
        AlertaDto alertaDto = new AlertaDto();
        String descripcion = "Descripción de la alerta";

        // Act
        alertaDto.set_descripcion(descripcion);

        // Assert
        assertEquals(descripcion, alertaDto.get_descripcion());
    }
}
