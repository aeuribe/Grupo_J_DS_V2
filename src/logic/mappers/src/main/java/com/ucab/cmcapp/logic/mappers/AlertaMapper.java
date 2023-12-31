package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.logic.dtos.AlertaDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Objects;
public class AlertaMapper extends BaseMapper{
    private static Logger _logger = LoggerFactory.getLogger( AlertaMapper.class );

    public static Alerta mapDtoToEntity( AlertaDto dto ) throws ParseException
    {
        Alerta entity = EntityFactory.createAlerta();

        //region Instrumentation DEBUG
        _logger.debug( "Get in AlertaMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.set_id_alerta( dto.get_id_alerta());
        entity.set_descripcion( dto.get_descripcion() );
        entity.set_nombre( dto.get_nombre() );

        if ( Objects.nonNull( dto.get_id_dispositivo() ) )
        {
            entity.set_id_dispositivo( DispositivoMapper.mapDtoToEntity( dto.get_id_dispositivo() ) );
        }

        //region Instrumentation DEBUG
        _logger.debug( "Leaving AlertaMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static AlertaDto mapEntityToDto( Alerta entity )
    {
        final AlertaDto dto = new AlertaDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in UserMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.set_id_alerta( entity.get_id_alerta() );
        dto.set_descripcion( entity.get_descripcion() );
        dto.set_nombre( entity.get_nombre());

        if(Objects.nonNull(entity.get_id_dispositivo()))
            dto.set_id_dispositivo( DispositivoMapper.mapEntityToDto( entity.get_id_dispositivo() ));

        //region Instrumentation DEBUG
        _logger.debug( "Leaving AlertaMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }

    public static Alerta mapDtoToEntity( long id )
    {
        Alerta entity = EntityFactory.createAlerta( id );

        //region Instrumentation DEBUG
        _logger.debug( "Get in AlertaMapper.mapDtoToEntity: id {}", id );
        //endregion

        entity.set_id_alerta( id );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving AlertaMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

}
