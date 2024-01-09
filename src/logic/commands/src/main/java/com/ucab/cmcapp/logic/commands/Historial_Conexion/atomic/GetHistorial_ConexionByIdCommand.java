package com.ucab.cmcapp.logic.commands.Historial_Conexion.atomic;
import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Historial_ConexionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class GetHistorial_ConexionByIdCommand extends Command<Historial_Conexion>
{
    private static Logger _logger = LoggerFactory.getLogger( GetHistorial_ConexionByIdCommand.class );
    private long _id_Historial_Conexion;
    private Historial_Conexion _result;
    private Historial_ConexionDao _dao;

    public GetHistorial_ConexionByIdCommand( DBHandler handler, long id_Historial_Conexion )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetHistorial_ConexionByIdCommand.ctor: parameter {%s}", _id_Historial_Conexion ) );
        //endregion

        _id_Historial_Conexion = id_Historial_Conexion;
        setHandler(handler);
        _dao = DaoFactory.createHistorial_ConexionDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetHistorial_ConexionByIdCommand.ctor: attribute {%s}", id_Historial_Conexion ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetHistorial_ConexionByIdCommand.execute" );
        //endregion
        _result = _dao.find(_id_Historial_Conexion, Historial_Conexion.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetHistorial_ConexionByIdCommand.execute" );
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

