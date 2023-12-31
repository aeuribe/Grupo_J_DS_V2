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
public class AlertaDao extends BaseDao<Alerta>{
    private static Logger _logger = LoggerFactory.getLogger( UserDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public AlertaDao(){
        super();
    }

    public AlertaDao( DBHandler handler){
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public Alerta getAlertaById( long id_alerta )
    {
        Alerta result = EntityFactory.createAlerta();
        _logger.debug( String.format( "Get in AlertaDao.getAlertaById: parameter {%s}", id_alerta ) );
        try
        {
            CriteriaQuery<Alerta> query = _builder.createQuery( Alerta.class );
            Root<Alerta> root = query.from( Alerta.class );

            query.select( root );
            query.where( _builder.equal( root.get( "_id_alerta" ), id_alerta ) );

            result = _em.createQuery( query ).getSingleResult();
        }
        catch ( NoResultException e )
        {
            _logger.error( String.format( "Error AlertaDao.getAlertaById: No Result {%s}", e.getMessage() ) );
        }
        catch ( Exception e )
        {
            _logger.error( String.format( "Error AlertaDao.getAlertaById: {%s}", e.getMessage() ) );
            throw new CupraException( e.getMessage() );
        }
        //region Instrumentation
        _logger.debug( String.format( "Leavin AlertaDao.getAlertaById: result {%s}", result ) );
        //endregion

        return result;
    }
}
