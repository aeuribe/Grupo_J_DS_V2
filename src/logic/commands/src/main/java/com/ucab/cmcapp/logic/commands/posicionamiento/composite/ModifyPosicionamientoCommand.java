package com.ucab.cmcapp.logic.commands.posicionamiento.composite;

import com.ucab.cmcapp.common.entities.Posicionamiento;
import com.ucab.cmcapp.common.entities.Querella;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.posicionamiento.atomic.UpdatePosicionamientoCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ucab.cmcapp.logic.commands.querella.atomic.UpdateQuerellaCommand;

public class ModifyPosicionamientoCommand extends Command<Posicionamiento>
{
    private static Logger _logger = LoggerFactory.getLogger( ModifyPosicionamientoCommand.class );
    private Posicionamiento _posicionamiento;
    private Posicionamiento _result;
    private UpdatePosicionamientoCommand _updatePosicionamientoCommand;

    public ModifyPosicionamientoCommand(Posicionamiento posicionamiento )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering ModifyPosicionamientoCommand.ctor");
        //endregion

        _posicionamiento = posicionamiento;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving ModifyPosicionamientoCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering ModifyPosicionamientoCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _updatePosicionamientoCommand = CommandFactory.createUpdatePosicionamientoCommand(_posicionamiento , getHandler());
            _updatePosicionamientoCommand.execute();
            _result = _updatePosicionamientoCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        }
        catch (Exception e)
        {
            _logger.error("Error during ModifyQuerellaCommand execution: {}", e.getMessage(), e);
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
        //region Instrumentation DEBUG
        _logger.debug( "Leaving ModifyQuerellaCommand.execute");
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
