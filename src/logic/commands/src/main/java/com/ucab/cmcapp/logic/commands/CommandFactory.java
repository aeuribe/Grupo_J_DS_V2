package com.ucab.cmcapp.logic.commands;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Zona_de_Seguridad.atomic.AddZona_de_SeguridadCommand;
import com.ucab.cmcapp.logic.commands.Zona_de_Seguridad.atomic.GetZona_de_SeguridadByIdCommand;
import com.ucab.cmcapp.logic.commands.alerta.atomic.AddAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.atomic.GetAlertaByIdCommand;
import com.ucab.cmcapp.logic.commands.dispositivo.atomic.AddDispositivoCommand;
import com.ucab.cmcapp.logic.commands.dispositivo.atomic.GetDispositivoByIdCommand;
import com.ucab.cmcapp.logic.commands.dispositivo.atomic.UpdateDispositivoCommand;
import com.ucab.cmcapp.logic.commands.dispositivo.composite.CreateDispositivoCommand;
import com.ucab.cmcapp.logic.commands.dispositivo.composite.GetDispositivoCommand;
import com.ucab.cmcapp.logic.commands.evento.atomic.AddEventoCommand;
import com.ucab.cmcapp.logic.commands.evento.atomic.GetEventoByIdCommand;
import com.ucab.cmcapp.logic.commands.evento.atomic.UpdateEventoCommand;
import com.ucab.cmcapp.logic.commands.evento.composite.CreateEventoCommand;
import com.ucab.cmcapp.logic.commands.evento.composite.GetEventoCommand;
import com.ucab.cmcapp.logic.commands.evento.composite.ModifyEventoCommand;
import com.ucab.cmcapp.logic.commands.historial_conexion.atomic.AddHistorial_ConexionCommand;
import com.ucab.cmcapp.logic.commands.historial_conexion.atomic.GetHistorial_ConexionByIdCommand;
import com.ucab.cmcapp.logic.commands.historial_conexion.composite.CreateHistorial_ConexionCommand;
import com.ucab.cmcapp.logic.commands.historial_conexion.composite.GetHistorial_ConexionCommand;
import com.ucab.cmcapp.logic.commands.persona.atomic.AddPersonaCommand;
import com.ucab.cmcapp.logic.commands.persona.atomic.GetPersonaByIdCommand;
import com.ucab.cmcapp.logic.commands.persona.atomic.GetPersonaByListCommand;
import com.ucab.cmcapp.logic.commands.persona.atomic.UpdatePersonaCommand;
import com.ucab.cmcapp.logic.commands.persona.composite.CreatePersonaCommand;
import com.ucab.cmcapp.logic.commands.persona.composite.GetAllPersonaCommand;
import com.ucab.cmcapp.logic.commands.persona.composite.GetPersonaCommand;
import com.ucab.cmcapp.logic.commands.persona.composite.ModifyPersonaCommand;
import com.ucab.cmcapp.logic.commands.posicionamiento.atomic.AddPosicionamientoCommand;
import com.ucab.cmcapp.logic.commands.posicionamiento.atomic.GetPosicionamientoByIdCommand;
import com.ucab.cmcapp.logic.commands.querella.atomic.AddQuerellaCommand;
import com.ucab.cmcapp.logic.commands.querella.atomic.GetQuerellaByIdCommand;
import com.ucab.cmcapp.logic.commands.querella.atomic.GetQuerellaByListCommand;
import com.ucab.cmcapp.logic.commands.querella.atomic.UpdateQuerellaCommand;
import com.ucab.cmcapp.logic.commands.querella.composite.CreateQuerellaCommand;
import com.ucab.cmcapp.logic.commands.querella.composite.GetAllQuerellaCommand;
import com.ucab.cmcapp.logic.commands.querella.composite.GetQuerellaCommand;
import com.ucab.cmcapp.logic.commands.querella.composite.ModifyQuerellaCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.AddUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByEmailCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByIdCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.logic.commands.user.composite.CreateUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByEmailCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.UpdateUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.GetUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.ModifyUsuarioCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.logic.commands.dispositivo.composite.ModifyDispositivoCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.CreateUsuarioCommand;

import java.util.logging.Handler;

public class CommandFactory {

    public static GetUserCommand createGetUserCommand(User user) {
        return new GetUserCommand(user);
    }

    public static GetUserByEmailCommand createGetUserByEmailCommand(User user) {
        return new GetUserByEmailCommand(user);
    }

    public static GetUserByEmailCommand createGetUserByEmailCommand(User user, DBHandler handler) {
        return new GetUserByEmailCommand(user, handler);
    }

