package com.ucab.cmcapp.logic.commands.posicionamiento.atomic;

import com.ucab.cmcapp.common.entities.Posicionamiento;
import com.ucab.cmcapp.common.entities.Querella;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PosicionamientoDao;
import com.ucab.cmcapp.persistence.dao.QuerellaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdatePosicionamientoCommand extends Command<Posicionamiento>
{
    private static Logger _logger = LoggerFactory.getLogger( UpdatePosicionamientoCommand.class );
    private Posicionamiento _posicionamiento;
    private PosicionamientoDao _dao;

    public UpdatePosicionamientoCommand(Posicionamiento posicionamiento, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in UpdatePosicionamientoCommand.ctor: parameter {%s}",
                posicionamiento.toString() ) );
        setHandler(handler);
        _posicionamiento = posicionamiento;
        _dao = DaoFactory.createPosicionamientoDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving UpdatePosicionamientoCommand.ctor: attribute {%s}",
                _posicionamiento.toString() ) );
        //endregion
    }

    public UpdatePosicionamientoCommand(Posicionamiento posicionamiento )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in UpdatePosicionamientoCommand.ctor: parameter {%s}",
                posicionamiento.toString() ) );
        _posicionamiento = posicionamiento;
        setHandler(new DBHandler());
        _dao = DaoFactory.createPosicionamientoDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving UpdatePosicionamientoCommand.ctor: attribute {%s}",
                _posicionamiento.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  UpdatePosicionamientoCommand.execute" );
        //endregion

        _posicionamiento = _dao.update(_posicionamiento);

        //region Instrumentation DEBUG
        _logger.debug( "Get in  UpdatePosicionamientoCommand.execute" );
        //endregion
    }

    @Override
    public Posicionamiento getReturnParam()
    {
        return _posicionamiento;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
