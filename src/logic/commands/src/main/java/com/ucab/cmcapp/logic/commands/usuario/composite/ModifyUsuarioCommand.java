package com.ucab.cmcapp.logic.commands.usuario.composite;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.UpdateUsuarioCommand;

public class ModifyUsuarioCommand extends Command<Usuario>
{
    private static Logger _logger = LoggerFactory.getLogger( ModifyUsuarioCommand.class );
    private Usuario _user;
    private Usuario _result;
    private UpdateUsuarioCommand _updateUsuarioCommand;

    public ModifyUsuarioCommand(Usuario user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering ModifyUsuarioCommand.ctor");
        //endregion

        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving ModifyUsuarioCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering ModifyUsuarioCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _updateUsuarioCommand = CommandFactory.createUpdateUsuarioCommand(_user, getHandler());
            _updateUsuarioCommand.execute();
            _result = _updateUsuarioCommand.getReturnParam();
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
        _logger.debug( "Leaving ModifyUsuarioCommand.execute");
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
