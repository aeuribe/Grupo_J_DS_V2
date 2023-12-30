package com.ucab.cmcapp.logic.commands.Zona_de_Seguridad.composite;

import com.ucab.cmcapp.common.entities.Zona_de_Seguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.Zona_de_Seguridad.atomic.GetZona_de_SeguridadByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetZona_de_SeguridadCommand extends Command<Zona_de_Seguridad>
{
    private static Logger _logger = LoggerFactory.getLogger( GetZona_de_SeguridadCommand.class );
    private Zona_de_Seguridad _zona;
    long _id;

    public GetZona_de_SeguridadCommand(Zona_de_Seguridad zona )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetZona_de_SeguridadCommand.ctor: parameter {%s}",
                                      zona.toString() ) );
        _id = zona.get_id_zona();
        _zona = zona;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetZona_de_SeguridadCommand.ctor: attribute {%s}",
                                      _zona.toString() ) );
        //endregion
    }
    
    @Override
    public void execute()
    {
        try
        {
            GetZona_de_SeguridadByIdCommand getZona_de_SeguridadByIdCommand = CommandFactory.createGetZona_de_SeguridadByIdCommand(getHandler(), _id);
            getZona_de_SeguridadByIdCommand.execute();
            _zona = getZona_de_SeguridadByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
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
