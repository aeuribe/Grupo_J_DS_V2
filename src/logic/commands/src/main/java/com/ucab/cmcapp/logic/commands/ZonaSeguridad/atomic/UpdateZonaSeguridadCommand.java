package com.ucab.cmcapp.logic.commands.ZonaSeguridad.atomic;

import com.ucab.cmcapp.common.entities.Persona;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PersonaDao;
import com.ucab.cmcapp.persistence.dao.ZonaSeguridadDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateZonaSeguridadCommand extends Command<ZonaSeguridad>
{
    private static Logger _logger = LoggerFactory.getLogger( UpdateZonaSeguridadCommand.class );
    private ZonaSeguridad _zona;
    private ZonaSeguridadDao _dao;

    public UpdateZonaSeguridadCommand(ZonaSeguridad zona, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in UpdateZonaSeguridadCommand.ctor: parameter {%s}",
                zona.toString() ) );
        setHandler(handler);
        _zona = zona;
        _dao = DaoFactory.createZonaSeguridadDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving UpdateZonaSeguridadCommand.ctor: attribute {%s}",
                _zona.toString() ) );
        //endregion
    }

    public UpdateZonaSeguridadCommand(ZonaSeguridad zona )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in UpdateZonaSeguridadCommand.ctor: parameter {%s}",
                zona.toString() ) );
        _zona = zona;
        setHandler(new DBHandler());
        _dao = DaoFactory.createZonaSeguridadDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving UpdateZonaSeguridadCommand.ctor: attribute {%s}",
                _zona.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  UpdateZonaSeguridadCommand.execute" );
        //endregion

        _zona = _dao.update(_zona);

        //region Instrumentation DEBUG
        _logger.debug( "Get in  UpdateZonaSeguridadCommand.execute" );
        //endregion
    }

    @Override
    public ZonaSeguridad getReturnParam()
    {
        return _zona;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
