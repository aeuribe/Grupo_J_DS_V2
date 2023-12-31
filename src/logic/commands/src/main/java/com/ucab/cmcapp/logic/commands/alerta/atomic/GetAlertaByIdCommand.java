package com.ucab.cmcapp.logic.commands.alerta.atomic;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AlertaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAlertaByIdCommand extends Command<Alerta>
{
    private static Logger _logger = LoggerFactory.getLogger( GetAlertaByIdCommand.class );
    private long _alertaId;
    private Alerta _result;
    private AlertaDao _dao;

    public GetAlertaByIdCommand( DBHandler handler, long alertaId )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetAlertaByIdCommand.ctor: parameter {%s}", alertaId ) );
        //endregion

        _alertaId = alertaId;
        setHandler(handler);
        _dao = DaoFactory.createAlertaDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetAlertaByIdCommand.ctor: attribute {%s}", alertaId ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetAlertaByIdCommand.execute" );
        //endregion
        _result = _dao.find(_alertaId, Alerta.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetAlertaByIdCommand.execute" );
        //endregion
    }

    @Override
    public Alerta getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
