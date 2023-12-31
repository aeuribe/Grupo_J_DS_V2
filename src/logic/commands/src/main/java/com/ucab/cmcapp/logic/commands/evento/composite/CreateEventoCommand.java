package com.ucab.cmcapp.logic.commands.evento.composite;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.evento.atomic.AddEventoCommand;
import com.ucab.cmcapp.logic.commands.evento.composite.CreateEventoCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateEventoCommand extends Command<Evento>
{
    private static Logger _logger = LoggerFactory.getLogger( CreateEventoCommand.class );
    private Evento _evento;
    private Evento _result;
    private AddEventoCommand _addEventoCommand;

    public CreateEventoCommand(Evento evento )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateEventoCommand.ctor");
        //endregion

        _evento = evento;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreateEventoCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateEventoCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addEventoCommand = CommandFactory.createAddEventoCommand(_evento, getHandler());
            _addEventoCommand.execute();
            _result = _addEventoCommand.getReturnParam();
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
        _logger.debug( "Leaving CreateEventoCommand.execute");
        //endregion
    }

    @Override
    public Evento getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}

