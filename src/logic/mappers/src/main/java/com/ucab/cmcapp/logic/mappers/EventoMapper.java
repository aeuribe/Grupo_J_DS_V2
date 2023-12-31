package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Evento;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.dtos.EventoDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Objects;

public class EventoMapper extends BaseMapper
{
    private static Logger _logger = LoggerFactory.getLogger( EventoDto.class );

    public static Evento mapDtoToEntity(EventoDto dto ) throws ParseException
    {
        Evento entity = EntityFactory.createEvento();

        //region Instrumentation DEBUG
        _logger.debug( "Get in EventoMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.set_id_evento( dto.get_id_evento() );
        entity.set_fecha( dto.get_fecha() );
        entity.set_hora( dto.get_hora());
        entity.set_tipo( dto.get_tipo());


        if ( Objects.nonNull( dto.get_id_dispositivo() ) )
        {
            entity.set_id_dispositivo( DispositivoMapper.mapDtoToEntity( dto.get_id_dispositivo() ) );
        }

        //region Instrumentation DEBUG
        _logger.debug( "Leaving EventoMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static EventoDto mapEntityToDto(Evento entity )
    {
        final EventoDto dto = new EventoDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in EventoMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.set_id_evento( entity.get_id_evento() );
        dto.set_fecha( entity.get_fecha() );
        dto.set_tipo( entity.get_tipo() );
        dto.set_hora( entity.get_hora() );

        if(Objects.nonNull(entity.get_id_dispositivo()))
            dto.set_id_dispositivo( DispositivoMapper.mapEntityToDto( entity.get_id_dispositivo() ) );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving EventoMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }

    public static Evento mapDtoToEntity( long id )
    {
        Evento entity = EntityFactory.createEvento( id );

        //region Instrumentation DEBUG
        _logger.debug( "Get in EventoMapper.mapDtoToEntity: id {}", id );
        //endregion

        entity.set_id_evento( id );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving EventoMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }
}
