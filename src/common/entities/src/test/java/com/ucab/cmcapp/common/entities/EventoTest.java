package com.ucab.cmcapp.common.entities;

import com.ucab.cmcapp.common.entities.Dispositivo;
import com.ucab.cmcapp.common.entities.Evento;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EventoTest {

    @Test
    void get_id_evento() {
        // Arrange
        long idEvento = 123;
        Evento evento = new Evento(idEvento);

        // Act
        long result = evento.get_id_evento();

        // Assert
        assertEquals(idEvento, result);
    }

    @Test
    void set_id_evento() {
        // Arrange
        long idEvento = 123;
        Evento evento = new Evento();

        // Act
        evento.set_id_evento(idEvento);

        // Assert
        assertEquals(idEvento, evento.get_id_evento());
    }

    @Test
    void get_id_dispositivo() {
        // Arrange
        Dispositivo dispositivoMock = mock(Dispositivo.class);
        Evento evento = new Evento();
        evento.set_id_dispositivo(dispositivoMock);

        // Act
        Dispositivo result = evento.get_id_dispositivo();

        // Assert
        assertEquals(dispositivoMock, result);
    }

    @Test
    void set_id_dispositivo() {
        // Arrange
        Dispositivo dispositivoMock = mock(Dispositivo.class);
        Evento evento = new Evento();

        // Act
        evento.set_id_dispositivo(dispositivoMock);

        // Assert
        assertEquals(dispositivoMock, evento.get_id_dispositivo());
    }

    @Test
    void get_fecha() {
        // Arrange
        Evento evento = new Evento();
        evento.set_fecha(new Date());  // Puedes usar la clase Date para obtener la fecha actual.

        // Act
        Date result = evento.get_fecha();

        // Assert
        assertNotNull(result);
    }

    @Test
    void set_fecha() {
        // Arrange
        Evento evento = new Evento();
        Date fecha = new Date();  // Puedes usar la clase Date para obtener la fecha actual.

        // Act
        evento.set_fecha(fecha);

        // Assert
        assertEquals(fecha, evento.get_fecha());
    }

    @Test
    void get_hora() {
        // Arrange
        String hora = "12:30";
        Evento evento = new Evento();
        evento.set_hora(hora);

        // Act
        String result = evento.get_hora();

        // Assert
        assertEquals(hora, result);
    }

    @Test
    void set_hora() {
        // Arrange
        String hora = "12:30";
        Evento evento = new Evento();

        // Act
        evento.set_hora(hora);

        // Assert
        assertEquals(hora, evento.get_hora());
    }

    @Test
    void get_tipo() {
        // Arrange
        String tipo = "Alerta";
        Evento evento = new Evento();
        evento.set_tipo(tipo);

        // Act
        String result = evento.get_tipo();

        // Assert
        assertEquals(tipo, result);
    }

    @Test
    void set_tipo() {
        // Arrange
        String tipo = "Alerta";
        Evento evento = new Evento();

        // Act
        evento.set_tipo(tipo);

        // Assert
        assertEquals(tipo, evento.get_tipo());
    }

    @Test
    void constructorEvento() {
        // Arrange
        long idEvento = 1;
        Dispositivo dispositivoMock = new Dispositivo();
        Date fecha = new Date();
        String hora = "12:00 PM";
        String tipo = "EventoTipo";

        // Act
        Evento evento = new Evento(idEvento, dispositivoMock, fecha, hora, tipo);

        // Assert
        assertEquals(idEvento, evento.get_id_evento());
        assertEquals(dispositivoMock, evento.get_id_dispositivo());
        assertEquals(fecha, evento.get_fecha());
        assertEquals(hora, evento.get_hora());
        assertEquals(tipo, evento.get_tipo());
    }

}
