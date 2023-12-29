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

public class Historial_ConexionDao extends BaseDao<Historial_Conexion>{
    private static Logger _logger = LoggerFactory.getLogger( Historial_ConexionDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public Historial_ConexionDao(){
        super();
    }

    public Historial_ConexionDao( DBHandler handler){
        super( handler );
        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public Historial_Conexion getHistorial_ConexionById( long id )
    {
        Historial_Conexion result = EntityFactory.createHistorial_Conexion();
        _logger.debug( String.format( "Get in Historial_ConexionDao.getHistorial_ConexionById: parameter {%s}", id ) );
        try
        {
            CriteriaQuery<Historial_Conexion> query = _builder.createQuery( Historial_Conexion.class );
            Root<Historial_Conexion> root = query.from( Historial_Conexion.class );

            query.select( root );
            query.where( _builder.equal( root.get( "id_historial" ), id ) );

            result = _em.createQuery( query ).getSingleResult();
        }
        catch ( NoResultException e )
        {
            _logger.error( String.format( "Error UserDao.getHistorial_ConexionById: No Result {%s}", e.getMessage() ) );
        }
        catch ( Exception e )
        {
            _logger.error( String.format( "Error Historial_ConexionDao.getHistorial_ConexionById: {%s}", e.getMessage() ) );
            throw new CupraException( e.getMessage() );
        }
        //region Instrumentation
        _logger.debug( String.format( "Leavin Historial_ConexionDao.getHistorial_ConexionById: result {%s}", result ) );
        //endregion

        return result;
    }

}
