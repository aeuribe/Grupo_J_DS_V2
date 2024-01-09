package com.ucab.cmcapp.logic.commands.persona.atomic;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PersonaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GetPersonaByListCommand extends Command<ArrayList<Persona>>
{
    private static Logger _logger = LoggerFactory.getLogger( GetPersonaByListCommand.class );
    private ArrayList<Persona> _result;

    private List<Persona> _persona;
    private PersonaDao _dao;

    public GetPersonaByListCommand(DBHandler handler)
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in GetPersonaByList.ctor: parameter {%s}" );
        //endregion

        setHandler(handler);
        _dao = DaoFactory.createPersonaDao((getHandler()));

        //region Instrumentation DEBUG
        _logger.debug("Leaving GetPersonaByList.ctor: attribute {%s}");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetPersonaByList.execute" );
        //endregion
        _result = new ArrayList<>(_dao.findAll(Persona.class));
        System.out.println("fallo: "+_result);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetPersonaByIdCommand.execute" );
        //endregion
    }

    @Override
    public ArrayList<Persona> getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
