package com.ucab.cmcapp.logic.commands.querella.composite;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.persona.atomic.GetPersonaByListCommand;
import com.ucab.cmcapp.logic.commands.querella.atomic.GetQuerellaByListCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class GetAllQuerellaCommand extends Command<ArrayList<Querella>>
{
    private static Logger _logger = LoggerFactory.getLogger( GetAllQuerellaCommand.class );

    private ArrayList<Querella> _querellas;
    public GetAllQuerellaCommand()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in GetAllQuerellaCommand.ctor");
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving GetAllQuerellaCommand.ctor: attribute {%s}" );
        //endregion
    }

    @Override
    public void execute()
    {
        try
        {
            GetQuerellaByListCommand getPersonaByListCommand = CommandFactory.createGetQuerellaByListCommand(getHandler());
            getPersonaByListCommand.execute();
            _querellas = getPersonaByListCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }

    }

    @Override
    public ArrayList<Querella> getReturnParam(){
        return _querellas;
    }
    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
