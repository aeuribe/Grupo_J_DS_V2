package com.ucab.cmcapp.logic.commands.querella.atomic;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PersonaDao;
import com.ucab.cmcapp.persistence.dao.QuerellaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GetQuerellaByListCommand extends Command<ArrayList<Querella>>
{
    private static Logger _logger = LoggerFactory.getLogger( GetQuerellaByListCommand.class );
    private ArrayList<Querella> _result;

    private List<Persona> _persona;
    private QuerellaDao _dao;

    public GetQuerellaByListCommand(DBHandler handler)
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in GetQuerellaByListCommand.ctor: parameter {%s}" );
        //endregion

        setHandler(handler);
        _dao = DaoFactory.createQuerellaDao((getHandler()));

        //region Instrumentation DEBUG
        _logger.debug("Leaving GetQuerellaByListCommand.ctor: attribute {%s}");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetQuerellaByListCommand.execute" );
        //endregion
        _result = new ArrayList<>(_dao.findAll(Querella.class));
        System.out.println("fallo: "+_result);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetPersonaByIdCommand.execute" );
        //endregion
    }

    @Override
    public ArrayList<Querella> getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
