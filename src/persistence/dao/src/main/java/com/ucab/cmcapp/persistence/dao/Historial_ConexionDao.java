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


public class Historial_ConexionDao extends BaseDao<Historial_Conexion>
{
    private static Logger _logger = LoggerFactory.getLogger( Historial_ConexionDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public Historial_ConexionDao(){
        super();
    }

    public Historial_ConexionDao(DBHandler handler){
        super( handler );
        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

}
