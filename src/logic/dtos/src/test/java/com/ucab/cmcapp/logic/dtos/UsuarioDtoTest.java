package com.ucab.cmcapp.logic.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDtoTest {

    @Test
    void constructor_withId() {
        long id = 456;
        UsuarioDto usuarioDto = new UsuarioDto(id);
        assertEquals(id, usuarioDto.getId());
    }

    @Test
    void set_password() {
        UsuarioDto usuarioDto = new UsuarioDto();
        String password = "secreto123";
        usuarioDto.set_password(password);
        assertEquals(password, usuarioDto.get_password());
    }

    @Test
    void get_password() {
        UsuarioDto usuarioDto = new UsuarioDto();
        assertNull(usuarioDto.get_password());
    }

    @Test
    void get_correo_electronico() {
        UsuarioDto usuarioDto = new UsuarioDto();
        assertNull(usuarioDto.get_correo_electronico());
    }

    @Test
    void getRol() {
        UsuarioDto usuarioDto = new UsuarioDto();
        assertNull(usuarioDto.getRol());
    }

    @Test
    void get_persona() {
        UsuarioDto usuarioDto = new UsuarioDto();
        assertNull(usuarioDto.get_persona());
    }

    @Test
    void set_correo_electronico() {
        UsuarioDto usuarioDto = new UsuarioDto();
        String correoElectronico = "usuario@dominio.com";
        usuarioDto.set_correo_electronico(correoElectronico);
        assertEquals(correoElectronico, usuarioDto.get_correo_electronico());
    }

    @Test
    void setRol() {
        UsuarioDto usuarioDto = new UsuarioDto();
        String rol = "ADMIN";
        usuarioDto.setRol(rol);
        assertEquals(rol, usuarioDto.getRol());
    }

    @Test
    void set_persona() {
        UsuarioDto usuarioDto = new UsuarioDto();
        PersonaDto persona = new PersonaDto();
        usuarioDto.set_persona(persona);
        assertEquals(persona, usuarioDto.get_persona());
    }
}
