package com.ucab.cmcapp.logic.commands.dispositivo.atomic;

import com.ucab.cmcapp.common.entities.Dispositivo;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.DispositivoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetDispositivoByNumberCommand extends Command<Dispositivo>
{
    private static Logger _logger = LoggerFactory.getLogger( GetDispositivoByNumberCommand.class );
    private Dispositivo _dispositivo;
    private DispositivoDao _dao;

    public GetDispositivoByNumberCommand(Dispositivo dispositivo )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetDispositivoByNumberCommand.ctor: parameter {%s}", dispositivo.toString() ) );
        //endregion

        _dispositivo = dispositivo;
        setHandler(new DBHandler());
        _dao = DaoFactory.createDispositivoDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetDispositivoByNumberCommand.ctor: attribute {%s}", _dispositivo.toString() ) );
        //endregion
    }

    public GetDispositivoByNumberCommand(Dispositivo dispositivo, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetDispositivoByNumberCommand.ctor: parameter {%s}", dispositivo.toString() ) );
        _dispositivo = dispositivo;
        setHandler(handler);
        _dao = DaoFactory.createDispositivoDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leavin GetDispositivoByNumberCommand.ctor: atribute {%s}", _dispositivo.toString() ) );
        //endregion
    }



    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetDispositivoByNumberCommand.execute" );
        //endregion
        _dispositivo = _dao.getDispositivoByNumber(_dispositivo.get_numero_telefonico() );
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetDispositivoByNumberCommand.execute" );
        //endregion
    }

    @Override
    public Dispositivo getReturnParam()
    {
        return _dispositivo;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
