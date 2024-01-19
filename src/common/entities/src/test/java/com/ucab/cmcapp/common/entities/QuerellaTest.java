package com.ucab.cmcapp.common.entities;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class QuerellaTest {
    @Test
    void constructorIdQuerellaTest() {
        // Arrange
        long idQuerella = 1L;

        // Act
        Querella querella = new Querella(idQuerella);

        // Assert
        assertEquals(idQuerella, querella.get_id_querella());
    }


    @Test
    void getPersonasAsociadas() {
        // Arrange
        Querella querella = new Querella();
        Set<Persona> personasAsociadas = new HashSet<>();
        Persona persona1 = new Persona(1L, "Nombre1", "Apellido1", "", "", 'M', new Date(), "victima");
        Persona persona2 = new Persona(2L, "Nombre2", "Apellido2", "", "", 'F', new Date(), "agresor");
        personasAsociadas.add(persona1);
        personasAsociadas.add(persona2);
        querella.setPersonasAsociadas(personasAsociadas);

        // Act
        Set<Persona> result = querella.getPersonasAsociadas();

        // Assert
        assertEquals(personasAsociadas, result);
    }

    @Test
    void addPersonasAsociadas() {
        // Arrange
        Querella querella = new Querella();
        Persona persona = new Persona(1L, "Nombre", "Apellido", "", "", 'M', new Date(), "victima");

        // Act
        querella.addPersonasAsociadas(persona);

        // Assert
        assertTrue(querella.getPersonasAsociadas().contains(persona));
    }

    @Test
    void setPersonasAsociadas() {
        // Arrange
        Querella querella = new Querella();
        Set<Persona> personasAsociadas = new HashSet<>();
        Persona persona1 = new Persona(1L, "Nombre1", "Apellido1", "", "", 'M', new Date(), "victima");
        Persona persona2 = new Persona(2L, "Nombre2", "Apellido2", "", "", 'F', new Date(), "agresor");
        personasAsociadas.add(persona1);
        personasAsociadas.add(persona2);

        // Act
        querella.setPersonasAsociadas(personasAsociadas);

        // Assert
        assertEquals(personasAsociadas, querella.getPersonasAsociadas());
    }

    @Test
    void set_id_querella() {
        // Arrange
        Querella querella = new Querella();
        long idQuerella = 1L;

        // Act
        querella.set_id_querella(idQuerella);

        // Assert
        assertEquals(idQuerella, querella.get_id_querella());
    }

    @Test
    void set_fecha_caso() {
        // Arrange
        Querella querella = new Querella();
        Date fechaCaso = new Date();

        // Act
        querella.set_fecha_caso(fechaCaso);

        // Assert
        assertEquals(fechaCaso, querella.get_fecha_caso());
    }

    @Test
    void set_descripcion() {
        // Arrange
        Querella querella = new Querella();
        String descripcion = "Descripción de la querella";

        // Act
        querella.set_descripcion(descripcion);

        // Assert
        assertEquals(descripcion, querella.get_descripcion());
    }

    @Test
    void set_distancia_alejamiento() {
        // Arrange
        Querella querella = new Querella();
        long distanciaAlejamiento = 10;

        // Act
        querella.set_distancia_alejamiento(distanciaAlejamiento);

        // Assert
        assertEquals(distanciaAlejamiento, querella.get_distancia_alejamiento());
    }

    @Test
    void set_cuenta_atras() {
        // Arrange
        Querella querella = new Querella();
        long cuentaAtras = 5;

        // Act
        querella.set_cuenta_atras(cuentaAtras);

        // Assert
        assertEquals(cuentaAtras, querella.get_cuenta_atras());
    }

    @Test
    void set_inamovilidad() {
        // Arrange
        Querella querella = new Querella();
        long inamovilidad = 3;

        // Act
        querella.set_inamovilidad(inamovilidad);

        // Assert
        assertEquals(inamovilidad, querella.get_inamovilidad());
    }

    @Test
    void get_id_querella() {
        // Arrange
        Querella querella = new Querella();
        long idQuerella = 1L;
        querella.set_id_querella(idQuerella);

        // Act
        long result = querella.get_id_querella();

        // Assert
        assertEquals(idQuerella, result);
    }

    @Test
    void get_fecha_caso() {
        // Arrange
        Querella querella = new Querella();
        Date fechaCaso = new Date();
        querella.set_fecha_caso(fechaCaso);

        // Act
        Date result = querella.get_fecha_caso();

        // Assert
        assertEquals(fechaCaso, result);
    }

    @Test
    void get_descripcion() {
        // Arrange
        Querella querella = new Querella();
        String descripcion = "Descripción de la querella";
        querella.set_descripcion(descripcion);

        // Act
        String result = querella.get_descripcion();

        // Assert
        assertEquals(descripcion, result);
    }

    @Test
    void get_distancia_alejamiento() {
        // Arrange
        Querella querella = new Querella();
        long distanciaAlejamiento = 10;
        querella.set_distancia_alejamiento(distanciaAlejamiento);

        // Act
        long result = querella.get_distancia_alejamiento();

        // Assert
        assertEquals(distanciaAlejamiento, result);
    }

    @Test
    void get_cuenta_atras() {
        // Arrange
        Querella querella = new Querella();
        long cuentaAtras = 5;
        querella.set_cuenta_atras(cuentaAtras);

        // Act
        long result = querella.get_cuenta_atras();

        // Assert
        assertEquals(cuentaAtras, result);
    }

    @Test
    void get_inamovilidad() {
        // Arrange
        Querella querella = new Querella();
        long inamovilidad = 3;
        querella.set_inamovilidad(inamovilidad);

        // Act
        long result = querella.get_inamovilidad();

        // Assert
        assertEquals(inamovilidad, result);
    }

    @Test
    void getVictima() {
        // Arrange
        Querella querella = new Querella();
        Persona victima = new Persona(1L, "Nombre1", "Apellido1", "", "", 'F', new Date(), "victima");
        querella.addPersonasAsociadas(victima);

        // Act
        Persona result = querella.getVictima();

        // Assert
        assertEquals(victima, result);
    }

    @Test
    void getAgresor() {
        // Arrange
        Querella querella = new Querella();
        Persona agresor = new Persona(2L, "Nombre2", "Apellido2", "", "", 'M', new Date(), "agresor");
        querella.addPersonasAsociadas(agresor);

        // Act
        Persona result = querella.getAgresor();

        // Assert
        assertEquals(agresor, result);
    }

    @Test
    void constructorTest() {
        // Arrange
        long idQuerella = 1L;
        Date fechaCaso = new Date();
        String descripcion = "Descripción de la querella";
        long distanciaAlejamiento = 10;
        long cuentaAtras = 5;
        long inamovilidad = 3;

        // Act
        Querella querella = new Querella(idQuerella, fechaCaso, descripcion, distanciaAlejamiento, cuentaAtras, inamovilidad);

        // Assert
        assertEquals(idQuerella, querella.get_id_querella());
        assertEquals(fechaCaso, querella.get_fecha_caso());
        assertEquals(descripcion, querella.get_descripcion());
        assertEquals(distanciaAlejamiento, querella.get_distancia_alejamiento());
        assertEquals(cuentaAtras, querella.get_cuenta_atras());
        assertEquals(inamovilidad, querella.get_inamovilidad());
    }
}
