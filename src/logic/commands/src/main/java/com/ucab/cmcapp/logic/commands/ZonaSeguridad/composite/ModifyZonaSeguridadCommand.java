package com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.atomic.UpdateZonaSeguridadCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.UpdateUsuarioCommand;

public class ModifyZonaSeguridadCommand extends Command<ZonaSeguridad>
{
    private static Logger _logger = LoggerFactory.getLogger( ModifyZonaSeguridadCommand.class );
    private ZonaSeguridad _zona;
    private ZonaSeguridad _result;
    private UpdateZonaSeguridadCommand _updateZonaSeguridadCommand;

    public ModifyZonaSeguridadCommand(ZonaSeguridad zona )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering ModifyZonaSeguridadCommand.ctor");
        //endregion

        _zona = zona;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving ModifyZonaSeguridadCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering ModifyZonaSeguridadCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _updateZonaSeguridadCommand = CommandFactory.createUpdateZonaSeguridadCommand(_zona, getHandler());
            _updateZonaSeguridadCommand.execute();
            _result = _updateZonaSeguridadCommand.getReturnParam();
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
        _logger.debug( "Leaving ModifyZonaSeguridadCommand.execute");
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
