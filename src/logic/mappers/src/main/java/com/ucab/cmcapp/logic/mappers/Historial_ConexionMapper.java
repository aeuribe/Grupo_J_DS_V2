package com.ucab.cmcapp.logic.mappers;


import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Historial_Conexion;
import com.ucab.cmcapp.logic.dtos.Historial_ConexionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Objects;

public class Historial_ConexionMapper extends BaseMapper{
    private static Logger _logger = LoggerFactory.getLogger( Historial_ConexionMapper.class );

    public static Historial_Conexion mapDtoToEntity(Historial_ConexionDto dto ) throws ParseException
    {
        Historial_Conexion entity = EntityFactory.createHistorial_Conexion();

        //region Instrumentation DEBUG
        _logger.debug( "Get in Historial_ConexionMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.set_id_historial(dto.get_id_historial());
        entity.set_hora_conexion(dto.get_hora_conexion());
        entity.set_hora_desconexion(dto.get_hora_desconexion());
        entity.set_fecha(dto.get_fecha());
        entity.set_estado(dto.get_estado());


        if ( Objects.nonNull( dto.get_id_historial() ) )
        {
            entity.set_id_dispositivo( DispositivoMapper.mapDtoToEntity( dto.get_id_dispositivo() ) );
        }

        //region Instrumentation DEBUG
        _logger.debug( "Leaving Historial_ConexionMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }
}
