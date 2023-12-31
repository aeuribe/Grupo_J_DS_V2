package com.ucab.cmcapp.logic.commands.querella.composite;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.querella.atomic.GetQuerellaByIdCommand;
import com.ucab.cmcapp.logic.commands.querella.composite.GetQuerellaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetQuerellaCommand extends Command<Querella>
{
    private static Logger _logger = LoggerFactory.getLogger( GetQuerellaCommand.class );
    private Querella _querella;
    long _id;

    public GetQuerellaCommand( Querella querella )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetQuerellaCommand.ctor: parameter {%s}",
                querella.toString() ) );
        _id = querella.get_id_querella();
        _querella = querella;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetQuerellaCommand.ctor: attribute {%s}",
                _querella.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        try
        {
            GetQuerellaByIdCommand getQuerellaByIdCommand = CommandFactory.createGetQuerellaByIdCommand(getHandler(), _id);
            getQuerellaByIdCommand.execute();
            _querella = getQuerellaByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
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
