package com.ucab.cmcapp.logic.commands.posicionamiento.composite;

import com.ucab.cmcapp.common.entities.Posicionamiento;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.posicionamiento.atomic.AddPosicionamientoCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreatePosicionamientoCommand extends Command<Posicionamiento>
{
    private static Logger _logger = LoggerFactory.getLogger( CreatePosicionamientoCommand.class );
    private Posicionamiento _posicionamiento;
    private Posicionamiento _result;
    private AddPosicionamientoCommand _addPosicionamientoCommand;

    public CreatePosicionamientoCommand(Posicionamiento posicionamiento )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreatePosicionamientoCommand.ctor");
        //endregion

        _posicionamiento = posicionamiento;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreatePosicionamientoCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreatePosicionamientoCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addPosicionamientoCommand = CommandFactory.createAddPosicionamientoCommand(_posicionamiento, getHandler());
            _addPosicionamientoCommand.execute();
            _result = _addPosicionamientoCommand.getReturnParam();
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
        _logger.debug( "Leaving CreatePosicionamientoCommand.execute");
        //endregion
    }

    @Override
    public Posicionamiento getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
