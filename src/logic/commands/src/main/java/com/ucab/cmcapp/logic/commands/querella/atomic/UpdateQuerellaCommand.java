package com.ucab.cmcapp.logic.commands.querella.atomic;

import com.ucab.cmcapp.common.entities.Querella;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.QuerellaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateQuerellaCommand extends Command<Querella>
{
    private static Logger _logger = LoggerFactory.getLogger( UpdateQuerellaCommand.class );
    private Querella _querella;
    private QuerellaDao _dao;

    public UpdateQuerellaCommand(Querella querella, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in UpdateQuerellaCommand.ctor: parameter {%s}",
                querella.toString() ) );
        setHandler(handler);
        _querella = querella;
        _dao = DaoFactory.createQuerellaDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddQuerellaCommand.ctor: attribute {%s}",
                _querella.toString() ) );
        //endregion
    }

    public UpdateQuerellaCommand(Querella querella )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in UpdateQuerellaCommand.ctor: parameter {%s}",
                querella.toString() ) );
        _querella = querella;
        setHandler(new DBHandler());
        _dao = DaoFactory.createQuerellaDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving UpdateQuerellaCommand.ctor: attribute {%s}",
                _querella.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  UpdateQuerellaCommand.execute" );
        //endregion

        _querella = _dao.update(_querella);

        //region Instrumentation DEBUG
        _logger.debug( "Get in  UpdateQuerellaCommand.execute" );
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
