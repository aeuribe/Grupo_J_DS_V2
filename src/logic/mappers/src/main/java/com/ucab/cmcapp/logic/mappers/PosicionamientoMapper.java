package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Posicionamiento;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.dtos.PosicionamientoDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Objects;

public class PosicionamientoMapper extends BaseMapper
{
    private static Logger _logger = LoggerFactory.getLogger( PosicionamientoMapper.class );

    public static PosicionamientoDto mapEntityToDto(Posicionamiento entity )
    {
        final PosicionamientoDto dto = new PosicionamientoDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionamientoMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.setId( entity.get_id_posicionamiento());
        dto.set_fecha( entity.get_fecha());
        dto.set_latitud(entity.get_latitud());
        dto.set_logitud(entity.get_longitud());

        if(Objects.nonNull(entity.get_id_dispositivo()))
            dto.set_dispositivo(DispositivoMapper.mapEntityToDto( entity.get_id_dispositivo() ));

        //region Instrumentation DEBUG
        _logger.debug( "Leaving PosicionamientoMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }
    public static Posicionamiento mapDtoToEntity(PosicionamientoDto dto ) throws ParseException
    {
        Posicionamiento entity = EntityFactory.createPosicionamiento();

        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionamientoMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.set_id_posicionamiento( dto.getId() );
        entity.set_latitud( dto.get_latitud() ) ;
        entity.set_longitud( dto.get_logitud() );
        entity.set_fecha( dto.get_fecha() );

        if ( Objects.nonNull( dto.get_dispositivo() ))
        {
            entity.set_id_dispositivo( DispositivoMapper.mapDtoToEntity( dto.get_dispositivo() ) );
        }

        //region Instrumentation DEBUG
        _logger.debug( "Leaving DispositivoMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static Posicionamiento mapDtoToEntity( long id_posicionamiento )
    {
        Posicionamiento entity = EntityFactory.createPosicionamiento();

        //region Instrumentation DEBUG
        _logger.debug( "Get in PosicionamientoMapper.mapDtoToEntityEmail: email {}", id_posicionamiento );
        //endregion

        entity.set_id_posicionamiento( id_posicionamiento );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving PosicionamientoMapper.mapDtoToEntityEmail: entity {}", entity );
        //endregion

        return entity;
    }

}
