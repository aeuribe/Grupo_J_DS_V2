package com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite;

import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.atomic.GetZonaSeguridadByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetZonaSeguridadCommand extends Command<ZonaSeguridad>
{
    private static Logger _logger = LoggerFactory.getLogger( GetZonaSeguridadCommand.class );
    private ZonaSeguridad _zona;
    long _id;

    public GetZonaSeguridadCommand(ZonaSeguridad zona )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetZonaSeguridadCommand.ctor: parameter {%s}",
                                      zona.toString() ) );
        _id = zona.get_id_zona();
        _zona = zona;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetZonaSeguridadCommand.ctor: attribute {%s}",
                                      _zona.toString() ) );
        //endregion
    }
    
    @Override
    public void execute()
    {
        try
        {
            GetZonaSeguridadByIdCommand getZonaSeguridadByIdCommand = CommandFactory.createGetZonaSeguridadByIdCommand(getHandler(), _id);
            getZonaSeguridadByIdCommand.execute();
            _zona = getZonaSeguridadByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
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
