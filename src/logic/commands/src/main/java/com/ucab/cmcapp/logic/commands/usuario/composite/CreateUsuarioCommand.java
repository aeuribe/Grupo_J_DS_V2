package com.ucab.cmcapp.logic.commands.usuario.composite;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.AddUsuarioCommand;

public class CreateUsuarioCommand extends Command<Usuario>
{
    private static Logger _logger = LoggerFactory.getLogger( CreateUsuarioCommand.class );
    private Usuario _user;
    private Usuario _result;
    private AddUsuarioCommand _addUserCommand;

    public CreateUsuarioCommand(Usuario user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateUsuarioCommand.ctor");
        //endregion

        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreateUsuarioCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateUsuarioCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addUserCommand = CommandFactory.createAddUsuarioCommand(_user, getHandler());
            _addUserCommand.execute();
            _result = _addUserCommand.getReturnParam();
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
        _logger.debug( "Leaving CreateUserCommand.execute");
        //endregion
    }

    @Override
    public Usuario getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
