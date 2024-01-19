package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.dtos.ZonaSeguridadDto;
import com.ucab.cmcapp.logic.dtos.ZonaSeguridadDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Objects;

public class ZonaSeguridadMapper extends BaseMapper
{
    private static Logger _logger = LoggerFactory.getLogger( ZonaSeguridadMapper.class );

    public static ZonaSeguridad mapDtoToEntity(ZonaSeguridadDto dto ) throws ParseException
    {
        ZonaSeguridad entity = EntityFactory.createZonaSeguridad();

        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.set_id_zona(dto.getId());
        entity.set_nombre(dto.get_nombre());
        entity.set_latitud_1(dto.get_latitud_1());
        entity.set_longitud_1(dto.get_longitud_1());
        entity.set_latitud_2(dto.get_latitud_2());
        entity.set_longitud_2(dto.get_longitud_2());
        entity.set_latitud_3(dto.get_latitud_3());
        entity.set_longitud_3(dto.get_longitud_3());


        if ( Objects.nonNull( dto.get_id_dispositivo() ) )
        {
            entity.set_id_dispositivo ( DispositivoMapper.mapDtoToEntity( dto.get_id_dispositivo() ) );
        }



        //region Instrumentation DEBUG
        _logger.debug( "Leaving ZonaSeguridadMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static ZonaSeguridadDto mapEntityToDto( ZonaSeguridad entity )
    {
        final ZonaSeguridadDto dto = new ZonaSeguridadDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.setId(entity.get_id_zona());
        dto.set_nombre(entity.get_nombre());
        dto.set_latitud_1(entity.get_latitud_1());
        dto.set_longitud_1(entity.get_longitud_1());
        dto.set_latitud_2(entity.get_latitud_2());
        dto.set_longitud_2(entity.get_longitud_2());
        dto.set_latitud_3(entity.get_latitud_3());
        dto.set_longitud_3(entity.get_longitud_3());


        if ( Objects.nonNull( entity.get_id_dispositivo() ) )
        {
            dto.set_id_dispositivo ( DispositivoMapper.mapEntityToDto( entity.get_id_dispositivo() ) );
        }
        //region Instrumentation DEBUG
        _logger.debug( "Leaving ZonaSeguridadMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }

    public static ZonaSeguridad mapDtoToEntity( long id )
    {
        ZonaSeguridad entity = EntityFactory.createZonaSeguridad( id );

        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguridadMapper.mapDtoToEntity: id {}", id );
        //endregion

        entity.set_id_zona(id);

        //region Instrumentation DEBUG
        _logger.debug( "Leaving ZonaSeguridadMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

}
