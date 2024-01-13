package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.historial_conexion.composite.CreateHistorial_ConexionCommand;
import com.ucab.cmcapp.logic.commands.historial_conexion.composite.GetHistorial_ConexionCommand;
import com.ucab.cmcapp.logic.dtos.Historial_ConexionDto;
import com.ucab.cmcapp.logic.mappers.Historial_ConexionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/historiales" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )

public class Historial_ConexionService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( Historial_ConexionService.class );

    @GET
    @Path( "/{id}" )
    public Historial_ConexionDto getHistorial_Conexion(@PathParam( "id" ) long Historial_ConexionId )
    {
        Historial_Conexion entity;
        Historial_ConexionDto response;
        GetHistorial_ConexionCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in Historial_ConexionService.getHistorial_Conexion" );
        //endregion

        try
        {
            entity = Historial_ConexionMapper.mapDtoToEntity( Historial_ConexionId );
            command = CommandFactory.createGetHistorial_ConexionCommand( entity );
            command.execute();
            response = Historial_ConexionMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getHistorial_Conexion: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting Historial_Conexion {}: {}", e.getMessage(), Historial_ConexionId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving Historial_ConexionService.getHistorial_Conexion" );
        return response;
    }

    @POST
    public Historial_ConexionDto addHistorial_Conexion( Historial_ConexionDto Historial_ConexionDto )
    {
        Historial_Conexion entity;
        Historial_ConexionDto response;
        CreateHistorial_ConexionCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in Historial_ConexionService.addHistorial_Conexion" );
        //endregion

        try
        {
            entity = Historial_ConexionMapper.mapDtoToEntity( Historial_ConexionDto );
            command = CommandFactory.createCreateHistorial_ConexionCommand( entity );
            command.execute();
            response = Historial_ConexionMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response addHistorial_Conexion: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} adding Historial_Conexion: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving Historial_ConexionService.addHistorial_Conexion" );
        return response;
    }
}
