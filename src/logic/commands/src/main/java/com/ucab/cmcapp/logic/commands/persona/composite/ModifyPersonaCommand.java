package com.ucab.cmcapp.logic.commands.persona.composite;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ucab.cmcapp.logic.commands.persona.atomic.UpdatePersonaCommand;

public class ModifyPersonaCommand extends Command<Persona>
{
    private static Logger _logger = LoggerFactory.getLogger( ModifyPersonaCommand.class );
    private Persona _persona;
    private Persona _result;
    private UpdatePersonaCommand _updatePersonaCommand;

    public ModifyPersonaCommand(Persona persona )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering ModifyPersonaCommand.ctor");
        //endregion

        _persona = persona;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving ModifyPersonaCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering ModifyPersonaCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _updatePersonaCommand = CommandFactory.createUpdatePersonaCommand(_persona, getHandler());
            _updatePersonaCommand.execute();
            _result = _updatePersonaCommand.getReturnParam();
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
        _logger.debug( "Leaving ModifyPersonaCommand.execute");
        //endregion
    }

    @Override
    public Persona getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
