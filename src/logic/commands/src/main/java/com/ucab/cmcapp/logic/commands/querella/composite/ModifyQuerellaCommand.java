package com.ucab.cmcapp.logic.commands.querella.composite;

import com.ucab.cmcapp.common.entities.Querella;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ucab.cmcapp.logic.commands.querella.atomic.UpdateQuerellaCommand;

public class ModifyQuerellaCommand extends Command<Querella>
{
    private static Logger _logger = LoggerFactory.getLogger( ModifyQuerellaCommand.class );
    private Querella _Querella;
    private Querella _result;
    private UpdateQuerellaCommand _updateQuerellaCommand;

    public ModifyQuerellaCommand(Querella Querella )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering ModifyQuerellaCommand.ctor");
        //endregion

        _Querella = Querella;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving ModifyQuerellaCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering ModifyQuerellaCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _updateQuerellaCommand = CommandFactory.createUpdateQuerellaCommand(_Querella, getHandler());
            _updateQuerellaCommand.execute();
            _result = _updateQuerellaCommand.getReturnParam();
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
        _logger.debug( "Leaving ModifyQuerellaCommand.execute");
        //endregion
    }

    @Override
    public Querella getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
