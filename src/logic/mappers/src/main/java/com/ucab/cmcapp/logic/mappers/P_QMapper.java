package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.entities.P_Q;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.dtos.P_QDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import org.slf4j.LoggerFactory;
import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.common.entities.Querella;
import org.slf4j.Logger;

import java.text.ParseException;
import java.util.Objects;

public class P_QMapper extends BaseMapper
{
    private static Logger _logger = LoggerFactory.getLogger( QuerellaMapper.class );

    public static P_Q mapDtoToEntity(P_QDto dto ) throws ParseException {

        P_Q entity = EntityFactory.createP_Q();

        //region Instrumentation DEBUG
        _logger.debug( "Get in P_QMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        if ( Objects.nonNull( dto.get_id_agresor()  ) )
        {
            entity.set_id_agresor( PersonaMapper.mapDtoToEntity( dto.get_id_agresor() ) );
        }

        if ( Objects.nonNull( dto.get_id_victima()  ) )
        {
            entity.set_id_victima( PersonaMapper.mapDtoToEntity( dto.get_id_victima() ) );
        }

        if ( Objects.nonNull( dto.get_id_querella() ) )
        {
            entity.set_id_querella( QuerellaMapper.mapDtoToEntity(dto.get_id_querella() ) );
        }

        return entity;
    }

    public static P_QDto mapEntityToDto(P_Q entity )
    {
        final P_QDto dto = new P_QDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in P_QMapper.mapEntityToDto: entity {}", entity );
        //endregion

        if ( Objects.nonNull( entity.get_id_querella() ) )
        {
            dto.set_id_querella( QuerellaMapper.mapEntityToDto( entity.get_id_querella() ) );
        }

        if ( Objects.nonNull( entity.get_id_agresor() ) )
        {
            dto.set_id_agresor( PersonaMapper.mapEntityToDto( entity.get_id_agresor() ) );
        }

        if ( Objects.nonNull( entity.get_id_victima() ) )
        {
            dto.set_id_victima( PersonaMapper.mapEntityToDto( entity.get_id_victima() ) );
        }


        //region Instrumentation DEBUG
        _logger.debug( "Leaving UserMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }


}
