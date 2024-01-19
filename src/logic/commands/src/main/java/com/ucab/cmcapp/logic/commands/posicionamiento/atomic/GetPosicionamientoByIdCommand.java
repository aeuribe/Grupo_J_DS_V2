package com.ucab.cmcapp.logic.commands.posicionamiento.atomic;

import com.ucab.cmcapp.common.entities.Posicionamiento;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PosicionamientoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetPosicionamientoByIdCommand extends Command<Posicionamiento>
{
    private static Logger _logger = LoggerFactory.getLogger( GetPosicionamientoByIdCommand.class );
    private long _posicionamiento_id;
    private Posicionamiento _result;
    private PosicionamientoDao _dao;

    public GetPosicionamientoByIdCommand(DBHandler handler, long posicionamiento_id )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetPosicionamientoByIdCommand.ctor: parameter {%s}", _posicionamiento_id ) );
        //endregion

        _posicionamiento_id = posicionamiento_id;
        setHandler(handler);
        _dao = DaoFactory.createPosicionamientoDao( getHandler() );

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetPosicionamientoByIdCommand.ctor: attribute {%s}", posicionamiento_id ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetPosicionamientoByIdCommand.execute" );
        //endregion
        _result = _dao.find(_posicionamiento_id, Posicionamiento.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetPosicionamientoByIdCommand.execute" );
        //endregion
    }

    @Override
    public Posicionamiento getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
