package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite.CreateZonaSeguridadCommand;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite.GetZonaSeguridadCommand;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite.ModifyZonaSeguridadCommand;
import com.ucab.cmcapp.logic.dtos.ZonaSeguridadDto;
import com.ucab.cmcapp.logic.mappers.ZonaSeguridadMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/zonas")
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class ZonaSeguridadService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( ZonaSeguridadService.class );
    @GET
    @Path( "/{id}" )
    public ZonaSeguridadDto getZonaSeguridad(@PathParam( "id" ) long zonaId )
    {
        ZonaSeguridad entity;
        ZonaSeguridadDto response;
        GetZonaSeguridadCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadService.getZonaSeguridad" );
        //endregion

        try
        {
            entity = ZonaSeguridadMapper.mapDtoToEntity( zonaId );
            command = CommandFactory.createGetZonaSeguridadCommand( entity );
            command.execute();
            response = ZonaSeguridadMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getZonaSeguridad: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting zona {}: {}", e.getMessage(), zonaId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguridadService.getZonaSeguridad" );
        return response;
    }


    @POST
    public ZonaSeguridadDto addZonaSeguridad( ZonaSeguridadDto zonaSeguridadDto )
    {
        ZonaSeguridad entity;
        ZonaSeguridadDto response;
        CreateZonaSeguridadCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadService.addZonaSeguridad" );
        //endregion

        try
        {
            entity = ZonaSeguridadMapper.mapDtoToEntity( zonaSeguridadDto );
            command = CommandFactory.createCreateZonaSeguridadCommand( entity );
            command.execute();
            response = ZonaSeguridadMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response addZonaSeguridad: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} adding zona: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguridadService.addZonaSeguridad" );
        return response;
    }

    @PUT
    public ZonaSeguridadDto updateZona( ZonaSeguridadDto zonaSeguridadDto )
    {
        ZonaSeguridad entity;
        ZonaSeguridadDto response;
        ModifyZonaSeguridadCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadService.updateZona" );
        //endregion

        try
        {
            entity = ZonaSeguridadMapper.mapDtoToEntity( zonaSeguridadDto );
            command = CommandFactory.createModifyZonaSeguridadCommand( entity );
            command.execute();
            response =  ZonaSeguridadMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response updateZona: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} updating zona: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving ZonaSeguridadService.updateZona" );
        return response;
    }
}
