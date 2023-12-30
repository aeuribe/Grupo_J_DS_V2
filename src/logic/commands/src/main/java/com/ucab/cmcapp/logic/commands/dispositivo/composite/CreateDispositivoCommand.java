package com.ucab.cmcapp.logic.commands.dispositivo.composite;

import com.ucab.cmcapp.common.entities.Dispositivo;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.dispositivo.atomic.AddDispositivoCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateDispositivoCommand extends Command<Dispositivo>
{
    private static Logger _logger = LoggerFactory.getLogger( CreateDispositivoCommand.class );
    private Dispositivo _dispositivo;
    private Dispositivo _result;
    private AddDispositivoCommand _addDispositivoCommand;

    public CreateDispositivoCommand(Dispositivo dispositivo )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateDispositivoCommand.ctor");
        //endregion

        _dispositivo = dispositivo;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreateDispositivoCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateDispositivoCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addDispositivoCommand = CommandFactory.createAddDispositivoCommand(_dispositivo, getHandler());
            _addDispositivoCommand.execute();
            _result = _addDispositivoCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreateDispositivoCommand.execute");
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
