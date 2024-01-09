package com.ucab.cmcapp.logic.commands.dispositivo.composite;

import com.ucab.cmcapp.common.entities.Dispositivo;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ucab.cmcapp.logic.commands.dispositivo.atomic.UpdateDispositivoCommand;

public class ModifyDispositivoCommand extends Command<Dispositivo>
{
    private static Logger _logger = LoggerFactory.getLogger( com.ucab.cmcapp.logic.commands.dispositivo.composite.ModifyDispositivoCommand.class );
    private Dispositivo _dispositivo;
    private Dispositivo _result;
    private UpdateDispositivoCommand _updateDispositivoCommand;

    public ModifyDispositivoCommand(Dispositivo dispositivo )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering ModifyDispositivoCommand.ctor");
        //endregion

        _dispositivo = dispositivo;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving ModifyDispositivoCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering ModifyDispositivoCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _updateDispositivoCommand = CommandFactory.createUpdateDispositivoCommand(_dispositivo, getHandler());
            _updateDispositivoCommand.execute();
            _result = _updateDispositivoCommand.getReturnParam();
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
        _logger.debug( "Leaving ModifyDispositivoCommand.execute");
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
