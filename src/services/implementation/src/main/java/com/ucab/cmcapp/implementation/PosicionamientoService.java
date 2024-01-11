package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.persona.atomic.GetPersonaByIdCommand;
import com.ucab.cmcapp.logic.commands.persona.composite.CreatePersonaCommand;
import com.ucab.cmcapp.logic.commands.persona.composite.GetAllPersonaCommand;
import com.ucab.cmcapp.logic.commands.persona.composite.GetPersonaCommand;
import com.ucab.cmcapp.logic.commands.persona.composite.ModifyPersonaCommand;
import com.ucab.cmcapp.logic.commands.posicionamiento.composite.CreatePosicionamientoCommand;
import com.ucab.cmcapp.logic.commands.posicionamiento.composite.GetPosicionamientoCommand;
import com.ucab.cmcapp.logic.commands.user.composite.CreateUserCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.ModifyUsuarioCommand;
import com.ucab.cmcapp.logic.dtos.PersonaDto;
import com.ucab.cmcapp.logic.dtos.PosicionamientoDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.PersonaMapper;
import com.ucab.cmcapp.logic.mappers.PosicionamientoMapper;
import com.ucab.cmcapp.logic.mappers.UserMapper;
import com.ucab.cmcapp.logic.mappers.UsuarioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path( "/posicionamientos" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )

public class PosicionamientoService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( PosicionamientoService.class );

    @GET
    @Path( "/{id}" )
    public PosicionamientoDto getPosicionamiento(@PathParam( "id" ) long posId )
    {
        Posicionamiento entity;
        PosicionamientoDto response;
        GetPosicionamientoCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionamientoService.getPosicionamiento" );
        //endregion

        try
        {
            entity = PosicionamientoMapper.mapDtoToEntity( posId );
            command = CommandFactory.createGetPosicionamientoCommand( entity );
            command.execute();
            response = PosicionamientoMapper.mapEntityToDto( command. getReturnParam() );
            _logger.info( "Response getPosicionamiento: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting Posicionamiento {}: {}", e.getMessage(), posId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PosicionamientoService.getPosicionamiento" );
        return response;
    }

    @POST
    public PosicionamientoDto addPosicionamiento( PosicionamientoDto posicionamientoDto )
    {
        Posicionamiento entity;
        PosicionamientoDto response;
        CreatePosicionamientoCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionamientoService.addPosicionamiento" );
        //endregion

        try
        {
            entity = PosicionamientoMapper.mapDtoToEntity( posicionamientoDto );
            command = CommandFactory.createCreatePosicionamientoCommand( entity );
            command.execute();
            response = PosicionamientoMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response addPosicionamiento: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} adding posicionamiento: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PersonaService.addPersona" );
        return response;
    }

/*    @PUT
    public PersonaDto updatePersona(PersonaDto personaDto )
    {
        Persona entity;
        PersonaDto response;
        ModifyPersonaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PersonaService.updatePersona" );
        //endregion

        try
        {
            entity = PersonaMapper.mapDtoToEntity( personaDto );
            command = CommandFactory.createModifyPersonaCommand( entity );
            command.execute();
            response = PersonaMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response updatePersona: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} updating persona: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PersonaService.updatePersona" );
        return response;
    }*/
}
