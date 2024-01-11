package com.ucab.cmcapp.logic.commands.persona.composite;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.persona.atomic.GetPersonaByListCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class GetAllPersonaCommand extends Command<ArrayList<Persona>>
{
    private static Logger _logger = LoggerFactory.getLogger( GetAllPersonaCommand.class );

    private ArrayList<Persona> _personas;
    public GetAllPersonaCommand()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in GetAllPersonaCommand.ctor");
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving GetPersonaCommand.ctor: attribute {%s}" );
        //endregion
    }

    @Override
    public void execute()
    {
        try
        {
            GetPersonaByListCommand getPersonaByListCommand = CommandFactory.createGetPersonaByListCommand(getHandler());
            getPersonaByListCommand.execute();
            _personas = getPersonaByListCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }

    }

    @Override
    public ArrayList<Persona> getReturnParam(){
        return _personas;
    }
    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
