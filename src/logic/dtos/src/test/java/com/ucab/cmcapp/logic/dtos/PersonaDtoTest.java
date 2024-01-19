package com.ucab.cmcapp.logic.dtos;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PersonaDtoTest {

    @Test
    void get_tipoRol() {
        PersonaDto personaDto = new PersonaDto();
        assertNull(personaDto.get_tipoRol());
    }

    @Test
    void set_tipoRol() {
        PersonaDto personaDto = new PersonaDto();
        String tipoRol = "Admin";
        personaDto.set_tipoRol(tipoRol);
        assertEquals(tipoRol, personaDto.get_tipoRol());
    }

    @Test
    void set_primer_nombre() {
        PersonaDto personaDto = new PersonaDto();
        String primerNombre = "John";
        personaDto.set_primer_nombre(primerNombre);
        assertEquals(primerNombre, personaDto.get_primer_nombre());
    }

    @Test
    void set_primer_apellido() {
        PersonaDto personaDto = new PersonaDto();
        String primerApellido = "Doe";
        personaDto.set_primer_apellido(primerApellido);
        assertEquals(primerApellido, personaDto.get_primer_apellido());
    }

    @Test
    void set_segundo_nombre() {
        PersonaDto personaDto = new PersonaDto();
        String segundoNombre = "Jane";
        personaDto.set_segundo_nombre(segundoNombre);
        assertEquals(segundoNombre, personaDto.get_segundo_nombre());
    }

    @Test
    void set_segundo_apellido() {
        PersonaDto personaDto = new PersonaDto();
        String segundoApellido = "Smith";
        personaDto.set_segundo_apellido(segundoApellido);
        assertEquals(segundoApellido, personaDto.get_segundo_apellido());
    }

    @Test
    void set_sexo() {
        PersonaDto personaDto = new PersonaDto();
        char sexo = 'M';
        personaDto.set_sexo(sexo);
        assertEquals(sexo, personaDto.get_sexo());
    }

    @Test
    void set_fec_nac() {
        PersonaDto personaDto = new PersonaDto();
        Date fechaNacimiento = new Date();
        personaDto.set_fec_nac(fechaNacimiento);
        assertEquals(fechaNacimiento, personaDto.get_fec_nac());
    }

    @Test
    void get_primer_nombre() {
        PersonaDto personaDto = new PersonaDto();
        assertNull(personaDto.get_primer_nombre());
    }

    @Test
    void get_primer_apellido() {
        PersonaDto personaDto = new PersonaDto();
        assertNull(personaDto.get_primer_apellido());
    }

    @Test
    void get_segundo_nombre() {
        PersonaDto personaDto = new PersonaDto();
        assertNull(personaDto.get_segundo_nombre());
    }

    @Test
    void get_segundo_apellido() {
        PersonaDto personaDto = new PersonaDto();
        assertNull(personaDto.get_segundo_apellido());
    }

    @Test
    void get_sexo() {
        PersonaDto personaDto = new PersonaDto();
        assertEquals('\u0000', personaDto.get_sexo());
    }

    @Test
    void get_fec_nac() {
        PersonaDto personaDto = new PersonaDto();
        assertNull(personaDto.get_fec_nac());
    }

    @Test
    void constructor_with_id() {
        long id = 1L;
        PersonaDto personaDto = new PersonaDto(id);
        assertEquals(id, personaDto.getId());
    }
}
