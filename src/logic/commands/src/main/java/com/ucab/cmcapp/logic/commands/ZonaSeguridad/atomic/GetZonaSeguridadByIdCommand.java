package com.ucab.cmcapp.logic.commands.ZonaSeguridad.atomic;

import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ZonaSeguridadDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetZonaSeguridadByIdCommand extends Command<ZonaSeguridad>
{
    private static Logger _logger = LoggerFactory.getLogger( GetZonaSeguridadByIdCommand.class );
    private long _zonaId;
    private ZonaSeguridad _result;
    private ZonaSeguridadDao _dao;

    public GetZonaSeguridadByIdCommand(DBHandler handler, long zonaId )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetZonaSeguridadByIdCommand.ctor: parameter {%s}", zonaId ) );
        //endregion

        _zonaId = zonaId;
        setHandler(handler);
        _dao = DaoFactory.createZonaSeguridadDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetZonaSeguridadByIdCommand.ctor: attribute {%s}", zonaId ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetZonaSeguridadByIdCommand.execute" );
        //endregion
        _result = _dao.find(_zonaId, ZonaSeguridad.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetzonaByIdCommand.execute" );
        //endregion
    }

    @Override
    public ZonaSeguridad getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
