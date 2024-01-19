package com.ucab.cmcapp.logic.dtos;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class QuerellaDtoTest {

    @Test
    void constructor_withId() {
        long id = 123;
        QuerellaDto querellaDto = new QuerellaDto(id);
        assertEquals(id, querellaDto.getId());
    }

    @Test
    void get_fecha_caso() {
        QuerellaDto querellaDto = new QuerellaDto();
        assertNull(querellaDto.get_fecha_caso());
    }

    @Test
    void set_fecha_caso() {
        QuerellaDto querellaDto = new QuerellaDto();
        Date fechaCaso = new Date();
        querellaDto.set_fecha_caso(fechaCaso);
        assertEquals(fechaCaso, querellaDto.get_fecha_caso());
    }

    @Test
    void get_descripcion() {
        QuerellaDto querellaDto = new QuerellaDto();
        assertNull(querellaDto.get_descripcion());
    }

    @Test
    void set_descripcion() {
        QuerellaDto querellaDto = new QuerellaDto();
        String descripcion = "Descripción de la querella";
        querellaDto.set_descripcion(descripcion);
        assertEquals(descripcion, querellaDto.get_descripcion());
    }

    @Test
    void get_distancia_alejamiento() {
        QuerellaDto querellaDto = new QuerellaDto();
        assertEquals(0, querellaDto.get_distancia_alejamiento());
    }

    @Test
    void set_distancia_alejamiento() {
        QuerellaDto querellaDto = new QuerellaDto();
        long distanciaAlejamiento = 50;
        querellaDto.set_distancia_alejamiento(distanciaAlejamiento);
        assertEquals(distanciaAlejamiento, querellaDto.get_distancia_alejamiento());
    }

    @Test
    void getId_victima() {
        QuerellaDto querellaDto = new QuerellaDto();
        assertNull(querellaDto.getId_victima());
    }

    @Test
    void setId_victima() {
        QuerellaDto querellaDto = new QuerellaDto();
        PersonaDto victima = new PersonaDto();
        querellaDto.setId_victima(victima);
        assertEquals(victima, querellaDto.getId_victima());
    }

    @Test
    void getId_agresor() {
        QuerellaDto querellaDto = new QuerellaDto();
        assertNull(querellaDto.getId_agresor());
    }

    @Test
    void setId_agresor() {
        QuerellaDto querellaDto = new QuerellaDto();
        PersonaDto agresor = new PersonaDto();
        querellaDto.setId_agresor(agresor);
        assertEquals(agresor, querellaDto.getId_agresor());
    }

    @Test
    void get_cuenta_atras() {
        QuerellaDto querellaDto = new QuerellaDto();
        assertEquals(0, querellaDto.get_cuenta_atras());
    }

    @Test
    void set_cuenta_atras() {
        QuerellaDto querellaDto = new QuerellaDto();
        long cuentaAtras = 10;
        querellaDto.set_cuenta_atras(cuentaAtras);
        assertEquals(cuentaAtras, querellaDto.get_cuenta_atras());
    }

    @Test
    void get_inamovilidad() {
        QuerellaDto querellaDto = new QuerellaDto();
        assertEquals(0, querellaDto.get_inamovilidad());
    }

    @Test
    void set_inamovilidad() {
        QuerellaDto querellaDto = new QuerellaDto();
        long inamovilidad = 5;
        querellaDto.set_inamovilidad(inamovilidad);
        assertEquals(inamovilidad, querellaDto.get_inamovilidad());
    }
}
