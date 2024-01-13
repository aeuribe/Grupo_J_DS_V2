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

public class ZonaSeguridadDao extends BaseDao<ZonaSeguridad> {
    private static Logger _logger = LoggerFactory.getLogger( ZonaSeguridadDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public ZonaSeguridadDao(){
        super();
    }

    public ZonaSeguridadDao(DBHandler handler){
        super( handler );
        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public ZonaSeguridad getZonaSeguridadById(long id )
    {
        ZonaSeguridad result = EntityFactory.createZonaSeguridad();
        _logger.debug( String.format( "Get in ZonaSeguridadDao.getZonaSeguridadById: parameter {%s}", id ) );
        try
        {
            CriteriaQuery<ZonaSeguridad> query = _builder.createQuery( ZonaSeguridad.class );
            Root<ZonaSeguridad> root = query.from( ZonaSeguridad.class );

            query.select( root );
            query.where( _builder.equal( root.get( "id_zona" ), id ) );

            result = _em.createQuery( query ).getSingleResult();
        }
        catch ( NoResultException e )
        {
            _logger.error( String.format( "Error UserDao.getZonaSeguridadById: No Result {%s}", e.getMessage() ) );
        }
        catch ( Exception e )
        {
            _logger.error( String.format( "Error ZonaSeguridadDao.getZonaSeguridadById: {%s}", e.getMessage() ) );
            throw new CupraException( e.getMessage() );
        }
        //region Instrumentation
        _logger.debug( String.format( "Leavin ZonaSeguridadDao.getZonaSeguridadById: result {%s}", result ) );
        //endregion

        return result;
    }


}
