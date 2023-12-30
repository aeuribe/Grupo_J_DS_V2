package com.ucab.cmcapp.logic.commands.Zona_de_Seguridad.atomic;

import com.ucab.cmcapp.common.entities.Zona_de_Seguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Zona_de_SeguridadDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetZona_de_SeguridadByIdCommand extends Command<Zona_de_Seguridad>
{
    private static Logger _logger = LoggerFactory.getLogger( GetZona_de_SeguridadByIdCommand.class );
    private long _zonaId;
    private Zona_de_Seguridad _result;
    private Zona_de_SeguridadDao _dao;

    public GetZona_de_SeguridadByIdCommand(DBHandler handler, long zonaId )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetZona_de_SeguridadByIdCommand.ctor: parameter {%s}", zonaId ) );
        //endregion

        _zonaId = zonaId;
        setHandler(handler);
        _dao = DaoFactory.createZona_de_SeguridadDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetZona_de_SeguridadByIdCommand.ctor: attribute {%s}", zonaId ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetZona_de_SeguridadByIdCommand.execute" );
        //endregion
        _result = _dao.find(_zonaId, Zona_de_Seguridad.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetzonaByIdCommand.execute" );
        //endregion
    }

    @Override
    public Zona_de_Seguridad getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
