package com.ucab.cmcapp.logic.commands.querella.atomic;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.querella.atomic.AddQuerellaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.QuerellaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddQuerellaCommand extends Command<Querella>
{
    private static Logger _logger = LoggerFactory.getLogger( AddQuerellaCommand.class );
    private Querella _querella;
    private QuerellaDao _dao;

    public AddQuerellaCommand( Querella querella, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddQuerellaCommand.ctor: parameter {%s}",
                querella.toString() ) );
        setHandler(handler);
        _querella = querella;
        _dao = DaoFactory.createQuerellaDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddQuerellaCommand.ctor: attribute {%s}",
                _querella.toString() ) );
        //endregion
    }

    public AddQuerellaCommand( Querella querella )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddQuerellaCommand.ctor: parameter {%s}",
                querella.toString() ) );
        _querella = querella;
        setHandler(new DBHandler());
        _dao = DaoFactory.createQuerellaDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddQuerellaCommand.ctor: attribute {%s}",
                _querella.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddQuerellaCommand.execute" );
        //endregion

        _querella = _dao.insert( _querella);

        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddQuerellaCommand.execute" );
        //endregion
    }

    @Override
    public Querella getReturnParam()
    {
        return _querella;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
