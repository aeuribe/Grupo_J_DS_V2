package com.ucab.cmcapp.logic.dtos;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DispositivoDtoTest {

    @Test
    void constructorWithId() {
        long idDispositivo = 123;
        DispositivoDto dispositivoDto = new DispositivoDto();
        dispositivoDto.setId(idDispositivo);

        assertEquals(idDispositivo, dispositivoDto.getId());
    }


    @Test
    void get_zonas() {
        DispositivoDto dispositivoDto = new DispositivoDto();
        Set<ZonaSeguridadDto> zonas = new HashSet<>();
        ZonaSeguridadDto zonaMock = mock(ZonaSeguridadDto.class);
        zonas.add(zonaMock);

        dispositivoDto.set_zonas(zonas);
        assertEquals(zonas, dispositivoDto.get_zonas());
    }

    @Test
    void set_zonas() {
        DispositivoDto dispositivoDto = new DispositivoDto();
        Set<ZonaSeguridadDto> zonas = new HashSet<>();
        ZonaSeguridadDto zonaMock = mock(ZonaSeguridadDto.class);
        zonas.add(zonaMock);

        dispositivoDto.set_zonas(zonas);
        assertEquals(zonas, dispositivoDto.get_zonas());
    }

    @Test
    void get_alertas() {
        DispositivoDto dispositivoDto = new DispositivoDto();
        Set<AlertaDto> alertas = new HashSet<>();
        AlertaDto alertaMock = mock(AlertaDto.class);
        alertas.add(alertaMock);

        dispositivoDto.set_alertas(alertas);
        assertEquals(alertas, dispositivoDto.get_alertas());
    }

    @Test
    void set_alertas() {
        DispositivoDto dispositivoDto = new DispositivoDto();
        Set<AlertaDto> alertas = new HashSet<>();
        AlertaDto alertaMock = mock(AlertaDto.class);
        alertas.add(alertaMock);

        dispositivoDto.set_alertas(alertas);
        assertEquals(alertas, dispositivoDto.get_alertas());
    }

    @Test
    void get_eventos() {
        DispositivoDto dispositivoDto = new DispositivoDto();
        Set<EventoDto> eventos = new HashSet<>();
        EventoDto eventoMock = mock(EventoDto.class);
        eventos.add(eventoMock);

        dispositivoDto.set_eventos(eventos);
        assertEquals(eventos, dispositivoDto.get_eventos());
    }

    @Test
    void set_eventos() {
        DispositivoDto dispositivoDto = new DispositivoDto();
        Set<EventoDto> eventos = new HashSet<>();
        EventoDto eventoMock = mock(EventoDto.class);
        eventos.add(eventoMock);

        dispositivoDto.set_eventos(eventos);
        assertEquals(eventos, dispositivoDto.get_eventos());
    }

    @Test
    void get_modelo() {
        DispositivoDto dispositivoDto = new DispositivoDto();
        String modelo = "EjemploModelo";
        dispositivoDto.set_modelo(modelo);
        assertEquals(modelo, dispositivoDto.get_modelo());
    }

    @Test
    void set_modelo() {
        DispositivoDto dispositivoDto = new DispositivoDto();
        String modelo = "EjemploModelo";
        dispositivoDto.set_modelo(modelo);
        assertEquals(modelo, dispositivoDto.get_modelo());
    }

    @Test
    void get_marca() {
        DispositivoDto dispositivoDto = new DispositivoDto();
        String marca = "EjemploMarca";
        dispositivoDto.set_marca(marca);
        assertEquals(marca, dispositivoDto.get_marca());
    }

    @Test
    void set_marca() {
        DispositivoDto dispositivoDto = new DispositivoDto();
        String marca = "EjemploMarca";
        dispositivoDto.set_marca(marca);
        assertEquals(marca, dispositivoDto.get_marca());
    }

    @Test
    void get_numero_telefonico() {
        DispositivoDto dispositivoDto = new DispositivoDto();
        String numeroTelefonico = "123456789";
        dispositivoDto.set_numero_telefonico(numeroTelefonico);
        assertEquals(numeroTelefonico, dispositivoDto.get_numero_telefonico());
    }

    @Test
    void set_numero_telefonico() {
        DispositivoDto dispositivoDto = new DispositivoDto();
        String numeroTelefonico = "123456789";
        dispositivoDto.set_numero_telefonico(numeroTelefonico);
        assertEquals(numeroTelefonico, dispositivoDto.get_numero_telefonico());
    }

    @Test
    void get_id_usuario() {
        DispositivoDto dispositivoDto = new DispositivoDto();
        UsuarioDto usuarioDto = mock(UsuarioDto.class);
        dispositivoDto.set_id_usuario(usuarioDto);
        assertEquals(usuarioDto, dispositivoDto.get_id_usuario());
    }

    @Test
    void set_id_usuario() {
        DispositivoDto dispositivoDto = new DispositivoDto();
        UsuarioDto usuarioDto = mock(UsuarioDto.class);
        dispositivoDto.set_id_usuario(usuarioDto);
        assertEquals(usuarioDto, dispositivoDto.get_id_usuario());
    }
}
