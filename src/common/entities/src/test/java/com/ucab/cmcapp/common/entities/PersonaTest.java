package com.ucab.cmcapp.common.entities;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {

    @Test
    void constructorPersona() {
        // Arrange
        long idPersona = 1;
        String primerNombre = "John";
        String primerApellido = "Doe";
        String segundoNombre = "Jane";
        String segundoApellido = "Doe";
        char sexo = 'M';
        Date fechaNacimiento = new Date();
        String tipoRol = "Usuario";

        // Act
        Persona persona = new Persona(idPersona, primerNombre, primerApellido, segundoNombre, segundoApellido, sexo, fechaNacimiento, tipoRol);

        // Assert
        assertEquals(idPersona, persona.get_id_persona());
        assertEquals(primerNombre, persona.get_primer_nombre());
        assertEquals(primerApellido, persona.get_primer_apellido());
        assertEquals(segundoNombre, persona.get_segundo_nombre());
        assertEquals(segundoApellido, persona.get_segundo_apellido());
        assertEquals(sexo, persona.get_sexo());
        assertEquals(fechaNacimiento, persona.getFec_nac());
        assertEquals(tipoRol, persona.get_tipoRol());
    }

    @Test
    void get_tipoRol() {
        // Arrange
        Persona persona = new Persona(1, "John", "Doe", "Jane", "Doe", 'M', new Date(), "Usuario");

        // Act
        String tipoRol = persona.get_tipoRol();

        // Assert
        assertEquals("Usuario", tipoRol);
    }

    @Test
    void set_tipoRol() {
        // Arrange
        Persona persona = new Persona();

        // Act
        persona.set_tipoRol("Admin");
        String tipoRol = persona.get_tipoRol();

        // Assert
        assertEquals("Admin", tipoRol);
    }


    @Test
    void set_id_persona() {
        // Arrange
        Persona persona = new Persona();

        // Act
        persona.set_id_persona(1L);

        // Assert (puedes agregar más aserciones según sea necesario)
        assertEquals(1L, persona.get_id_persona());
    }


    @Test
    void get_id_persona() {
        // Arrange
        Persona persona = new Persona(1L);

        // Act
        long idPersona = persona.get_id_persona();

        // Assert
        assertEquals(1, idPersona);
    }

    @Test
    void get_primer_nombre() {
        // Arrange
        Persona persona = new Persona(1, "John", "Doe", "Jane", "Doe", 'M', new Date(), "Usuario");

        // Act
        String primerNombre = persona.get_primer_nombre();

        // Assert
        assertEquals("John", primerNombre);
    }

    @Test
    void get_primer_apellido() {
        // Arrange
        Persona persona = new Persona(1, "John", "Doe", "Jane", "Doe", 'M', new Date(), "Usuario");

        // Act
        String primerApellido = persona.get_primer_apellido();

        // Assert
        assertEquals("Doe", primerApellido);
    }

    @Test
    void get_segundo_nombre() {
        // Arrange
        Persona persona = new Persona(1, "John", "Doe", "Jane", "Doe", 'M', new Date(), "Usuario");

        // Act
        String segundoNombre = persona.get_segundo_nombre();

        // Assert
        assertEquals("Jane", segundoNombre);
    }

    @Test
    void get_segundo_apellido() {
        // Arrange
        Persona persona = new Persona(1, "John", "Doe", "Jane", "Doe", 'M', new Date(), "Usuario");

        // Act
        String segundoApellido = persona.get_segundo_apellido();

        // Assert
        assertEquals("Doe", segundoApellido);
    }

    @Test
    void get_sexo() {
        // Arrange
        Persona persona = new Persona(1, "John", "Doe", "Jane", "Doe", 'M', new Date(), "Usuario");

        // Act
        char sexo = persona.get_sexo();

        // Assert
        assertEquals('M', sexo);
    }

    @Test
    void getFec_nac() {
        // Arrange
        Date fechaNacimiento = new Date();
        Persona persona = new Persona(1, "John", "Doe", "Jane", "Doe", 'M', fechaNacimiento, "Usuario");

        // Act
        Date resultFechaNacimiento = persona.getFec_nac();

        // Assert
        assertEquals(fechaNacimiento, resultFechaNacimiento);
    }

    @Test
    void set_primer_nombre() {
        // Arrange
        Persona persona = new Persona();

        // Act
        persona.set_primer_nombre("Alice");
        String primerNombre = persona.get_primer_nombre();

        // Assert
        assertEquals("Alice", primerNombre);
    }

    @Test
    void set_primer_apellido() {
        // Arrange
        Persona persona = new Persona();

        // Act
        persona.set_primer_apellido("Smith");
        String primerApellido = persona.get_primer_apellido();

        // Assert
        assertEquals("Smith", primerApellido);
    }

    @Test
    void set_segundo_nombre() {
        // Arrange
        Persona persona = new Persona();

        // Act
        persona.set_segundo_nombre("Eve");
        String segundoNombre = persona.get_segundo_nombre();

        // Assert
        assertEquals("Eve", segundoNombre);
    }

    @Test
    void set_segundo_apellido() {
        // Arrange
        Persona persona = new Persona();

        // Act
        persona.set_segundo_apellido("Johnson");
        String segundoApellido = persona.get_segundo_apellido();

        // Assert
        assertEquals("Johnson", segundoApellido);
    }

    @Test
    void set_sexo() {
        // Arrange
        Persona persona = new Persona();

        // Act
        persona.set_sexo('F');
        char sexo = persona.get_sexo();

        // Assert
        assertEquals('F', sexo);
    }

    @Test
    void setFec_nac() {
        // Arrange
        Persona persona = new Persona();
        Date fechaNacimiento = new Date();

        // Act
        persona.setFec_nac(fechaNacimiento);
        Date resultFechaNacimiento = persona.getFec_nac();

        // Assert
        assertEquals(fechaNacimiento, resultFechaNacimiento);
    }


    @Test
    void testSet_id_persona() {
        // Arrange
        Persona persona = new Persona(1L);

        // Act
        long idPersona = persona.get_id_persona();

        // Assert
        assertEquals(1, idPersona);
    }
}
