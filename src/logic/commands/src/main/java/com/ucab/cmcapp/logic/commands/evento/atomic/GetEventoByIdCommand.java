package com.ucab.cmcapp.logic.commands.evento.atomic;
import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.EventoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class GetEventoByIdCommand extends Command<Evento>
{
    private static Logger _logger = LoggerFactory.getLogger( GetEventoByIdCommand.class );
    private long _id_evento;
    private Evento _result;
    private EventoDao _dao;

    public GetEventoByIdCommand( DBHandler handler, long id_evento )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetEventoByIdCommand.ctor: parameter {%s}", _id_evento ) );
        //endregion

        _id_evento = id_evento;
        setHandler(handler);
        _dao = DaoFactory.createEventoDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetEventoByIdCommand.ctor: attribute {%s}", id_evento ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetEventoByIdCommand.execute" );
        //endregion
        _result = _dao.find(_id_evento, Evento.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetEventoByIdCommand.execute" );
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

