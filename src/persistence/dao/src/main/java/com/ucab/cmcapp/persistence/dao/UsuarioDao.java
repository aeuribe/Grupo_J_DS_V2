package com.ucab.cmcapp.persistence.dao;
import com.ucab.cmcapp.common.entities.Usuario;
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

public class UsuarioDao extends BaseDao<Usuario>{
    private static Logger _logger = LoggerFactory.getLogger( UsuarioDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public UsuarioDao() {
        super();
    }

    public UsuarioDao(DBHandler handler) {
        super(handler);

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public Usuario getUsuarioByEmail( String email )
    {
        Usuario result = EntityFactory.createUsuario();
        _logger.debug( String.format( "Get in UsuarioDao.getUsuarioByEmail: parameter {%s}", email ) );
        try
        {
            CriteriaQuery<Usuario> query = _builder.createQuery( Usuario.class );
            Root<Usuario> root = query.from( Usuario.class );

            query.select( root );
            query.where( _builder.equal( root.get( "_correo_electronico" ), email ) );

            result = _em.createQuery( query ).getSingleResult();
        }
        catch ( NoResultException e )
        {
            _logger.error( String.format( "Error UsuarioDao.getUsuarioByEmail: No Result {%s}", e.getMessage() ) );
        }
        catch ( Exception e )
        {
            _logger.error( String.format( "Error UsuarioDao.getUsuarioByEmail: {%s}", e.getMessage() ) );
            throw new CupraException( e.getMessage() );
        }
        //region Instrumentation
        _logger.debug( String.format( "Leavin UsuarioDao.getUsuarioByEmail: result {%s}", result ) );
        //endregion

        return result;
    }
}
