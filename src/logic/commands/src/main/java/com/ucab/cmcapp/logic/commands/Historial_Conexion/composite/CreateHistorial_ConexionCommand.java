package com.ucab.cmcapp.logic.commands.Historial_Conexion.composite;

import com.ucab.cmcapp.common.entities.Historial_Conexion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.Historial_Conexion.atomic.AddHistorial_ConexionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateHistorial_ConexionCommand extends Command<Historial_Conexion>
{
    private static Logger _logger = LoggerFactory.getLogger( CreateHistorial_ConexionCommand.class );
    private Historial_Conexion _historial;
    private Historial_Conexion _result;
    private AddHistorial_ConexionCommand _addhistorial_conexionCommand;

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
            _addhistorial_conexionCommand = CommandFactory.createAddHistorial_ConexionCommand(_historial, getHandler());
            _addhistorial_conexionCommand.execute();
            _result = _addhistorial_conexionCommand.getReturnParam();
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
        _logger.debug( "Leaving Createhistorial_conexionCommand.execute");
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
