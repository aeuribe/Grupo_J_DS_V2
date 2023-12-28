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

        entity.set_id_dispositivo(dto.get_id_dispositivo());
        entity.set_marca(dto.get_marca());
        entity.set_modelo(dto.get_modelo());
        entity.set_numero_telefonico(dto.get_nunero_telefonico());


        if ( Objects.nonNull( dto.get_id_dispositivo() ) )
        {
            entity.set_id_usuario( UsuarioMapper.mapDtoToEntity( dto.get_id_usuario() ) );
        }

        //region Instrumentation DEBUG
        _logger.debug( "Leaving UserMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

}
