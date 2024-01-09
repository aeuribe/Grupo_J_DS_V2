package com.ucab.cmcapp.logic.mappers;


import com.ucab.cmcapp.logic.dtos.PersonaDto;
import org.slf4j.LoggerFactory;
import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Persona;
import org.slf4j.Logger;

import java.text.ParseException;
import java.util.ArrayList;


public class PersonaMapper extends BaseMapper{

    private static Logger _logger = LoggerFactory.getLogger( UsuarioMapper.class );

    public static Persona mapDtoToEntity( PersonaDto dto )
    {
        Persona entity = EntityFactory.createPersona( dto.getId() );

        //region Instrumentation DEBUG
        _logger.debug( "Get in PersonaMapper.mapDtoToEntity: dto {}", dto );
        //endregion

    //    entity.set_id_persona( dto.getId() );
        entity.set_sexo( dto.get_sexo());
        entity.set_primer_nombre( dto.get_primer_nombre());
        entity.set_primer_apellido( dto.get_primer_apellido());
        entity.set_segundo_nombre( dto.get_segundo_nombre());
        entity.set_segundo_apellido( dto.get_segundo_apellido());
        entity.setFec_nac( dto.get_fec_nac());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving PersonaMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static PersonaDto mapEntityToDto(Persona entity )
    {
        final PersonaDto dto = new PersonaDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in PersonaMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.setId( entity.get_id_persona() );
        dto.set_primer_apellido(  entity.get_primer_apellido() );
        dto.set_segundo_apellido( entity.get_segundo_apellido());
        dto.set_primer_nombre( entity.get_primer_nombre());
        dto.set_segundo_apellido( entity.get_segundo_nombre());
        dto.set_sexo( entity.get_sexo());
        dto.set_fec_nac( entity.getFec_nac());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving PersonaMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }

    public static Persona mapDtoToEntity( long id )
    {
        Persona entity = EntityFactory.createPersona( id );

        //region Instrumentation DEBUG
        _logger.debug( "Get in PersonaMapper.mapDtoToEntity: id {}", id );
        //endregion

        entity.set_id_persona( id );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving PersonaMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static ArrayList<PersonaDto> mapEntityToDtoList(ArrayList<Persona> entity){
        ArrayList<PersonaDto> dto = new ArrayList<PersonaDto>();

        //region Instrumentation DEBUG
        _logger.debug("Get in PersonaMapper.mapEntityToDto: entity {}");
        //endregion

        for (Persona persona : entity) {
            dto.add(mapEntityToDto(persona));
        }


        return dto;
    }
}
