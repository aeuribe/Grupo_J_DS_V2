package com.ucab.cmcapp.logic.commands;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.atomic.AddZonaSeguridadCommand;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.atomic.GetZonaSeguridadByIdCommand;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.atomic.UpdateZonaSeguridadCommand;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite.CreateZonaSeguridadCommand;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite.GetZonaSeguridadCommand;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite.ModifyZonaSeguridadCommand;
import com.ucab.cmcapp.logic.commands.alerta.atomic.AddAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.atomic.GetAlertaByIdCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.CreateAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.GetAlertaCommand;
import com.ucab.cmcapp.logic.commands.dispositivo.atomic.*;
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
import com.ucab.cmcapp.logic.commands.posicionamiento.atomic.UpdatePosicionamientoCommand;
import com.ucab.cmcapp.logic.commands.posicionamiento.composite.CreatePosicionamientoCommand;
import com.ucab.cmcapp.logic.commands.posicionamiento.composite.GetPosicionamientoCommand;
import com.ucab.cmcapp.logic.commands.posicionamiento.composite.ModifyPosicionamientoCommand;
import com.ucab.cmcapp.logic.commands.querella.atomic.AddQuerellaCommand;
import com.ucab.cmcapp.logic.commands.querella.atomic.GetQuerellaByIdCommand;
import com.ucab.cmcapp.logic.commands.querella.atomic.GetQuerellaByListCommand;
import com.ucab.cmcapp.logic.commands.querella.atomic.UpdateQuerellaCommand;
import com.ucab.cmcapp.logic.commands.querella.composite.CreateQuerellaCommand;
import com.ucab.cmcapp.logic.commands.querella.composite.GetAllQuerellaCommand;
import com.ucab.cmcapp.logic.commands.querella.composite.GetQuerellaCommand;
import com.ucab.cmcapp.logic.commands.querella.composite.ModifyQuerellaCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.*;
import com.ucab.cmcapp.logic.commands.usuario.composite.AuthenticateUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.GetUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.ModifyUsuarioCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.logic.commands.dispositivo.composite.ModifyDispositivoCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.CreateUsuarioCommand;

public class CommandFactory {
    //historial
    public static GetHistorial_ConexionByIdCommand createGetHistorial_ConexionByIdCommand(DBHandler handler, long id)
    {
        return new GetHistorial_ConexionByIdCommand(handler, id);
    }

    public static GetHistorial_ConexionCommand createGetHistorial_ConexionCommand(Historial_Conexion historial_conexion){
        return new GetHistorial_ConexionCommand(historial_conexion);
    }
    //usuario

    public static AuthenticateUsuarioCommand createAuthenticateUsuarioCommand ( Usuario usuario){
        return new AuthenticateUsuarioCommand(usuario);
    }
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

    public static GetUsuarioByIdPersonaCommand createGetUsuarioByIdPersonaCommand (Usuario usuario){
        return new GetUsuarioByIdPersonaCommand(usuario);
    }

public static GetUsuarioByIdPersonaCommand createGetUsuarioByIdPersonaCommand (DBHandler handler, Usuario usuario){
        return new GetUsuarioByIdPersonaCommand(usuario,handler);
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


    //zona de seguridad

    public static ModifyZonaSeguridadCommand createModifyZonaSeguridadCommand(ZonaSeguridad zona) {
        return new ModifyZonaSeguridadCommand(zona);
    }
    public static UpdateZonaSeguridadCommand createUpdateZonaSeguridadCommand(ZonaSeguridad zona, DBHandler handler) {
        return new UpdateZonaSeguridadCommand(zona, handler);
    }
    public static AddZonaSeguridadCommand createAddZonaSeguridadCommand(ZonaSeguridad zona, DBHandler handler) {
        return new AddZonaSeguridadCommand(zona, handler);
    }

    public static GetZonaSeguridadByIdCommand createGetZonaSeguridadByIdCommand(DBHandler handler, long id) {
        return new GetZonaSeguridadByIdCommand(handler, id);
    }

    public static GetZonaSeguridadCommand createGetZonaSeguridadCommand(ZonaSeguridad zona) {
        return new GetZonaSeguridadCommand(zona);
    }

    public static CreateZonaSeguridadCommand createCreateZonaSeguridadCommand(ZonaSeguridad zonaSeguridad) {
        return new CreateZonaSeguridadCommand(zonaSeguridad);
    }

    //posicionamiento

    public static ModifyPosicionamientoCommand createModifyPosicionamientoCommand(Posicionamiento posicionamiento) {
        return new ModifyPosicionamientoCommand(posicionamiento);
    }
    public static UpdatePosicionamientoCommand createUpdatePosicionamientoCommand(Posicionamiento posicionamiento, DBHandler handler) {
        return new UpdatePosicionamientoCommand(posicionamiento, handler);
    }
    public static AddPosicionamientoCommand createAddPosicionamientoCommand(Posicionamiento posicionamiento, DBHandler handler) {
        return new AddPosicionamientoCommand(posicionamiento, handler);
    }

    public static CreatePosicionamientoCommand createCreatePosicionamientoCommand(Posicionamiento posicionamiento) {
        return new CreatePosicionamientoCommand(posicionamiento);
    }

    public static GetPosicionamientoCommand createGetPosicionamientoCommand(Posicionamiento posicionamiento) {
        return new GetPosicionamientoCommand(posicionamiento);
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

    public static GetAlertaCommand createGetAlertaCommand(Alerta alerta) {
        return new GetAlertaCommand(alerta);
    }

    public static CreateAlertaCommand createCreateAlertaCommand(Alerta alerta) {
        return new CreateAlertaCommand(alerta);
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

    public static GetDispositivoByUsuarioCommand createGetDispositivoByUsuarioCommand(Dispositivo dispositivo, DBHandler handler){
        return new GetDispositivoByUsuarioCommand(dispositivo, handler);
    }

    public static GetDispositivoByUsuarioCommand createGetDispositivoByUsuarioCommand(Dispositivo dispositivo){
        return new GetDispositivoByUsuarioCommand(dispositivo);
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

    public static GetDispositivoByNumberCommand createGetDispositivoByNumberCommand(Dispositivo dispositivo, DBHandler handler) {
        return new GetDispositivoByNumberCommand(dispositivo, handler);
    }

    public static GetDispositivoByNumberCommand createGetDispositivoByNumberCommand(Dispositivo dispositivo) {
        return new GetDispositivoByNumberCommand(dispositivo);
    }


}

