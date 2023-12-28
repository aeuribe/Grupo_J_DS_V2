package com.ucab.cmcapp.logic.commands.dispositivo.composite;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Dispositivo;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.dispositivo.atomic.GetDispositivoByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetDispositivoCommand extends Command<Dispositivo>
{
    private static Logger _logger = LoggerFactory.getLogger( GetDispositivoCommand.class );
    private Dispositivo _dispositivo;
    long _id;

    public GetDispositivoCommand(Dispositivo dispositivo )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetDispositivoCommand.ctor: parameter {%s}",
                                      dispositivo.toString() ) );
        _id = dispositivo.get_id_dispositivo();
        _dispositivo = dispositivo;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetDispositivoCommand.ctor: attribute {%s}",
                                      _dispositivo.toString() ) );
        //endregion
    }
    
    @Override
    public void execute()
    {
        try
        {
            GetDispositivoByIdCommand getDispositivoByIdCommand = CommandFactory.createGetDispositivoByIdCommand(getHandler(), _id);
            getDispositivoByIdCommand.execute();
            _dispositivo = getDispositivoByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Dispositivo getReturnParam()
    {
        return _dispositivo;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
