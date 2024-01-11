package com.ucab.cmcapp.logic.commands.historial_conexion.atomic;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Historial_ConexionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class AddHistorial_ConexionCommand extends Command<Historial_Conexion>
{
    private static Logger _logger = LoggerFactory.getLogger( AddHistorial_ConexionCommand.class );
    private Historial_Conexion _historial_conexion;
    private Historial_ConexionDao _dao;

    public AddHistorial_ConexionCommand( Historial_Conexion historial_conexion, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddHistorial_ConexionCommand.ctor: parameter {%s}",
                historial_conexion.toString() ) );
        setHandler(handler);
        _historial_conexion = historial_conexion;
        _dao = DaoFactory.createHistorial_ConexionDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddHistorial_ConexionCommand.ctor: attribute {%s}",
                _historial_conexion.toString() ) );
        //endregion
    }

    public AddHistorial_ConexionCommand( Historial_Conexion historial_conexion )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in Addhistorial_conexionCommand.ctor: parameter {%s}",
                historial_conexion.toString() ) );
        _historial_conexion = historial_conexion;
        setHandler(new DBHandler());
        _dao = DaoFactory.createHistorial_ConexionDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddHistorial_ConexionCommand.ctor: attribute {%s}",
                _historial_conexion.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddHistorial_ConexionCommand.execute" );
        //endregion

        _historial_conexion = _dao.insert( _historial_conexion);

        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddHistorial_ConexionCommand.execute" );
        //endregion
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

