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

public class Zona_de_SeguridadDao extends BaseDao<Zona_de_Seguridad> {
    private static Logger _logger = LoggerFactory.getLogger( Zona_de_SeguridadDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public Zona_de_SeguridadDao(){
        super();
    }

    public Zona_de_SeguridadDao( DBHandler handler){
        super( handler );
        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public Zona_de_Seguridad getZona_de_SeguridadById( long id )
    {
        Zona_de_Seguridad result = EntityFactory.createZona_de_Seguridad();
        _logger.debug( String.format( "Get in Zona_de_SeguridadDao.getZona_de_SeguridadById: parameter {%s}", id ) );
        try
        {
            CriteriaQuery<Zona_de_Seguridad> query = _builder.createQuery( Zona_de_Seguridad.class );
            Root<Zona_de_Seguridad> root = query.from( Zona_de_Seguridad.class );

            query.select( root );
            query.where( _builder.equal( root.get( "id_zona" ), id ) );

            result = _em.createQuery( query ).getSingleResult();
        }
        catch ( NoResultException e )
        {
            _logger.error( String.format( "Error UserDao.getZona_de_SeguridadById: No Result {%s}", e.getMessage() ) );
        }
        catch ( Exception e )
        {
            _logger.error( String.format( "Error Zona_de_SeguridadDao.getZona_de_SeguridadById: {%s}", e.getMessage() ) );
            throw new CupraException( e.getMessage() );
        }
        //region Instrumentation
        _logger.debug( String.format( "Leavin Zona_de_SeguridadDao.getZona_de_SeguridadById: result {%s}", result ) );
        //endregion

        return result;
    }


}
