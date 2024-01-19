package com.ucab.cmcapp.common.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void constructor_Usuario() {
        // Arrange
        long idUsuario = 1L;
        String correoElectronico = "test@example.com";
        String password = "securePassword";
        String rol = "admin";
        Persona persona = new Persona();

        // Act
        Usuario usuario = new Usuario(idUsuario, correoElectronico, password, rol, persona);

        // Assert
        assertEquals(idUsuario, usuario.get_id_usuario());
        assertEquals(correoElectronico, usuario.get_correo_electronico());
        assertEquals(password, usuario.get_password());
        assertEquals(rol, usuario.get_rol());
        assertEquals(persona, usuario.get_persona());
    }


    @Test
    void get_persona() {
        // Arrange
        Persona persona = new Persona();
        Usuario usuario = new Usuario();

        // Act
        usuario.set_persona(persona);

        // Assert
        assertEquals(persona, usuario.get_persona());
    }

    @Test
    void get_id_usuario() {
        // Arrange
        long idUsuario = 1L;
        Usuario usuario = new Usuario(idUsuario);

        // Act
        long result = usuario.get_id_usuario();

        // Assert
        assertEquals(idUsuario, result);
    }

    @Test
    void get_correo_electronico() {
        // Arrange
        String correoElectronico = "test@example.com";
        Usuario usuario = new Usuario(correoElectronico);

        // Act
        String result = usuario.get_correo_electronico();

        // Assert
        assertEquals(correoElectronico, result);
    }

    @Test
    void get_password() {
        // Arrange
        String password = "securePassword";
        Usuario usuario = new Usuario();
        usuario.set_password(password);

        // Act
        String result = usuario.get_password();

        // Assert
        assertEquals(password, result);
    }

    @Test
    void get_rol() {
        // Arrange
        String rol = "admin";
        Usuario usuario = new Usuario();
        usuario.set_rol(rol);

        // Act
        String result = usuario.get_rol();

        // Assert
        assertEquals(rol, result);
    }

    @Test
    void set_persona() {
        // Arrange
        Persona persona = new Persona();
        Usuario usuario = new Usuario();

        // Act
        usuario.set_persona(persona);

        // Assert
        assertEquals(persona, usuario.get_persona());
    }

    @Test
    void set_id_usuario() {
        // Arrange
        long idUsuario = 1L;
        Usuario usuario = new Usuario();

        // Act
        usuario.set_id_usuario(idUsuario);

        // Assert
        assertEquals(idUsuario, usuario.get_id_usuario());
    }

    @Test
    void set_correo_electronico() {
        // Arrange
        String correoElectronico = "test@example.com";
        Usuario usuario = new Usuario();

        // Act
        usuario.set_correo_electronico(correoElectronico);

        // Assert
        assertEquals(correoElectronico, usuario.get_correo_electronico());
    }

    @Test
    void set_password() {
        // Arrange
        String password = "securePassword";
        Usuario usuario = new Usuario();

        // Act
        usuario.set_password(password);

        // Assert
        assertEquals(password, usuario.get_password());
    }

    @Test
    void set_rol() {
        // Arrange
        String rol = "admin";
        Usuario usuario = new Usuario();

        // Act
        usuario.set_rol(rol);

        // Assert
        assertEquals(rol, usuario.get_rol());
    }
}
