package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.entities.P_Q;
import com.ucab.cmcapp.logic.dtos.P_QDto;
import org.slf4j.LoggerFactory;
import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.common.entities.Querella;
import org.slf4j.Logger;

import java.text.ParseException;
public class P_QMapper extends BaseMapper{
    private static Logger _logger = LoggerFactory.getLogger( QuerellaMapper.class );

    public static P_Q mapDtoToEntity(P_QDto dto ) throws ParseException {
        P_Q entity = EntityFactory.createP_Q();

        //region Instrumentation DEBUG
        _logger.debug( "Get in P_QMapper.mapDtoToEntity: dto {}", dto );
        //endregion

      //  entity.set_id_agresor( dto.get_id_agresor() );

        return entity;
    }


}
