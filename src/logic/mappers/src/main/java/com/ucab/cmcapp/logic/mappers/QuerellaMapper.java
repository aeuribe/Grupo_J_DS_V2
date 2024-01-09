package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.entities.Querella;
import com.ucab.cmcapp.logic.dtos.PersonaDto;
import com.ucab.cmcapp.logic.dtos.QuerellaDto;
import org.slf4j.LoggerFactory;
import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Persona;
import org.slf4j.Logger;

import java.text.ParseException;
public class QuerellaMapper extends BaseMapper{
    private static Logger _logger = LoggerFactory.getLogger( QuerellaMapper.class );

    public static Querella mapDtoToEntity( QuerellaDto dto ) throws ParseException{

        Querella entity = EntityFactory.createQuerella();

        //region Instrumentation DEBUG
        _logger.debug( "Get in QuerellaMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.set_id_querella( dto.get_id_querella() );
        entity.set_descripcion( dto.get_descripcion() );
        entity.set_cuenta_atras( dto.get_cuenta_atras());
        entity.set_fecha_caso( dto.get_fecha_caso() );
        entity.set_inamovilidad( dto.get_inamovilidad() );
        entity.set_distancia_alejamiento( dto.get_distancia_alejamiento() );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving QuerellaMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static QuerellaDto mapEntityToDto(Querella entity ){
        final QuerellaDto dto = new QuerellaDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in QuerellaMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.set_id_querella( entity.get_id_querella() );
        dto.set_descripcion( entity.get_descripcion() );
        dto.set_cuenta_atras( entity.get_cuenta_atras());
        dto.set_fecha_caso( entity.get_fecha_caso() );
        dto.set_inamovilidad( entity.get_inamovilidad() );
        dto.set_distancia_alejamiento( entity.get_distancia_alejamiento() );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving QuerellaMapper.mapEntityToDto: dto {}", dto );
        //endregion

        return dto;
    }

    public static Querella mapDtoToEntity( long id )
    {
        Querella entity = EntityFactory.createQuerella(id);

        //region Instrumentation DEBUG
        _logger.debug( "Get in QuerellaMapper.mapDtoToEntity: id {}", id );
        //endregion

        entity.set_id_querella( id );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving QuerellaMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }
}
