package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Objects;


public class UsuarioMapper extends BaseMapper
{

    private static Logger _logger = LoggerFactory.getLogger( UsuarioMapper.class );

    public static Usuario mapDtoToEntity( UsuarioDto dto ) throws ParseException
    {
        Usuario entity = EntityFactory.createUsuario();

        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.set_id_usuario( dto.getId());
        entity.set_password( dto.get_password());
        entity.set_rol( dto.getRol());
        entity.set_correo_electronico( dto.get_correo_electronico());

        if ( Objects.nonNull( dto.get_persona()))
        {
            entity.set_persona ( PersonaMapper.mapDtoToEntity( dto.get_persona() ) );
        }

        //region Instrumentation DEBUG
        _logger.debug( "Leaving UsuarioMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static UsuarioDto mapEntityToDto( Usuario entity )
    {
        final UsuarioDto dto = new UsuarioDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioMapper.mapEntityToDto: entity {}", entity );
        //endregion
        dto.setId(entity.get_id_usuario());
        dto.set_correo_electronico ( entity.get_correo_electronico() );
        dto.set_password( entity.get_password());
        dto.setRol( entity.get_rol());
        if(Objects.nonNull(entity.get_persona()))
            dto.set_persona( PersonaMapper.mapEntityToDto( entity.get_persona() ));


        //region Instrumentation DEBUG
        _logger.debug( "Leaving UsuarioMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }

    public static Usuario mapDtoToEntity( long id )
    {
        Usuario entity = EntityFactory.createUsuario( id );

        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioMapper.mapDtoToEntity: id {}", id );
        //endregion

        entity.set_id_usuario( id );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving UsuarioMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static Usuario mapDtoToEntityEmail(String email )
    {
        Usuario entity = EntityFactory.createUsuario( email );

        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioMapper.mapDtoToEntityEmail: email {}", email );
        //endregion

        entity.set_correo_electronico( email );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving UsuarioMapper.mapDtoToEntityEmail: entity {}", entity );
        //endregion

        return entity;
    }
    
}
