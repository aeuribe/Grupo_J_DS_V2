package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.posicionamiento.composite.CreatePosicionamientoCommand;
import com.ucab.cmcapp.logic.commands.posicionamiento.composite.GetPosicionamientoCommand;
import com.ucab.cmcapp.logic.commands.posicionamiento.composite.ModifyPosicionamientoCommand;
import com.ucab.cmcapp.logic.dtos.PosicionamientoDto;
import com.ucab.cmcapp.logic.mappers.PosicionamientoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

        _logger.debug( "Leaving PosicionamientoService.addPersona" );
        return response;
    }

    @PUT
    public PosicionamientoDto updatePosicionamiento(PosicionamientoDto posicionamientoDto )
    {
        Posicionamiento entity;
        PosicionamientoDto response;
        ModifyPosicionamientoCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionamientoService.updatePosicionamiento" );
        //endregion

        try
        {
            entity = PosicionamientoMapper.mapDtoToEntity( posicionamientoDto );
            command = CommandFactory.createModifyPosicionamientoCommand( entity );
            command.execute();
            response = getPosicionamiento(posicionamientoDto.getId());
            //response = PosicionamientoMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response updatePosicionamiento: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} updating posicionamiento: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving PosicionamientoService.updatePosicionamiento" );
        return response;
    }
}
