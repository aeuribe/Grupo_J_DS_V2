package com.ucab.cmcapp.logic.commands.Historial_Conexion.composite;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.Historial_Conexion.atomic.GetHistorial_ConexionByIdCommand;
import com.ucab.cmcapp.logic.commands.Historial_Conexion.composite.GetHistorial_ConexionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class GetHistorial_ConexionCommand extends Command<Historial_Conexion>
{
    private static Logger _logger = LoggerFactory.getLogger( GetHistorial_ConexionCommand.class );
    private Historial_Conexion _Historial_Conexion;
    long _id;

    public GetHistorial_ConexionCommand( Historial_Conexion Historial_Conexion )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetHistorial_ConexionCommand.ctor: parameter {%s}",
                Historial_Conexion.toString() ) );
        _id = Historial_Conexion.get_id_historial();
        _Historial_Conexion = Historial_Conexion;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetHistorial_ConexionCommand.ctor: attribute {%s}",
                _Historial_Conexion.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        try
        {
            GetHistorial_ConexionByIdCommand getHistorial_ConexionByIdCommand = CommandFactory.createGetHistorial_ConexionByIdCommand(getHandler(), _id);
            getHistorial_ConexionByIdCommand.execute();
            _Historial_Conexion = getHistorial_ConexionByIdCommand.getReturnParam();
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
        return _Historial_Conexion;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
