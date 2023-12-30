package com.ucab.cmcapp.logic.commands.Zona_de_Seguridad.atomic;

import com.ucab.cmcapp.common.entities.Zona_de_Seguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.Zona_de_SeguridadDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddZona_de_SeguridadCommand extends Command<Zona_de_Seguridad>
{
    private static Logger _logger = LoggerFactory.getLogger( AddZona_de_SeguridadCommand.class );
    private Zona_de_Seguridad _zona;
    private Zona_de_SeguridadDao _dao;

    public AddZona_de_SeguridadCommand(Zona_de_Seguridad zona, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddZona_de_SeguridadCommand.ctor: parameter {%s}",
                zona.toString() ) );
        setHandler(handler);
        _zona = zona;
        _dao = DaoFactory.createZona_de_SeguridadDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddZona_de_SeguridadCommand.ctor: attribute {%s}",
                _zona.toString() ) );
        //endregion
    }

    public AddZona_de_SeguridadCommand(Zona_de_Seguridad zona )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddZona_de_SeguridadCommand.ctor: parameter {%s}",
                zona.toString() ) );
        _zona = zona;
        setHandler(new DBHandler());
        _dao = DaoFactory.createZona_de_SeguridadDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddZona_de_SeguridadCommand.ctor: attribute {%s}",
                _zona.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddZona_de_SeguridadCommand.execute" );
        //endregion

        _zona = _dao.insert( _zona);

        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddZona_de_SeguridadCommand.execute" );
        //endregion
    }

    @Override
    public Zona_de_Seguridad getReturnParam()
    {
        return _zona;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
