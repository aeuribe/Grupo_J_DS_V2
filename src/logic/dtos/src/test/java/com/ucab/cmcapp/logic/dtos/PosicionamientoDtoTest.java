package com.ucab.cmcapp.logic.dtos;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PosicionamientoDtoTest {

    @Test
    void get_dispositivo() {
        PosicionamientoDto posicionamientoDto = new PosicionamientoDto();
        assertNull(posicionamientoDto.get_dispositivo());
    }

    @Test
    void set_dispositivo() {
        PosicionamientoDto posicionamientoDto = new PosicionamientoDto();
        DispositivoDto dispositivoDto = new DispositivoDto();
        posicionamientoDto.set_dispositivo(dispositivoDto);
        assertEquals(dispositivoDto, posicionamientoDto.get_dispositivo());
    }

    @Test
    void get_latitud() {
        PosicionamientoDto posicionamientoDto = new PosicionamientoDto();
        assertNull(posicionamientoDto.get_latitud());
    }

    @Test
    void set_latitud() {
        PosicionamientoDto posicionamientoDto = new PosicionamientoDto();
        Double latitud = 10.0;
        posicionamientoDto.set_latitud(latitud);
        assertEquals(latitud, posicionamientoDto.get_latitud());
    }

    @Test
    void get_logitud() {
        PosicionamientoDto posicionamientoDto = new PosicionamientoDto();
        assertNull(posicionamientoDto.get_logitud());
    }

    @Test
    void set_logitud() {
        PosicionamientoDto posicionamientoDto = new PosicionamientoDto();
        Double longitud = 20.0;
        posicionamientoDto.set_logitud(longitud);
        assertEquals(longitud, posicionamientoDto.get_logitud());
    }

    @Test
    void get_fecha() {
        PosicionamientoDto posicionamientoDto = new PosicionamientoDto();
        assertNull(posicionamientoDto.get_fecha());
    }

    @Test
    void constructor_withId() {
        long id = 123;
        PosicionamientoDto posicionamientoDto = new PosicionamientoDto(id);
        assertEquals(id, posicionamientoDto.getId());
    }

    @Test
    void set_fecha() {
        PosicionamientoDto posicionamientoDto = new PosicionamientoDto();
        Date fecha = new Date();
        posicionamientoDto.set_fecha(fecha);
        assertEquals(fecha, posicionamientoDto.get_fecha());
    }
}
