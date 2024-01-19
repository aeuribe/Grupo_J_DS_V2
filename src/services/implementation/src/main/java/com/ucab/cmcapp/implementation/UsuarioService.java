package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByEmailCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByIdPersonaCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.CreateUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.GetUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.ModifyUsuarioCommand;
import com.ucab.cmcapp.logic.dtos.PersonaDto;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.PersonaMapper;
import com.ucab.cmcapp.logic.mappers.UsuarioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ucab.cmcapp.implementation.PersonaService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/usuario")
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class UsuarioService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( UsuarioService.class );
    @GET
    @Path( "/{id}" )
    public UsuarioDto getUsuario(@PathParam( "id" ) long userId )
    {
        Usuario entity;
        UsuarioDto response;
        GetUsuarioCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioService.getUuario" );
        //endregion

        try
        {
            entity = UsuarioMapper.mapDtoToEntity( userId );
            command = CommandFactory.createGetUsuarioCommand( entity );
            command.execute();
            response = UsuarioMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getUsuario: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting usuario {}: {}", e.getMessage(), userId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UsuarioService.getUsuario" );
        return response;
    }

    @GET
    @Path( "persona/{id_persona}" )
    public UsuarioDto getUsuarioByPersona(@PathParam( "id_persona" ) long id_persona )
    {
        Persona entityPersona;
        PersonaService servicioPersona = null;
        PersonaDto personaDto;
        Usuario entity;
        UsuarioDto response;
        GetUsuarioByIdPersonaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioService.getUsuario" );
        //endregion

        try
        {
            servicioPersona = new PersonaService();
            personaDto = servicioPersona.getPersona(id_persona);
            entityPersona = PersonaMapper.mapDtoToEntity(personaDto);
            entity = UsuarioMapper.mapDtoToEntityPersona( entityPersona );
            command = CommandFactory.createGetUsuarioByIdPersonaCommand( entity );
            command.execute();
            response = UsuarioMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getUsuario: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting usuario {}: {}", e.getMessage(), id_persona, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UsuarioService.getUsuario" );
        return response;
    }

    @Path( "email/{email}" )
    public UsuarioDto getUsuario(@PathParam( "email" ) String email )
    {
        Usuario entity;
        UsuarioDto response;
        GetUsuarioByEmailCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioService.getUsuario" );
        //endregion

        try
        {
            entity = UsuarioMapper.mapDtoToEntityEmail( email );
            command = CommandFactory.createGetUsuarioByEmailCommand( entity );
            command.execute();
            response = UsuarioMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getUsuario: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting usuario {}: {}", e.getMessage(), email, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UsuarioService.getUsuario" );
        return response;
    }

    @POST
    public UsuarioDto addUsuario( UsuarioDto usuarioDto )
    {
        Usuario entity;
        UsuarioDto response;
        CreateUsuarioCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioService.addUsuario" );
        //endregion

        try
        {
            entity = UsuarioMapper.mapDtoToEntity( usuarioDto );
            command = CommandFactory.createCreateUsuarioCommand( entity );
            command.execute();
            response = UsuarioMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response addUsuario: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} adding usuario: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UsuarioService.addUsuario" );
        return response;
    }

    @PUT
    public UsuarioDto updateUsuario( UsuarioDto usuarioDto )
    {
        Usuario entity;
        UsuarioDto response;
        ModifyUsuarioCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioService.updateUsuario" );
        //endregion

        try
        {
            entity = UsuarioMapper.mapDtoToEntity( usuarioDto );
            command = CommandFactory.createModifyUsuarioCommand( entity );
            command.execute();
            response = UsuarioMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response updateUsuario: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} updating usuario: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving UsuarioService.updateUsuario" );
        return response;
    }
}
