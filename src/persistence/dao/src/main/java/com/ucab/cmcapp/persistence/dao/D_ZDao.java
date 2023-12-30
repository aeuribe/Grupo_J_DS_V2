package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

public class D_ZDao extends BaseDao<D_Z>{
    private static Logger _logger = LoggerFactory.getLogger( D_ZDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public D_ZDao(){
        super();
    }

    public D_ZDao(DBHandler handler){
        super(handler);
    }
}
