package com.ucab.cmcapp.common.entities;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DispositivoTest {

    @Test
    void addEventosAsociados() {
        // Arrange
        Dispositivo dispositivo = new Dispositivo();
        Evento eventoMock = new Evento();

        // Act
        dispositivo.addEventosAsociados(eventoMock);
        Set<Evento> eventosAsociados = dispositivo.getEventosAsociados();

        // Assert
        assertTrue(eventosAsociados.contains(eventoMock));
    }

    @Test
    void getEventosAsociados() {
        // Arrange
        Dispositivo dispositivo = new Dispositivo();
        Evento eventoMock = new Evento();
        dispositivo.addEventosAsociados(eventoMock);

        // Act
        Set<Evento> eventosAsociados = dispositivo.getEventosAsociados();

        // Assert
        assertEquals(1, eventosAsociados.size());
        assertTrue(eventosAsociados.contains(eventoMock));
    }

    @Test
    void setEventosAsociados() {
        // Arrange
        Dispositivo dispositivo = new Dispositivo();
        Evento eventoMock1 = new Evento();
        Evento eventoMock2 = new Evento();
        Set<Evento> nuevosEventos = new HashSet<>();
        nuevosEventos.add(eventoMock1);
        nuevosEventos.add(eventoMock2);

        // Act
        dispositivo.setEventosAsociados(nuevosEventos);
        Set<Evento> eventosAsociados = dispositivo.getEventosAsociados();

        // Assert
        assertEquals(nuevosEventos, eventosAsociados);
    }

    @Test
    void addAlertasAsociadas() {
        // Arrange
        Dispositivo dispositivo = new Dispositivo();
        Alerta alertaMock = new Alerta();

        // Act
        dispositivo.addAlertasAsociadas(alertaMock);
        Set<Alerta> alertasAsociadas = dispositivo.getAlertasAsociadas();

        // Assert
        assertTrue(alertasAsociadas.contains(alertaMock));
    }

    @Test
    void getAlertasAsociadas() {
        // Arrange
        Dispositivo dispositivo = new Dispositivo();
        Alerta alertaMock = new Alerta();
        dispositivo.addAlertasAsociadas(alertaMock);

        // Act
        Set<Alerta> alertasAsociadas = dispositivo.getAlertasAsociadas();

        // Assert
        assertEquals(1, alertasAsociadas.size());
        assertTrue(alertasAsociadas.contains(alertaMock));
    }

    @Test
    void setAlertasAsociadas() {
        // Arrange
        Dispositivo dispositivo = new Dispositivo();
        Alerta alertaMock1 = new Alerta();
        Alerta alertaMock2 = new Alerta();
        Set<Alerta> nuevasAlertas = new HashSet<>();
        nuevasAlertas.add(alertaMock1);
        nuevasAlertas.add(alertaMock2);

        // Act
        dispositivo.setAlertasAsociadas(nuevasAlertas);
        Set<Alerta> alertasAsociadas = dispositivo.getAlertasAsociadas();

        // Assert
        assertEquals(nuevasAlertas, alertasAsociadas);
    }

    @Test
    void get_id_dispositivo() {
        // Arrange
        Dispositivo dispositivo = new Dispositivo();
        dispositivo.set_id_dispositivo(1);

        // Act
        long idDispositivo = dispositivo.get_id_dispositivo();

        // Assert
        assertEquals(1, idDispositivo);
    }

    @Test
    void set_id_dispositivo() {
        // Arrange
        Dispositivo dispositivo = new Dispositivo();

        // Act
        dispositivo.set_id_dispositivo(1);
        long idDispositivo = dispositivo.get_id_dispositivo();

        // Assert
        assertEquals(1, idDispositivo);
    }

    @Test
    void get_modelo() {
        // Arrange
        Dispositivo dispositivo = new Dispositivo();
        dispositivo.set_modelo("Modelo1");

        // Act
        String modelo = dispositivo.get_modelo();

        // Assert
        assertEquals("Modelo1", modelo);
    }

    @Test
    void set_modelo() {
        // Arrange
        Dispositivo dispositivo = new Dispositivo();

        // Act
        dispositivo.set_modelo("Modelo1");
        String modelo = dispositivo.get_modelo();

        // Assert
        assertEquals("Modelo1", modelo);
    }

    @Test
    void get_marca() {
        // Arrange
        Dispositivo dispositivo = new Dispositivo();
        dispositivo.set_marca("Marca1");

        // Act
        String marca = dispositivo.get_marca();

        // Assert
        assertEquals("Marca1", marca);
    }

    @Test
    void set_marca() {
        // Arrange
        Dispositivo dispositivo = new Dispositivo();

        // Act
        dispositivo.set_marca("Marca1");
        String marca = dispositivo.get_marca();

        // Assert
        assertEquals("Marca1", marca);
    }

    @Test
    void get_numero_telefonico() {
        // Arrange
        Dispositivo dispositivo = new Dispositivo();
        dispositivo.set_numero_telefonico("123456789");

        // Act
        String numeroTelefonico = dispositivo.get_numero_telefonico();

        // Assert
        assertEquals("123456789", numeroTelefonico);

    }

    @Test
    void set_numero_telefonico() {
        // Arrange
        Dispositivo dispositivo = new Dispositivo();

        // Act
        dispositivo.set_numero_telefonico("987654321");
        String numeroTelefonico = dispositivo.get_numero_telefonico();

        // Assert
        assertEquals("987654321", numeroTelefonico);
    }


    @Test
    void get_id_usuario() {
        // Arrange
        Dispositivo dispositivo = new Dispositivo();
        Usuario usuarioMock = new Usuario();
        dispositivo.set_id_usuario(usuarioMock);

        // Act
        Usuario idUsuario = dispositivo.get_id_usuario();

        // Assert
        assertEquals(usuarioMock, idUsuario);
    }

    @Test
    void set_id_usuario() {
        // Arrange
        Dispositivo dispositivo = new Dispositivo();
        Usuario usuarioMock = new Usuario();

        // Act
        dispositivo.set_id_usuario(usuarioMock);
        Usuario idUsuario = dispositivo.get_id_usuario();

        // Assert
        assertEquals(usuarioMock, idUsuario);
    }

    @Test
    void constructor_with_all_parameters() {
        // Arrange
        long idDispositivo = 456;
        String modelo = "Modelo1";
        String marca = "Marca1";
        String numeroTelefonico = "987654321";
        Usuario usuarioMock = new Usuario();

        // Act
        Dispositivo dispositivo = new Dispositivo(idDispositivo, modelo, marca, numeroTelefonico, usuarioMock);

        // Assert
        assertEquals(idDispositivo, dispositivo.get_id_dispositivo());
        assertEquals(modelo, dispositivo.get_modelo());
        assertEquals(marca, dispositivo.get_marca());
        assertEquals(numeroTelefonico, dispositivo.get_numero_telefonico());
        assertEquals(usuarioMock, dispositivo.get_id_usuario());
    }

    @Test
    void constructor_with_id_only() {
        // Arrange
        long idDispositivo = 123;

        // Act
        Dispositivo dispositivo = new Dispositivo(idDispositivo);

        // Assert
        assertEquals(idDispositivo, dispositivo.get_id_dispositivo());
        assertNull(dispositivo.get_modelo());
        assertNull(dispositivo.get_marca());
        assertNull(dispositivo.get_numero_telefonico());
        assertNull(dispositivo.get_id_usuario());
    }

}