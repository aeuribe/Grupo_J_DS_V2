package com.ucab.cmcapp.logic.commands.evento.atomic;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.EventoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class AddEventoCommand extends Command<Evento>
{
    private static Logger _logger = LoggerFactory.getLogger( AddEventoCommand.class );
    private Evento _evento;
    private EventoDao _dao;

    public AddEventoCommand( Evento evento, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddEventoCommand.ctor: parameter {%s}",
                evento.toString() ) );
        setHandler(handler);
        _evento = evento;
        _dao = DaoFactory.createEventoDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddEventoCommand.ctor: attribute {%s}",
                _evento.toString() ) );
        //endregion
    }

    public AddEventoCommand( Evento evento )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddEventoCommand.ctor: parameter {%s}",
                evento.toString() ) );
        _evento = evento;
        setHandler(new DBHandler());
        _dao = DaoFactory.createEventoDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddEventoCommand.ctor: attribute {%s}",
                _evento.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddEventoCommand.execute" );
        //endregion

        _evento = _dao.insert( _evento);

        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddEventoCommand.execute" );
        //endregion
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
