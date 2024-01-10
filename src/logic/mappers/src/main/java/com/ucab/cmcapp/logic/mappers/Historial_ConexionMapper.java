package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Historial_Conexion;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.dtos.Historial_ConexionDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Objects;

public class Historial_ConexionMapper extends BaseMapper
{
    private static Logger _logger = LoggerFactory.getLogger( Historial_ConexionDto.class );

    public static Historial_Conexion mapDtoToEntity(Historial_ConexionDto dto ) throws ParseException
    {
        Historial_Conexion entity = EntityFactory.createHistorial_Conexion();

        //region Instrumentation DEBUG
        _logger.debug( "Get in Historial_ConexionMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.set_id_historial( dto.getId());
        entity.set_estado(dto.get_estado());
        entity.set_fecha(dto.get_fecha());
        entity.set_hora_conexion(dto.get_hora_conexion());
        entity.set_hora_desconexion(dto.get_hora_desconexion());


        if ( Objects.nonNull( dto.get_id_dispositivo() ) )
        {
            entity.set_id_dispositivo( DispositivoMapper.mapDtoToEntity( dto.get_id_dispositivo() ) );
        }

        //region Instrumentation DEBUG
        _logger.debug( "Leaving Historial_ConexionMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static Historial_ConexionDto mapEntityToDto(Historial_Conexion entity )
    {
        final Historial_ConexionDto dto = new Historial_ConexionDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in Historial_ConexionMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.setId( entity.get_id_historial() );
        dto.set_estado( entity.get_estado());
        dto.set_fecha( entity.get_fecha() );
        dto.set_hora_conexion( entity.get_hora_conexion());
        dto.set_hora_desconexion(entity.get_hora_desconexion());

        if(Objects.nonNull(entity.get_id_dispositivo()))
            dto.set_id_dispositivo( DispositivoMapper.mapEntityToDto( entity.get_id_dispositivo() ) );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving Historial_ConexionMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }

    public static Historial_Conexion mapDtoToEntity( long id )
    {
        Historial_Conexion entity = EntityFactory.createHistorial_Conexion( id );

        //region Instrumentation DEBUG
        _logger.debug( "Get in Historial_ConexionMapper.mapDtoToEntity: id {}", id );
        //endregion

        entity.set_id_historial( id );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving Historial_ConexionMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }
}
