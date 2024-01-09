package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.querella.composite.CreateQuerellaCommand;
import com.ucab.cmcapp.logic.commands.querella.composite.GetQuerellaCommand;
import com.ucab.cmcapp.logic.dtos.QuerellaDto;
import com.ucab.cmcapp.logic.mappers.QuerellaMapper;
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
            entity = QuerellaMapper.mapDtoToEntity( QuerellaId );
            command = CommandFactory.createGetQuerellaCommand( entity );
            command.execute();
            response = QuerellaMapper.mapEntityToDto( command.getReturnParam() );
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
}
