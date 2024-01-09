package com.ucab.cmcapp.logic.commands.evento.composite;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.evento.atomic.GetEventoByIdCommand;
import com.ucab.cmcapp.logic.commands.evento.composite.GetEventoCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class GetEventoCommand extends Command<Evento>
{
    private static Logger _logger = LoggerFactory.getLogger( GetEventoCommand.class );
    private Evento _evento;
    long _id;

    public GetEventoCommand( Evento evento )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetEventoCommand.ctor: parameter {%s}",
                evento.toString() ) );
        _id = evento.get_id_evento();
        _evento = evento;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetEventoCommand.ctor: attribute {%s}",
                _evento.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        try
        {
            GetEventoByIdCommand getEventoByIdCommand = CommandFactory.createGetEventoByIdCommand(getHandler(), _id);
            getEventoByIdCommand.execute();
            _evento = getEventoByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Evento getReturnParam()
    {
        return _evento;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
