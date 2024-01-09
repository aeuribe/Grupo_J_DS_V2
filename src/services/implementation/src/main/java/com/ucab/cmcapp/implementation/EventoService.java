package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.evento.composite.CreateEventoCommand;
import com.ucab.cmcapp.logic.commands.evento.composite.GetEventoCommand;
import com.ucab.cmcapp.logic.commands.evento.composite.ModifyEventoCommand;
import com.ucab.cmcapp.logic.dtos.EventoDto;
import com.ucab.cmcapp.logic.mappers.EventoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/eventos" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )

public class EventoService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( EventoService.class );

    @GET
    @Path( "/{id}" )
    public EventoDto getEvento(@PathParam( "id" ) long EventoId )
    {
        Evento entity;
        EventoDto response;
        GetEventoCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in EventoService.getEvento" );
        //endregion

        try
        {
            entity = EventoMapper.mapDtoToEntity( EventoId );
            command = CommandFactory.createGetEventoCommand( entity );
            command.execute();
            response = EventoMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getEvento: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting Evento {}: {}", e.getMessage(), EventoId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving EventoService.getEvento" );
        return response;
    }

    @POST
    public EventoDto addEvento( EventoDto EventoDto )
    {
        Evento entity;
        EventoDto response;
        CreateEventoCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in EventoService.addEvento" );
        //endregion

        try
        {
            entity = EventoMapper.mapDtoToEntity( EventoDto );
            command = CommandFactory.createCreateEventoCommand( entity );
            command.execute();
            response = EventoMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response addEvento: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} adding Evento: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving EventoService.addEvento" );
        return response;
    }

    @PUT
    public EventoDto updateEvento(EventoDto eventoDto )
    {
        Evento entity;
        EventoDto response;
        ModifyEventoCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in EventoService.updateEvento" );
        //endregion

        try
        {
            entity = EventoMapper.mapDtoToEntity( eventoDto );
            command = CommandFactory.createModifyEventoCommand( entity );
            command.execute();
            response = EventoMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response updateEvento: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} updating Evento: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving EventoService.updateEvento" );
        return response;
    }

}