    public static GetUserByIdCommand createGetUserByIdCommand(DBHandler handler, long userId) {
        return new GetUserByIdCommand(handler, userId);
    }


    public static AddUserCommand createAddUserCommand(User user, DBHandler handler) {
        return new AddUserCommand(user, handler);
    }

    public static AddUserCommand createAddUserCommand(User user) {
        return new AddUserCommand(user);
    }

    public static CreateUserCommand createCreateUserCommand(User user) {
        return new CreateUserCommand(user);
    }

    //historial
    public static GetHistorial_ConexionByIdCommand createGetHistorial_ConexionByIdCommand(DBHandler handler, long id)
    {
        return new GetHistorial_ConexionByIdCommand(handler, id);
    }

    public static GetHistorial_ConexionCommand createGetHistorial_ConexionCommand(Historial_Conexion historial_conexion){
        return new GetHistorial_ConexionCommand(historial_conexion);
    }
    //usuario

    public static ModifyUsuarioCommand createModifyUsuarioCommand(Usuario usuario) {
        return new ModifyUsuarioCommand(usuario);
    }

    public static CreateUsuarioCommand createCreateUsuarioCommand(Usuario usuario) {
        return new CreateUsuarioCommand(usuario);
    }

    public static GetUsuarioCommand createGetUsuarioCommand(Usuario usuario) {
        return new GetUsuarioCommand(usuario);
    }

    public static GetUsuarioByEmailCommand createGetUsuarioByEmailCommand(Usuario usuario) {
        return new GetUsuarioByEmailCommand(usuario);
    }

    public static GetUsuarioByEmailCommand createGetUsuarioByEmailCommand(Usuario usuario, DBHandler handler) {
        return new GetUsuarioByEmailCommand(usuario, handler);
    }

    public static AddUsuarioCommand createAddUsuarioCommand(Usuario usuario, DBHandler handler) {
        return new AddUsuarioCommand(usuario, handler);
    }

    public static GetUsuarioByIdCommand createGetUsuarioByIdCommand(DBHandler handler, long userId) {
        return new GetUsuarioByIdCommand(handler, userId);
    }

    public static UpdateUsuarioCommand createUpdateUsuarioCommand(Usuario usuario, DBHandler handler) {
        return new UpdateUsuarioCommand(usuario, handler);
    }

    public static UpdateUsuarioCommand createUpdateUsuarioCommand(Usuario usuario) {
        return new UpdateUsuarioCommand(usuario);
    }

    //dispositivo
    public static AddDispositivoCommand createAddDispositivoCommand(Dispositivo dispositivo, DBHandler handler) {
        return new AddDispositivoCommand(dispositivo, handler);
    }

    public static GetDispositivoByIdCommand createGetDispositivoByIdCommand(DBHandler handler, long dispositivoId) {
        return new GetDispositivoByIdCommand(handler, dispositivoId);
    }

    //Historial_Conexion
    public static AddHistorial_ConexionCommand createAddHistorial_ConexionCommand(Historial_Conexion historial, DBHandler handler) {
        return new AddHistorial_ConexionCommand(historial, handler);
    }

    public static CreateHistorial_ConexionCommand createCreateHistorial_ConexionCommand(Historial_Conexion historial) {
        return new CreateHistorial_ConexionCommand(historial);
    }

    public static AddZona_de_SeguridadCommand createAddZona_de_SeguridadCommand(Zona_de_Seguridad zona, DBHandler handler) {
        return new AddZona_de_SeguridadCommand(zona, handler);
    }

    public static GetZona_de_SeguridadByIdCommand createGetZona_de_SeguridadByIdCommand(DBHandler handler, long id) {
        return new GetZona_de_SeguridadByIdCommand(handler, id);
    }

    //posicionamiento
    public static AddPosicionamientoCommand createAddPosicionamientoCommand(Posicionamiento posicionamiento, DBHandler handler) {
        return new AddPosicionamientoCommand(posicionamiento, handler);
    }

    public static GetPosicionamientoByIdCommand createGetPosicionamientoByIdCommand(DBHandler handler, long id) {
        return new GetPosicionamientoByIdCommand(handler, id);
    }

    //evento
    public static AddEventoCommand createAddEventoCommand(Evento evento, DBHandler handler) {
        return new AddEventoCommand(evento, handler);
    }

    public static GetEventoByIdCommand createGetEventoByIdCommand(DBHandler handler, long id) {
        return new GetEventoByIdCommand(handler, id);
    }

    //alerta
    public static AddAlertaCommand createAddAlertaCommand(Alerta alerta, DBHandler handler) {
        return new AddAlertaCommand(alerta, handler);
    }

