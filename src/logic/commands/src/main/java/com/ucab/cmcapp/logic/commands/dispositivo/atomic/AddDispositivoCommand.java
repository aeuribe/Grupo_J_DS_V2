package com.ucab.cmcapp.logic.commands.dispositivo.atomic;

import com.ucab.cmcapp.common.entities.Dispositivo;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.DispositivoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddDispositivoCommand extends Command<Dispositivo>
{
    private static Logger _logger = LoggerFactory.getLogger( AddDispositivoCommand.class );
    private Dispositivo _dispositivo;
    private DispositivoDao _dao;

    public AddDispositivoCommand(Dispositivo dispositivo, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddDispositivoCommand.ctor: parameter {%s}",
                dispositivo.toString() ) );
        setHandler(handler);
        _dispositivo = dispositivo;
        _dao = DaoFactory.createDispositivoDao(handler);


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddDispositivoCommand.ctor: attribute {%s}",
                _dispositivo.toString() ) );
        //endregion
    }

    public AddDispositivoCommand(Dispositivo dispositivo )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddDispositivoCommand.ctor: parameter {%s}",
                dispositivo.toString() ) );
        _dispositivo = dispositivo;
        setHandler(new DBHandler());
        _dao = DaoFactory.createDispositivoDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddDispositivoCommand.ctor: attribute {%s}",
                _dispositivo.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddDispositivoCommand.execute" );
        //endregion

        _dispositivo = _dao.insert( _dispositivo);

        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddDispositivoCommand.execute" );
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
