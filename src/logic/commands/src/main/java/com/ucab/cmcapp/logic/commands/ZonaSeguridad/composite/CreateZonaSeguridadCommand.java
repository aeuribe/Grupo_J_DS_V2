package com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite;

import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.atomic.AddZonaSeguridadCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateZonaSeguridadCommand extends Command<ZonaSeguridad>
{
    private static Logger _logger = LoggerFactory.getLogger( CreateZonaSeguridadCommand.class );
    private ZonaSeguridad _zona;
    private ZonaSeguridad _result;
    private AddZonaSeguridadCommand _addzonaCommand;

    public CreateZonaSeguridadCommand(ZonaSeguridad zona )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateZonaSeguridadCommand.ctor");
        //endregion

        _zona = zona;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreateZonaSeguridadCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateZonaSeguridadCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addzonaCommand = CommandFactory.createAddZonaSeguridadCommand(_zona, getHandler());
            _addzonaCommand.execute();
            _result = _addzonaCommand.getReturnParam();
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
        _logger.debug( "Leaving CreatezonaCommand.execute");
        //endregion
    }

    @Override
    public ZonaSeguridad getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
