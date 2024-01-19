package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.alerta.composite.CreateAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.composite.GetAlertaCommand;
import com.ucab.cmcapp.logic.dtos.AlertaDto;
import com.ucab.cmcapp.logic.mappers.AlertaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/alertas")
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class AlertaService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( AlertaService.class );
    @GET
    @Path( "/{id}" )
    public AlertaDto getAlerta(@PathParam( "id" ) long alertaId )
    {
        Alerta entity;
        AlertaDto response;
        GetAlertaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in AlertaService.getUuario" );
        //endregion

        try
        {
            entity = AlertaMapper.mapDtoToEntity( alertaId );
            command = CommandFactory.createGetAlertaCommand( entity );
            command.execute();
            response = AlertaMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response geAlerta: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting alerta {}: {}", e.getMessage(), alertaId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving AlertaService.geAlerta" );
        return response;
    }


    @POST
    public AlertaDto addAlerta( AlertaDto alertaDto )
    {
        Alerta entity;
        AlertaDto response;
        CreateAlertaCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in AlertaService.addAlerta" );
        //endregion

        try
        {
            entity = AlertaMapper.mapDtoToEntity( alertaDto );
            command = CommandFactory.createCreateAlertaCommand( entity );
            command.execute();
            response = AlertaMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response addAlerta: {} ", response );
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

        _logger.debug( "Leaving AlertaService.addAlerta" );
        return response;
    }

}
