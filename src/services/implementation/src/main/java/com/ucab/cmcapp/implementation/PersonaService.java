package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.persona.composite.CreatePersonaCommand;
import com.ucab.cmcapp.logic.commands.persona.composite.GetAllPersonaCommand;
import com.ucab.cmcapp.logic.commands.persona.composite.GetPersonaCommand;
import com.ucab.cmcapp.logic.commands.persona.composite.ModifyPersonaCommand;
import com.ucab.cmcapp.logic.dtos.PersonaDto;
import com.ucab.cmcapp.logic.mappers.PersonaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

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

    @GET
    @Path("/")
    public ArrayList<PersonaDto> getAllPersonas()
    {
        ArrayList<Persona> entitys;
        ArrayList<PersonaDto> response;
        GetAllPersonaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PersonaService.getPersona" );
        //endregion

        try
        {
            command = CommandFactory.createGetAllPersonaCommand();
            command.execute();
            entitys = command.getReturnParam();
            response = PersonaMapper.mapEntityToDtoList( entitys );
            _logger.info( "Response getPersonas: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting Persona {}:", e.getMessage());
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

    @PUT
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
    }
}
