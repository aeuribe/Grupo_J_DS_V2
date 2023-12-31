package com.ucab.cmcapp.logic.commands.persona.atomic;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.persona.atomic.GetPersonaByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PersonaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class GetPersonaByIdCommand extends Command<Persona>
{
    private static Logger _logger = LoggerFactory.getLogger( GetPersonaByIdCommand.class );
    private long _personaId;
    private Persona _result;
    private PersonaDao _dao;

    public GetPersonaByIdCommand( DBHandler handler, long personaId )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetPersonaByIdCommand.ctor: parameter {%s}", personaId ) );
        //endregion

        _personaId = personaId;
        setHandler(handler);
        _dao = DaoFactory.createPersonaDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetPersonaByIdCommand.ctor: attribute {%s}", personaId ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetPersonaByIdCommand.execute" );
        //endregion
        _result = _dao.find(_personaId, Persona.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetPersonaByIdCommand.execute" );
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
