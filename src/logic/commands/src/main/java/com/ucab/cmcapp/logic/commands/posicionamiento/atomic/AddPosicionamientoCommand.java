package com.ucab.cmcapp.logic.commands.posicionamiento.atomic;

import com.ucab.cmcapp.common.entities.Posicionamiento;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PosicionamientoDao;
import com.ucab.cmcapp.persistence.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddPosicionamientoCommand extends Command<Posicionamiento>
{
    private static Logger _logger = LoggerFactory.getLogger( AddPosicionamientoCommand.class );
    private Posicionamiento _posicionamiento;
    private PosicionamientoDao _dao;

    public AddPosicionamientoCommand( Posicionamiento posicionamiento, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddPosicionamientoCommand.ctor: parameter {%s}",
                posicionamiento.toString() ) );
        setHandler(handler);
        _posicionamiento = posicionamiento;
        _dao = DaoFactory.createPosicionamientoDao( getHandler() );


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddPosicionamientoCommand.ctor: attribute {%s}",
                _posicionamiento.toString() ) );
        //endregion
    }

    public AddPosicionamientoCommand( Posicionamiento posicionamiento )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddPosicionamientoCommand.ctor: parameter {%s}",
                posicionamiento.toString() ) );
        _posicionamiento = posicionamiento;
        setHandler(new DBHandler());
        _dao = DaoFactory.createPosicionamientoDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddPosicionamientoCommand.ctor: attribute {%s}",
                _posicionamiento.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddPosicionamientoCommand.execute" );
        //endregion

        _posicionamiento = _dao.insert( _posicionamiento);

        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddPosicionamientoCommand.execute" );
        //endregion
    }

    @Override
    public Posicionamiento getReturnParam()
    {
        return _posicionamiento;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
