package com.ucab.cmcapp.logic.commands.Zona_de_Seguridad.composite;

import com.ucab.cmcapp.common.entities.Zona_de_Seguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.Zona_de_Seguridad.atomic.AddZona_de_SeguridadCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateZona_de_SeguridadCommand extends Command<Zona_de_Seguridad>
{
    private static Logger _logger = LoggerFactory.getLogger( CreateZona_de_SeguridadCommand.class );
    private Zona_de_Seguridad _zona;
    private Zona_de_Seguridad _result;
    private AddZona_de_SeguridadCommand _addzonaCommand;

    public CreateZona_de_SeguridadCommand(Zona_de_Seguridad zona )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateZona_de_SeguridadCommand.ctor");
        //endregion

        _zona = zona;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreateZona_de_SeguridadCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateZona_de_SeguridadCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addzonaCommand = CommandFactory.createAddZona_de_SeguridadCommand(_zona, getHandler());
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
    public Zona_de_Seguridad getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
