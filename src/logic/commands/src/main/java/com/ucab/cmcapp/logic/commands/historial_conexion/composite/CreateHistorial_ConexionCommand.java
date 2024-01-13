package com.ucab.cmcapp.logic.commands.historial_conexion.composite;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.historial_conexion.atomic.AddHistorial_ConexionCommand;
import com.ucab.cmcapp.logic.commands.persona.atomic.AddPersonaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class CreateHistorial_ConexionCommand extends Command<Historial_Conexion>
{
    private static Logger _logger = LoggerFactory.getLogger( CreateHistorial_ConexionCommand.class );
    private Historial_Conexion _historial;
    private Historial_Conexion _result;
    private AddHistorial_ConexionCommand _addHistorial_ConexionCommand;

    public CreateHistorial_ConexionCommand(Historial_Conexion historial )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateHistorial_ConexionCommand.ctor");
        //endregion

        _historial = historial;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreateHistorial_ConexionCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateHistorial_ConexionCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addHistorial_ConexionCommand = CommandFactory.createAddHistorial_ConexionCommand(_historial, getHandler());
            _addHistorial_ConexionCommand.execute();
            _result = _addHistorial_ConexionCommand.getReturnParam();
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
        _logger.debug( "Leaving CreatePersonaCommand.execute");
        //endregion
    }

    @Override
    public Historial_Conexion getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}

