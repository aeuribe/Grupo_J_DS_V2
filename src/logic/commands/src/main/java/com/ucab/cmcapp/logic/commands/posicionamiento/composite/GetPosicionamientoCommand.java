package com.ucab.cmcapp.logic.commands.posicionamiento.composite;

import com.ucab.cmcapp.common.entities.Posicionamiento;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.posicionamiento.atomic.GetPosicionamientoByIdCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.logic.commands.user.composite.GetUserCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetPosicionamientoCommand extends Command<Posicionamiento>
{
    private static Logger _logger = LoggerFactory.getLogger( GetPosicionamientoCommand.class );
    private Posicionamiento _posicionamiento;
    long _id;

    public GetPosicionamientoCommand( Posicionamiento posicionamiento )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetPosicionamientoCommand.ctor: parameter {%s}",
                posicionamiento.toString() ) );
        _id = posicionamiento.get_id_posicionamiento();
        _posicionamiento = posicionamiento;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetPosicionamientoCommand.ctor: attribute {%s}",
                _posicionamiento.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        try
        {
            GetPosicionamientoByIdCommand getPosicionamientoByIdCommand = CommandFactory.createGetPosicionamientoByIdCommand(getHandler(), _id);
            getPosicionamientoByIdCommand.execute();
            _posicionamiento = getPosicionamientoByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
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
