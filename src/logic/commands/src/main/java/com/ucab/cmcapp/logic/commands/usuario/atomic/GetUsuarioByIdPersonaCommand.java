package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetUsuarioByIdPersonaCommand extends Command<Usuario>
{
    private static Logger _logger = LoggerFactory.getLogger( GetUsuarioByIdPersonaCommand.class );
    private Usuario _usuario;
    private UsuarioDao _dao;

    public GetUsuarioByIdPersonaCommand(Usuario usuario )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetUsuarioByIdPersonaCommand.ctor: parameter {%s}", usuario.toString() ) );
        //endregion

        _usuario = usuario;
        setHandler(new DBHandler());
        _dao = DaoFactory.createUsuarioDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetUsuarioByIdCommand.ctor: attribute {%s}", _usuario.toString() ) );
        //endregion
    }

    public GetUsuarioByIdPersonaCommand(Usuario usuario, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetUsuarioByIdPersonaCommand.ctor: parameter {%s}", usuario.toString() ) );
        _usuario = usuario;
        setHandler(handler);
        _dao = DaoFactory.createUsuarioDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leavin GetUsuarioByEmailCommand.ctor: atribute {%s}", _usuario.toString() ) );
        //endregion
    }



    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetUsuarioByEmailCommand.execute" );
        //endregion
        _usuario = _dao.getUsuarioByIdPersona(_usuario.get_persona());
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetUsuarioByEmailCommand.execute" );
        //endregion
    }

    @Override
    public Usuario getReturnParam()
    {
        return _usuario;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
