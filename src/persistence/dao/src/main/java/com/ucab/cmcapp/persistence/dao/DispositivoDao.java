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
public class DispositivoDao extends BaseDao<Dispositivo>{
    private static Logger _logger = LoggerFactory.getLogger( UserDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public DispositivoDao(){
        super();
    }

    public DispositivoDao( DBHandler handler){
        super( handler );
        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public Dispositivo getDispositivoById( long id )
    {
        Dispositivo result = EntityFactory.createDispositivo();
        _logger.debug( String.format( "Get in UserDao.getDispositivoById: parameter {%s}", id ) );
        try
        {
            CriteriaQuery<Dispositivo> query = _builder.createQuery( Dispositivo.class );
            Root<Dispositivo> root = query.from( Dispositivo.class );

            query.select( root );
            query.where( _builder.equal( root.get( "id_dispositivo" ), id ) );

            result = _em.createQuery( query ).getSingleResult();
        }
        catch ( NoResultException e )
        {
            _logger.error( String.format( "Error UserDao.getDispositivoById: No Result {%s}", e.getMessage() ) );
        }
        catch ( Exception e )
        {
            _logger.error( String.format( "Error UserDao.getDispositivoById: {%s}", e.getMessage() ) );
            throw new CupraException( e.getMessage() );
        }
        //region Instrumentation
        _logger.debug( String.format( "Leavin DispositivoDao.getDispositivoById: result {%s}", result ) );
        //endregion

        return result;
    }
}



