package com.ucab.cmcapp.logic.commands.querella.atomic;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.querella.atomic.GetQuerellaByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.QuerellaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class GetQuerellaByIdCommand extends Command<Querella>
{
    private static Logger _logger = LoggerFactory.getLogger( GetQuerellaByIdCommand.class );
    private long _querellaId;
    private Querella _result;
    private QuerellaDao _dao;

    public GetQuerellaByIdCommand( DBHandler handler, long querellaId )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetQuerellaByIdCommand.ctor: parameter {%s}", querellaId ) );
        //endregion

        _querellaId = querellaId;
        setHandler(handler);
        _dao = DaoFactory.createQuerellaDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetQuerellaByIdCommand.ctor: attribute {%s}", querellaId ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetQuerellaByIdCommand.execute" );
        //endregion
        _result = _dao.find(_querellaId, Querella.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetQuerellaByIdCommand.execute" );
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
