package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.constraints.PositiveOrZero;


public class PosicionamientoDao extends  BaseDao<Posicionamiento>{
    private static Logger _logger = LoggerFactory.getLogger( EventoDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public PosicionamientoDao(){
        super();
    }

    public PosicionamientoDao ( DBHandler handler ){
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public Posicionamiento GetPosicionamientoById( long id_posicionamiento )
    {
        Posicionamiento result = EntityFactory.createPosicionamiento();
        _logger.debug( String.format( "Get in PosicionamientoDao.GetPosicionamientoById: parameter {%s}", id_posicionamiento ) );
        try
        {
            CriteriaQuery<Posicionamiento> query = _builder.createQuery( Posicionamiento.class );
            Root<Posicionamiento> root = query.from( Posicionamiento.class );

            query.select( root );
            query.where( _builder.equal( root.get( "_id_posicionamiento" ), id_posicionamiento ) );

            result = _em.createQuery( query ).getSingleResult();
        }
        catch ( NoResultException e )
        {
            _logger.error( String.format( "Error PosicionamientoDao.GetPosicionamientoById: No Result {%s}", e.getMessage() ) );
        }
        catch ( Exception e )
        {
            _logger.error( String.format( "Error PosicionamientoDao.GetPosicionamientoById: {%s}", e.getMessage() ) );
            throw new CupraException( e.getMessage() );
        }
        //region Instrumentation
        _logger.debug( String.format( "Leavin PosicionamientoDao.GetPosicionamientoById: result {%s}", result ) );
        //endregion

        return result;
    }

}
