package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.dispositivo.atomic.GetDispositivoByNumberCommand;
import com.ucab.cmcapp.logic.commands.dispositivo.atomic.GetDispositivoByUsuarioCommand;
import com.ucab.cmcapp.logic.commands.dispositivo.composite.CreateDispositivoCommand;
import com.ucab.cmcapp.logic.commands.dispositivo.composite.GetDispositivoCommand;
import com.ucab.cmcapp.logic.commands.dispositivo.composite.ModifyDispositivoCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByEmailCommand;
import com.ucab.cmcapp.logic.dtos.DispositivoDto;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.DispositivoMapper;
import com.ucab.cmcapp.logic.mappers.UsuarioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/dispositivos" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )

public class DispositivoService extends BaseService
{
    private static Logger _logger = LoggerFactory.getLogger( DispositivoService.class );

    @GET
    @Path( "/{id}" )
    public DispositivoDto getDispositivo(@PathParam( "id" ) long dispositivoId )
    {
        Dispositivo entity;
        DispositivoDto response;
        GetDispositivoCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in DispositivoService.getDispositivo" );
        //endregion

        try
        {
            entity = DispositivoMapper.mapDtoToEntity( dispositivoId );
            command = CommandFactory.createGetDispositivoCommand( entity );
            command.execute();
            response = DispositivoMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getDispositivo: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting Dispositivo {}: {}", e.getMessage(), dispositivoId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving DispositivoService.getDispositivo" );
        return response;
    }

    @POST
    public DispositivoDto addDispositivo( DispositivoDto dispositivoDto )
    {
        Dispositivo entity;
        DispositivoDto response;
        CreateDispositivoCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in DispositivoService.addDispositivo" );
        //endregion

        try
        {
            entity = DispositivoMapper.mapDtoToEntity( dispositivoDto );
            command = CommandFactory.createCreateDispositivoCommand( entity );
            command.execute();
            response = DispositivoMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response addDispositivo: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} adding dispositivo: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving DispositivoService.addDispositivo" );
        return response;
    }

    @PUT
    public DispositivoDto updateDispositivo(DispositivoDto dispositivoDto )
    {
        Dispositivo entity;
        DispositivoDto response;
        com.ucab.cmcapp.logic.commands.dispositivo.composite.ModifyDispositivoCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in DispositivoService.updateDispositivo" );
        //endregion

        try
        {
            entity = DispositivoMapper.mapDtoToEntity( dispositivoDto );
            command = CommandFactory.createModifyDispositivoCommand( entity );
            command.execute();
            response = DispositivoMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response updateDispositivo: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} updating dispositivo: {}", e.getMessage(), e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving DispositivoService.updateDispositivo" );
        return response;
    }

    @GET
    @Path( "/{id}/alertas" )
    public DispositivoDto getDispositivoPorAlerta(@PathParam( "id" ) long dispositivoId )
    {
        DispositivoDto response;
        //region Instrumentation DEBUG
        _logger.debug( "Get in DispositivoService.getDispositivoPorAlerta" );
        //endregion

        try
        {
            response = DispositivoMapper.mapEntityAlertaToDto(getDispositivoById(dispositivoId));
            _logger.info( "Response getDispositivo: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting Dispositivo {}: {}", e.getMessage(), dispositivoId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        _logger.debug( "Leaving DispositivoService.getDispositivo" );

        return response;
    }

    public Dispositivo getDispositivoById( long dispositivoId )
    {
        Dispositivo entity;
        Dispositivo response;
        GetDispositivoCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in DispositivoService.getDispositivo" );
        //endregion

        try
        {
            entity = DispositivoMapper.mapDtoToEntity( dispositivoId );
            command = CommandFactory.createGetDispositivoCommand( entity );
            command.execute();
            response = command.getReturnParam();
            _logger.info( "Response getDispositivo: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting Dispositivo {}: {}", e.getMessage(), dispositivoId, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving DispositivoService.getDispositivo" );
        return response;
    }

    @GET
    @Path( "number/{number}" )
    public DispositivoDto getDispositivio(@PathParam( "number" ) String number )
    {
        Dispositivo entity;
        DispositivoDto response;
        GetDispositivoByNumberCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in DispositivoService.getDispositivio" );
        //endregion

        try
        {
            entity = DispositivoMapper.mapDtoToEntityNumber(number);
            command = CommandFactory.createGetDispositivoByNumberCommand( entity );
            command.execute();
            response = DispositivoMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getDispositivio: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting dispositivo {}: {}", e.getMessage(), number, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving DispositivoService.getUsuario" );
        return response;
    }

    @GET
    @Path( "correo/{correo}" )
    public DispositivoDto getDispositivoByUsuario(@PathParam( "correo" ) String correo )
    {
        UsuarioService servicioUsuario = null;
        Dispositivo entity;
        UsuarioDto usuarioDto;
        Usuario entityUsuario;
        DispositivoDto response;
        GetDispositivoByUsuarioCommand command = null;
        //region Instrumentation DEBUG
        _logger.debug( "Get in DispositivoService.getDispositivio" );
        //endregion

        try
        {
            servicioUsuario = new UsuarioService();
            usuarioDto = servicioUsuario.getUsuario(correo);
            entityUsuario = UsuarioMapper.mapDtoToEntity(usuarioDto);

            entity = DispositivoMapper.mapDtoToEntityUsuario(entityUsuario);
            command = CommandFactory.createGetDispositivoByUsuarioCommand( entity );
            command.execute();
            response = DispositivoMapper.mapEntityToDto( command.getReturnParam() );
            _logger.info( "Response getDispositivo: {} ", response );
        }
        catch ( Exception e )
        {
            _logger.error("error {} getting dispositivo {}: {}", e.getMessage(), correo, e.getCause());
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).
                    entity( e ).build() );
        }
        finally
        {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Leaving DispositivoService.getUsuario" );
        return response;
    }
}
