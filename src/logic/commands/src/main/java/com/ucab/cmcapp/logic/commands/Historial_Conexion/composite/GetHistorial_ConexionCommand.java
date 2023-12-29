package com.ucab.cmcapp.logic.commands.Historial_Conexion.composite;

import com.ucab.cmcapp.common.entities.Historial_Conexion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.Historial_Conexion.atomic.GetHistorial_ConexionByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetHistorial_ConexionCommand extends Command<Historial_Conexion>
{
    private static Logger _logger = LoggerFactory.getLogger( GetHistorial_ConexionCommand.class );
    private Historial_Conexion _historial;
    long _id;

    public GetHistorial_ConexionCommand(Historial_Conexion historial )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetHistorial_ConexionCommand.ctor: parameter {%s}",
                                      historial.toString() ) );
        _id = historial.get_id_historial();
        _historial = historial;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetHistorial_ConexionCommand.ctor: attribute {%s}",
                                      _historial.toString() ) );
        //endregion
    }
    
    @Override
    public void execute()
    {
        try
        {
            GetHistorial_ConexionByIdCommand getHistorial_ConexionByIdCommand = CommandFactory.createGetHistorial_ConexionByIdCommand(getHandler(), _id);
            getHistorial_ConexionByIdCommand.execute();
            _historial = getHistorial_ConexionByIdCommand.getReturnParam();
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
        return _historial;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
