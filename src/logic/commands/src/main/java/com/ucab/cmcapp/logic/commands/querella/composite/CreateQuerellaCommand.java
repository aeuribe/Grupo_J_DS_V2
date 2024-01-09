package com.ucab.cmcapp.logic.commands.querella.composite;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.persona.atomic.AddPersonaCommand;
import com.ucab.cmcapp.logic.commands.persona.composite.CreatePersonaCommand;
import com.ucab.cmcapp.logic.commands.querella.atomic.AddQuerellaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class CreateQuerellaCommand extends Command<Querella>
{
    private static Logger _logger = LoggerFactory.getLogger( CreateQuerellaCommand.class );
    private Querella _querella;
    private Querella _result;
    private AddQuerellaCommand _addQuerellaCommand;

    public CreateQuerellaCommand(Querella querella )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateQuerellaCommand.ctor");
        //endregion

        _querella = querella;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreateQuerellaCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateQuerellaCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addQuerellaCommand = CommandFactory.createAddQuerellaCommand(_querella, getHandler());
            _addQuerellaCommand.execute();
            _result = _addQuerellaCommand.getReturnParam();
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
        _logger.debug( "Leaving CreateQuerellaCommand.execute");
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

