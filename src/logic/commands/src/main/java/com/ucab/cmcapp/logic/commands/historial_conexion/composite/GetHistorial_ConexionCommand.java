package com.ucab.cmcapp.logic.commands.historial_conexion.composite;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.historial_conexion.atomic.GetHistorial_ConexionByIdCommand;
import com.ucab.cmcapp.logic.commands.persona.atomic.GetPersonaByIdCommand;
import com.ucab.cmcapp.logic.commands.persona.composite.GetPersonaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class GetHistorial_ConexionCommand extends Command<Historial_Conexion>
{
    private static Logger _logger = LoggerFactory.getLogger( GetHistorial_ConexionCommand.class );
    private Historial_Conexion _historial_conexion;
    long _id;

    public GetHistorial_ConexionCommand( Historial_Conexion historial_conexion )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetHistorial_ConexionCommand.ctor: attribute {%s}",
                historial_conexion.toString() ) );
        _id = historial_conexion.get_id_historial();
        _historial_conexion = historial_conexion;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetHistorial_ConexionCommand.ctor: attribute {%s}",
                _historial_conexion.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        try
        {
            GetHistorial_ConexionByIdCommand getHistorial_ConexionByIdCommand = CommandFactory.createGetHistorial_ConexionByIdCommand(getHandler(), _id);
            getHistorial_ConexionByIdCommand.execute();
            _historial_conexion = getHistorial_ConexionByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Historial_Conexion getReturnParam()
    {
        return _historial_conexion;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
