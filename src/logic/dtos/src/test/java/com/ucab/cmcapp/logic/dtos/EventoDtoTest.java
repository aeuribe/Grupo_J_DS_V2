package com.ucab.cmcapp.logic.dtos;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EventoDtoTest {

    @Test
    void get_id_dispositivo() {
        DispositivoDto dispositivoDto = new DispositivoDto();
        dispositivoDto.setId(1);
        EventoDto eventoDto = new EventoDto();
        eventoDto.set_id_dispositivo(dispositivoDto);

        assertEquals(dispositivoDto, eventoDto.get_id_dispositivo());
    }

    @Test
    void constructorConId() {
        long id = 1;
        EventoDto eventoDto = new EventoDto(id);

        assertEquals(id, eventoDto.getId());

    }


    @Test
    void set_id_dispositivo() {
        DispositivoDto dispositivoDto = new DispositivoDto();
        dispositivoDto.setId(1);
        EventoDto eventoDto = new EventoDto();
        eventoDto.set_id_dispositivo(dispositivoDto);

        assertEquals(dispositivoDto, eventoDto.get_id_dispositivo());
    }

    @Test
    void get_fecha() {
        Date fecha = new Date();
        EventoDto eventoDto = new EventoDto();
        eventoDto.set_fecha(fecha);

        assertEquals(fecha, eventoDto.get_fecha());
    }

    @Test
    void set_fecha() {
        Date fecha = new Date();
        EventoDto eventoDto = new EventoDto();
        eventoDto.set_fecha(fecha);

        assertEquals(fecha, eventoDto.get_fecha());
    }

    @Test
    void get_hora() {
        String hora = "12:34";
        EventoDto eventoDto = new EventoDto();
        eventoDto.set_hora(hora);

        assertEquals(hora, eventoDto.get_hora());
    }

    @Test
    void set_hora() {
        String hora = "12:34";
        EventoDto eventoDto = new EventoDto();
        eventoDto.set_hora(hora);

        assertEquals(hora, eventoDto.get_hora());
    }

    @Test
    void get_tipo() {
        String tipo = "Alarma";
        EventoDto eventoDto = new EventoDto();
        eventoDto.set_tipo(tipo);

        assertEquals(tipo, eventoDto.get_tipo());
    }

    @Test
    void set_tipo() {
        String tipo = "Alarma";
        EventoDto eventoDto = new EventoDto();
        eventoDto.set_tipo(tipo);

        assertEquals(tipo, eventoDto.get_tipo());
    }
}
