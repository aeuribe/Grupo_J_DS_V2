package com.ucab.cmcapp.logic.commands.dispositivo.atomic;

import com.ucab.cmcapp.common.entities.Dispositivo;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.DispositivoDao;
import com.ucab.cmcapp.persistence.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetDispositivoByIdCommand extends Command<Dispositivo>
{
    private static Logger _logger = LoggerFactory.getLogger( GetDispositivoByIdCommand.class );
    private long _dispositivoId;
    private Dispositivo _result;
    private DispositivoDao _dao;

    public GetDispositivoByIdCommand(DBHandler handler, long dispositivoId )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetDispositivoByIdCommand.ctor: parameter {%s}", dispositivoId ) );
        //endregion

        _dispositivoId = dispositivoId;
        setHandler(handler);
        _dao = DaoFactory.createDispositivoDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetDispositivoByIdCommand.ctor: attribute {%s}", dispositivoId ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetDispositivoByIdCommand.execute" );
        //endregion
        _result = _dao.find(_dispositivoId, Dispositivo.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetDispositivoByIdCommand.execute" );
        //endregion
    }

    @Override
    public Dispositivo getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
