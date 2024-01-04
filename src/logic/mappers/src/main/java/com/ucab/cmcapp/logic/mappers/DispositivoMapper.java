package com.ucab.cmcapp.logic.mappers;


import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Dispositivo;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.dtos.DispositivoDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Objects;

public class DispositivoMapper extends BaseMapper{
    private static Logger _logger = LoggerFactory.getLogger( DispositivoMapper.class );

    public static Dispositivo mapDtoToEntity( DispositivoDto dto ) throws ParseException
    {
        Dispositivo entity = EntityFactory.createDispositivo();

        //region Instrumentation DEBUG
        _logger.debug( "Get in DispositivoMapper.mapDtoToEntity: dto {}", dto );
        //endregion


        entity.set_id_dispositivo(dto.getId());
        entity.set_marca(dto.get_marca());
        entity.set_modelo(dto.get_modelo());
        entity.set_numero_telefonico(dto.get_nunero_telefonico());


        if ( Objects.nonNull( dto.getId() ) )
        {
            entity.set_id_usuario( UsuarioMapper.mapDtoToEntity( dto.get_id_usuario() ) );
        }

        //region Instrumentation DEBUG
        _logger.debug( "Leaving UserMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static DispositivoDto mapEntityToDto( Dispositivo entity )
    {
        final DispositivoDto dto = new DispositivoDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in DispositivoMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.setId(entity.get_id_dispositivo() );
        dto.set_marca( entity.get_marca() );
        dto.set_modelo( entity.get_marca() );
        dto.set_nunero_telefonico( entity.get_numero_telefonico() );


        if(Objects.nonNull(entity.get_id_usuario()))
            dto.set_id_usuario( UsuarioMapper.mapEntityToDto( entity.get_id_usuario() ) );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving UserMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }

    public static Dispositivo mapDtoToEntityEmail( long id_disposotivo )
    {
        Dispositivo entity = EntityFactory.createDispositivo();

        //region Instrumentation DEBUG
        _logger.debug( "Get in DispositivoMapper.mapDtoToEntityEmail: email {}", id_disposotivo );
        //endregion

        entity.set_id_dispositivo( id_disposotivo );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving DispositivoMapper.mapDtoToEntityEmail: entity {}", entity );
        //endregion

        return entity;
    }
}
