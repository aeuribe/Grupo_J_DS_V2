package com.ucab.cmcapp.logic.commands.evento.composite;

import com.ucab.cmcapp.common.entities.Evento;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ucab.cmcapp.logic.commands.evento.atomic.UpdateEventoCommand;

public class ModifyEventoCommand extends Command<Evento>
{
    private static Logger _logger = LoggerFactory.getLogger( ModifyEventoCommand.class );
    private Evento _evento;
    private Evento _result;
    private UpdateEventoCommand _updateEventoCommand;

    public ModifyEventoCommand(Evento evento )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering ModifyEventoCommand.ctor");
        //endregion

        _evento = evento;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving ModifyEventoCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering ModifyEventoCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _updateEventoCommand = CommandFactory.createUpdateEventoCommand(_evento, getHandler());
            _updateEventoCommand.execute();
            _result = _updateEventoCommand.getReturnParam();
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
        _logger.debug( "Leaving ModifyEventoCommand.execute");
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
