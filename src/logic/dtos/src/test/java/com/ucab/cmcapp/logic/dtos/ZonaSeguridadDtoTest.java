package com.ucab.cmcapp.logic.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZonaSeguridadDtoTest {

    @Test
    void constructor_withId() {
        long id = 789;
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto(id);
        assertEquals(id, zonaSeguridadDto.getId());
    }

    @Test
    void get_id_dispositivo() {
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto();
        assertNull(zonaSeguridadDto.get_id_dispositivo());
    }

    @Test
    void set_id_dispositivo() {
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto();
        DispositivoDto dispositivoDto = new DispositivoDto();
        zonaSeguridadDto.set_id_dispositivo(dispositivoDto);
        assertEquals(dispositivoDto, zonaSeguridadDto.get_id_dispositivo());
    }

    @Test
    void get_nombre() {
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto();
        assertNull(zonaSeguridadDto.get_nombre());
    }

    @Test
    void set_nombre() {
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto();
        String nombre = "Zona1";
        zonaSeguridadDto.set_nombre(nombre);
        assertEquals(nombre, zonaSeguridadDto.get_nombre());
    }

    @Test
    void get_latitud_1() {
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto();
        assertNull(zonaSeguridadDto.get_latitud_1());
    }

    @Test
    void set_latitud_1() {
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto();
        Double latitud = 10.5;
        zonaSeguridadDto.set_latitud_1(latitud);
        assertEquals(latitud, zonaSeguridadDto.get_latitud_1());
    }

    @Test
    void get_longitud_1() {
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto();
        assertNull(zonaSeguridadDto.get_longitud_1());
    }

    @Test
    void set_longitud_1() {
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto();
        Double longitud = -66.8;
        zonaSeguridadDto.set_longitud_1(longitud);
        assertEquals(longitud, zonaSeguridadDto.get_longitud_1());
    }

    @Test
    void get_latitud_2() {
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto();
        assertNull(zonaSeguridadDto.get_latitud_2());
    }

    @Test
    void set_latitud_2() {
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto();
        Double latitud = 10.7;
        zonaSeguridadDto.set_latitud_2(latitud);
        assertEquals(latitud, zonaSeguridadDto.get_latitud_2());
    }

    @Test
    void get_longitud_2() {
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto();
        assertNull(zonaSeguridadDto.get_longitud_2());
    }

    @Test
    void set_longitud_2() {
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto();
        Double longitud = -66.9;
        zonaSeguridadDto.set_longitud_2(longitud);
        assertEquals(longitud, zonaSeguridadDto.get_longitud_2());
    }

    @Test
    void get_latitud_3() {
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto();
        assertNull(zonaSeguridadDto.get_latitud_3());
    }

    @Test
    void set_latitud_3() {
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto();
        Double latitud = 10.9;
        zonaSeguridadDto.set_latitud_3(latitud);
        assertEquals(latitud, zonaSeguridadDto.get_latitud_3());
    }

    @Test
    void get_longitud_3() {
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto();
        assertNull(zonaSeguridadDto.get_longitud_3());
    }

    @Test
    void set_longitud_3() {
        ZonaSeguridadDto zonaSeguridadDto = new ZonaSeguridadDto();
        Double longitud = -67.1;
        zonaSeguridadDto.set_longitud_3(longitud);
        assertEquals(longitud, zonaSeguridadDto.get_longitud_3());
    }
}
