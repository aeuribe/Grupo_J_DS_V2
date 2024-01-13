package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.persona.composite.GetAllPersonaCommand;
import com.ucab.cmcapp.logic.commands.persona.composite.ModifyPersonaCommand;
import com.ucab.cmcapp.logic.commands.querella.composite.CreateQuerellaCommand;
import com.ucab.cmcapp.logic.commands.querella.composite.GetAllQuerellaCommand;
import com.ucab.cmcapp.logic.commands.querella.composite.GetQuerellaCommand;
import com.ucab.cmcapp.logic.commands.querella.composite.ModifyQuerellaCommand;
import com.ucab.cmcapp.logic.dtos.PersonaDto;
import com.ucab.cmcapp.logic.dtos.QuerellaDto;
import com.ucab.cmcapp.logic.mappers.PersonaMapper;
import com.ucab.cmcapp.logic.mappers.QuerellaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path( "/querellas" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )

public class QuerellaService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( QuerellaService.class );

    @GET
    @Path( "/{id}" )
    public QuerellaDto getQuerella(@PathParam( "id" ) long QuerellaId )
    {
        Querella entity;
        QuerellaDto response;
        GetQuerellaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in QuerellaService.getQuerella" );
        //endregion

        try
        {
            entity = QuerellaMapper.mapDtoToEntity( QuerellaId ); //no sabe las personas asociadas
            command = CommandFactory.createGetQuerellaCommand( entity );
            command.execute(); //sabe las personas asociadas
            response = QuerellaMapper.mapEntityToDto( command.getReturnParam() ); //NO ESTA LLEGANDO CON LOS DATOS DE PERSONA
            _logger.info( "Response getQuerella: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting Querella {}: {}", e.getMessage(), QuerellaId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving QuerellaService.getQuerella" );
        return response;
    }

    @POST
    public QuerellaDto addQuerella( QuerellaDto QuerellaDto )
    {
        Querella entity;
        QuerellaDto response;
        CreateQuerellaCommand command = null;

        //region Instrumentation DEBUG
        _logger.debug( "Get in QuerellaService.addQuerella" );
        //endregion

        try
        {
            entity = QuerellaMapper.mapDtoToEntity( QuerellaDto );
            command = CommandFactory.createCreateQuerellaCommand( entity );
            command.execute();
            response = QuerellaMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response addQuerella: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} adding Querella: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving QuerellaService.addQuerella" );
        return response;
    }

    @PUT
    public QuerellaDto updateUsuario(QuerellaDto querellaDto )
    {
        Querella entity;
        Querella entityResponse;
        QuerellaDto response;
        ModifyQuerellaCommand command = null;
        GetQuerellaCommand commandResponse = null;

        //region Instrumentation DEBUG
        _logger.debug( "Get in QuerellaService.updateQuerella" );
        //endregion

        try
        {
            entity = QuerellaMapper.mapDtoToEntity( querellaDto );
            command = CommandFactory.createModifyQuerellaCommand( entity ); //en este punto deberian estar definidos los fk
            command.execute(); //no sabe nada de info del fk


            response = getQuerella( querellaDto.getId() );

            //response = QuerellaMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response updateQuerella: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} updating Querella: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving QuerellaService.updateQuerella" );
        return response;
    }

    @GET
    @Path("/")
    public ArrayList<QuerellaDto> getAllQuerella()
    {
        ArrayList<Querella> entitys;
        ArrayList<QuerellaDto> response;
        GetAllQuerellaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in QuerellaService.getAllQuerella" );
        //endregion

        try
        {
            command = CommandFactory.createGetAllQuerellaCommand();
            command.execute();
            entitys = command.getReturnParam();
            response = QuerellaMapper.mapEntityToDtoList( entitys );
            _logger.info( "Response getAllQuerella: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting Querella {}:", e.getMessage());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving QuerellaService.getPersona" );
        return response;
    }
}
