package com.ucab.cmcapp.logic.commands;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Historial_Conexion.atomic.AddHistorial_ConexionCommand;
import com.ucab.cmcapp.logic.commands.Historial_Conexion.atomic.GetHistorial_ConexionByIdCommand;
import com.ucab.cmcapp.logic.commands.Zona_de_Seguridad.atomic.AddZona_de_SeguridadCommand;
import com.ucab.cmcapp.logic.commands.Zona_de_Seguridad.atomic.GetZona_de_SeguridadByIdCommand;
import com.ucab.cmcapp.logic.commands.dispositivo.atomic.AddDispositivoCommand;
import com.ucab.cmcapp.logic.commands.dispositivo.atomic.GetDispositivoByIdCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.AddUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByIdCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.logic.commands.user.composite.CreateUserCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByEmailCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.logic.commands.usuario.composite.CreateUsuarioCommand;

public class CommandFactory
{

    public static GetUserCommand createGetUserCommand(User user)
    {
        return new GetUserCommand(user);
    }

    public static GetUserByEmailCommand createGetUserByEmailCommand(User user)
    {
        return new GetUserByEmailCommand(user);
    }

    public static GetUserByEmailCommand createGetUserByEmailCommand(User user, DBHandler handler)
    {
        return new GetUserByEmailCommand(user, handler);
    }

    public static GetUserByIdCommand createGetUserByIdCommand (DBHandler handler, long userId )
    {
        return new GetUserByIdCommand(handler, userId);
    }


    public static AddUserCommand createAddUserCommand(User user, DBHandler handler)
    {
        return new AddUserCommand(user, handler);
    }

    public static AddUserCommand createAddUserCommand(User user)
    {
        return new AddUserCommand(user);
    }

    public static CreateUserCommand createCreateUserCommand(User user)
    {
        return new CreateUserCommand(user);
    }

    public static CreateUsuarioCommand createCreateUsuarioCommand(Usuario usuario){
        return new CreateUsuarioCommand(usuario);
    }

    public static AddUsuarioCommand createAddUsuarioCommand(Usuario usuario, DBHandler handler)
    {
        return new AddUsuarioCommand(usuario, handler);
    }

    public static GetUsuarioByIdCommand createGetUsuarioByIdCommand (DBHandler handler, long userId )
    {
        return new GetUsuarioByIdCommand(handler, userId);
    }

    //dispositivo
    public static AddDispositivoCommand createAddDispositivoCommand (Dispositivo dispositivo, DBHandler handler){
        return new AddDispositivoCommand(dispositivo, handler);
    }

    public static GetDispositivoByIdCommand createGetDispositivoByIdCommand (DBHandler handler, long dispositivoId){
        return new GetDispositivoByIdCommand(handler, dispositivoId);
    }

    //Historial_Conexion
    public static AddHistorial_ConexionCommand createAddHistorial_ConexionCommand(Historial_Conexion historial, DBHandler handler) {
        return new AddHistorial_ConexionCommand(historial, handler);
    }

    public static GetHistorial_ConexionByIdCommand createGetHistorial_ConexionByIdCommand(DBHandler handler, long id) {
        return new GetHistorial_ConexionByIdCommand(handler, id);
    }

    public static AddZona_de_SeguridadCommand createAddZona_de_SeguridadCommand(Zona_de_Seguridad zona, DBHandler handler) {
        return new AddZona_de_SeguridadCommand(zona, handler);
    }

    public static GetZona_de_SeguridadByIdCommand createGetZona_de_SeguridadByIdCommand(DBHandler handler, long id) {
        return new GetZona_de_SeguridadByIdCommand(handler, id);
    }
}
