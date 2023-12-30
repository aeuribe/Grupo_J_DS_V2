package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Zona_de_Seguridad;
import com.ucab.cmcapp.logic.dtos.Zona_de_SeguridadDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Objects;

public class Zona_de_SeguridadMapper extends BaseMapper{
    private static Logger _logger = LoggerFactory.getLogger( Zona_de_SeguridadMapper.class );

    public static Zona_de_Seguridad mapDtoToEntity(Zona_de_SeguridadDto dto ) throws ParseException
    {
        Zona_de_Seguridad entity = EntityFactory.createZona_de_Seguridad();

        //region Instrumentation DEBUG
        _logger.debug( "Get in Zona_de_SeguridadMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.set_id_zona(dto.get_id_zona());
        entity.set_nombre(dto.get_nombre());
        entity.set_latitud(dto.get_latitud());
        entity.set_longitud(dto.get_longitud());


        //region Instrumentation DEBUG
        _logger.debug( "Leaving Zona_de_SeguridadMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }
}
