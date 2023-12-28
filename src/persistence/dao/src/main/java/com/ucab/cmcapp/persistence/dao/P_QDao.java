package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;


public class P_QDao extends BaseDao<P_Q>{
    private static Logger _logger = LoggerFactory.getLogger( P_QDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public P_QDao(){
        super();
    }

    public P_QDao(DBHandler handler){
        super(handler);
    }
}