    public static GetAlertaByIdCommand createGetAlertaByIdCommand(DBHandler handler, long id) {
        return new GetAlertaByIdCommand(handler, id);
    }

    //persona

    public static GetAllPersonaCommand createGetAllPersonaCommand() {
        return new GetAllPersonaCommand();
    }

    public static GetPersonaByListCommand createGetPersonaByListCommand(DBHandler handler) {
        return new GetPersonaByListCommand(handler);
    }

    public static GetPersonaCommand createGetPersonaCommand(Persona persona) {
        return new GetPersonaCommand(persona);
    }

    public static CreatePersonaCommand createCreatePersonaCommand(Persona persona) {
        return new CreatePersonaCommand(persona);
    }

    public static AddPersonaCommand createAddPersonaCommand(Persona persona, DBHandler handler) {
        return new AddPersonaCommand(persona, handler);
    }

    public static AddPersonaCommand createAddUserCommand(Persona persona) {
        return new AddPersonaCommand(persona);
    }

    public static GetPersonaByIdCommand createGetPersonaByIdCommand(DBHandler handler, long id) {
        return new GetPersonaByIdCommand(handler, id);
    }

    public static UpdatePersonaCommand createUpdatePersonaCommand(Persona persona, DBHandler handler) {
        return new UpdatePersonaCommand(persona, handler);
    }

    public static UpdatePersonaCommand createUpdatePersonaCommand(Persona persona) {
        return new UpdatePersonaCommand(persona);
    }

    public static ModifyPersonaCommand createModifyPersonaCommand(Persona persona) {
        return new ModifyPersonaCommand(persona);
    }

    //querella
    public static GetQuerellaByListCommand createGetQuerellaByListCommand(DBHandler handler) {
        return new GetQuerellaByListCommand(handler);
    }

    public static GetAllQuerellaCommand createGetAllQuerellaCommand() {
        return new GetAllQuerellaCommand();
    }

    public static AddQuerellaCommand createAddQuerellaCommand(Querella persona, DBHandler handler) {
        return new AddQuerellaCommand(persona, handler);
    }

    public static GetQuerellaByIdCommand createGetQuerellaByIdCommand(DBHandler handler, long id) {
        return new GetQuerellaByIdCommand(handler, id);
    }

    public static GetQuerellaCommand createGetQuerellaCommand(Querella querella) {
        return new GetQuerellaCommand(querella);
    }

    public static CreateQuerellaCommand createCreateQuerellaCommand(Querella querella) {
        return new CreateQuerellaCommand(querella);
    }

    public static UpdateQuerellaCommand createUpdateQuerellaCommand(Querella querella, DBHandler handler) {
        return new UpdateQuerellaCommand(querella, handler);
    }

    public static UpdateQuerellaCommand createUpdateUsuarioCommand(Querella querella) {
        return new UpdateQuerellaCommand(querella);
    }
    public static ModifyQuerellaCommand createModifyQuerellaCommand(Querella querella) {
        return new ModifyQuerellaCommand(querella);
    }

    //Evento

    public static GetEventoCommand createGetEventoCommand(Evento evento) {
        return new GetEventoCommand(evento);
    }

    public static CreateEventoCommand createCreateEventoCommand(Evento evento) {
        return new CreateEventoCommand(evento);
    }

    public static UpdateEventoCommand createUpdateEventoCommand(Evento evento, DBHandler handler) {
        return new UpdateEventoCommand(evento, handler);
    }

    public static UpdateEventoCommand createUpdateEventoCommand(Evento evento) {
        return new UpdateEventoCommand(evento);
    }

    public static ModifyEventoCommand createModifyEventoCommand(Evento evento) {

        return new ModifyEventoCommand(evento);
    }


    //Dispositivo
    public static GetDispositivoCommand createGetDispositivoCommand(Dispositivo dispositivo) {
        return new GetDispositivoCommand(dispositivo);
    }

    public static CreateDispositivoCommand createCreateDispositivoCommand(Dispositivo dispositivo) {
        return new CreateDispositivoCommand(dispositivo);
    }

    public static UpdateDispositivoCommand createUpdateDispositivoCommand(Dispositivo dispositivo, DBHandler handler) {
        return new UpdateDispositivoCommand(dispositivo, handler);
    }

    public static UpdateDispositivoCommand createUpdateDispositivoCommand(Dispositivo dispositivo) {
        return new UpdateDispositivoCommand(dispositivo);
    }

    public static ModifyDispositivoCommand createModifyDispositivoCommand(Dispositivo dispositivo) {

        return new ModifyDispositivoCommand(dispositivo);
    }
}

