package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.persona.atomic.GetPersonaByIdCommand;
import com.ucab.cmcapp.logic.commands.persona.composite.CreatePersonaCommand;
import com.ucab.cmcapp.logic.commands.persona.composite.GetPersonaCommand;
import com.ucab.cmcapp.logic.commands.user.composite.CreateUserCommand;
import com.ucab.cmcapp.logic.dtos.PersonaDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.mappers.PersonaMapper;
import com.ucab.cmcapp.logic.mappers.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/personas" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )

public class PersonaService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( PersonaService.class );

    @GET
    @Path( "/{id}" )
    public PersonaDto getPersona(@PathParam( "id" ) long personaId )
    {
        Persona entity;
        PersonaDto response;
        GetPersonaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PersonaService.getPersona" );
        //endregion

        try
        {
            entity = PersonaMapper.mapDtoToEntity( personaId );
            command = CommandFactory.createGetPersonaCommand( entity );
            command.execute();
            response = PersonaMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getPersona: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting Persona {}: {}", e.getMessage(), personaId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PersonaService.getPersona" );
        return response;
    }

    @POST
    public PersonaDto addPersona( PersonaDto personaDto )
    {
        Persona entity;
        PersonaDto response;
        CreatePersonaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PersonaService.addPersona" );
        //endregion

        try
        {
            entity = PersonaMapper.mapDtoToEntity( personaDto );
            command = CommandFactory.createCreatePersonaCommand( entity );
            command.execute();
            response = PersonaMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response addPersona: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} adding persona: {}", e.getMessage(), e.getCause());
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
}
