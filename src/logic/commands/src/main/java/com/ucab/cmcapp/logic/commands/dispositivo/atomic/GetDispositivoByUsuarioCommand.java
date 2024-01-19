package com.ucab.cmcapp.logic.commands.dispositivo.atomic;

import com.ucab.cmcapp.common.entities.Dispositivo;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.DispositivoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetDispositivoByUsuarioCommand extends Command<Dispositivo>
{
    private static Logger _logger = LoggerFactory.getLogger( GetDispositivoByUsuarioCommand.class );
    private Dispositivo _dispositivo;
    private DispositivoDao _dao;

    public GetDispositivoByUsuarioCommand(Dispositivo dispositivo )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetDispositivoByUsuarioCommand.ctor: parameter {%s}", dispositivo.toString() ) );
        //endregion

        _dispositivo = dispositivo;
        setHandler(new DBHandler());
        _dao = DaoFactory.createDispositivoDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetDispositivoByUsuarioCommand.ctor: attribute {%s}", _dispositivo.toString() ) );
        //endregion
    }

    public GetDispositivoByUsuarioCommand(Dispositivo dispositivo, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetDispositivoByUsuarioCommand.ctor: parameter {%s}", dispositivo.toString() ) );
        _dispositivo = dispositivo;
        setHandler(handler);
        _dao = DaoFactory.createDispositivoDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leavin GetDispositivoByUsuarioCommand.ctor: atribute {%s}", _dispositivo.toString() ) );
        //endregion
    }



    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  getDispositivoByUsuarioId.execute" );
        //endregion
        _dispositivo = _dao.getDispositivoByUsuarioId(_dispositivo.get_id_usuario().get_id_usuario());
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  getDispositivoByUsuarioId.execute" );
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
