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

public class EventoDao extends BaseDao<Evento>
{
    private static Logger _logger = LoggerFactory.getLogger( UserDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public EventoDao(){
        super();
    }

    public EventoDao( DBHandler handler ){
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public Evento getEventoById( long id_evento )
    {
        Evento result = EntityFactory.createEvento();
        _logger.debug( String.format( "Get in EventoDao.getEventoById: parameter {%s}", id_evento ) );
        try
        {
            CriteriaQuery<Evento> query = _builder.createQuery( Evento.class );
            Root<Evento> root = query.from( Evento.class );

            query.select( root );
            query.where( _builder.equal( root.get( "_id_evento" ), id_evento ) );

            result = _em.createQuery( query ).getSingleResult();
        }
        catch ( NoResultException e )
        {
            _logger.error( String.format( "Error EventoDao.getEventoById: No Result {%s}", e.getMessage() ) );
        }
        catch ( Exception e )
        {
            _logger.error( String.format( "Error EventoDao.getEventoById: {%s}", e.getMessage() ) );
            throw new CupraException( e.getMessage() );
        }
        //region Instrumentation
        _logger.debug( String.format( "Leavin EventoDao.getEventoById: result {%s}", result ) );
        //endregion

        return result;
    }

}
