package com.ucab.cmcapp.logic.commands.Historial_Conexion.atomic;

import com.ucab.cmcapp.common.entities.Historial_Conexion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Historial_ConexionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddHistorial_ConexionCommand extends Command<Historial_Conexion>
{
    private static Logger _logger = LoggerFactory.getLogger( AddHistorial_ConexionCommand.class );
    private Historial_Conexion _historial;
    private Historial_ConexionDao _dao;

    public AddHistorial_ConexionCommand(Historial_Conexion historial, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddHistorial_ConexionCommand.ctor: parameter {%s}",
                historial.toString() ) );
        setHandler(handler);
        _historial = historial;
        _dao = DaoFactory.createHistorial_ConexionDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddHistorial_ConexionCommand.ctor: attribute {%s}",
                _historial.toString() ) );
        //endregion
    }

    public AddHistorial_ConexionCommand(Historial_Conexion historial )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddHistorial_ConexionCommand.ctor: parameter {%s}",
                historial.toString() ) );
        _historial = historial;
        setHandler(new DBHandler());
        _dao = DaoFactory.createHistorial_ConexionDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddHistorial_ConexionCommand.ctor: attribute {%s}",
                _historial.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddHistorial_ConexionCommand.execute" );
        //endregion

        _historial = _dao.insert( _historial);

        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddHistorial_ConexionCommand.execute" );
        //endregion
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
