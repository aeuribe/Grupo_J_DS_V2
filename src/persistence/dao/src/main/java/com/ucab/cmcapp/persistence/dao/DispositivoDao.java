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
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
public class DispositivoDao extends BaseDao<Dispositivo> {
    private static Logger _logger = LoggerFactory.getLogger(DispositivoDao.class);
    private EntityManager _em;
    private CriteriaBuilder _builder;

    public DispositivoDao() {
        super();
    }

    public DispositivoDao(DBHandler handler) {
        super(handler);
        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public Dispositivo getDispositivoByNumber(String number) {
        Dispositivo result = EntityFactory.createDispositivo();
        _logger.debug(String.format("Get in DispositivoDao.getDispositivoByNumber: parameter {%s}", number));
        try {
            CriteriaQuery<Dispositivo> query = _builder.createQuery(Dispositivo.class);
            Root<Dispositivo> root = query.from(Dispositivo.class);

            query.select(root);
            query.where(_builder.equal(root.get("_numero_telefonico"), number));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            _logger.error(String.format("Error DispositivoDao.getDispositivoByNumber: No Result {%s}", e.getMessage()));
        } catch (Exception e) {
            _logger.error(String.format("Error DispositivoDaoDao.getDispositivoByNumber: {%s}", e.getMessage()));
            throw new CupraException(e.getMessage());
        }
        //region Instrumentation
        _logger.debug(String.format("Leavin DispositivoDaoDao.getDispositivoByNumber: result {%s}", result));
        //endregion

        return result;
    }

    public Dispositivo getDispositivoByUsuarioId(long idUsuario) {
        Dispositivo result = EntityFactory.createDispositivo();
        _logger.debug(String.format("Get in DispositivoDao.getDispositivoByUsuarioId: parameter {%s}", idUsuario));
        try {
            CriteriaQuery<Dispositivo> query = _builder.createQuery(Dispositivo.class);
            Root<Dispositivo> dispositivoRoot = query.from(Dispositivo.class);

            // Realizar un join con la entidad Usuario
            Join<Dispositivo, Usuario> usuarioJoin = dispositivoRoot.join("usuario");

            query.select(dispositivoRoot);
            query.where(_builder.equal(usuarioJoin.get("_id_usuario"), idUsuario));

            result = _em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            _logger.error(String.format("Error DispositivoDao.getDispositivoByUsuarioId: No Result {%s}", e.getMessage()));
        } catch (Exception e) {
            _logger.error(String.format("Error DispositivoDao.getDispositivoByUsuarioId: {%s}", e.getMessage()));
            throw new CupraException(e.getMessage());
        }
        //region Instrumentation
        _logger.debug(String.format("Leaving DispositivoDao.getDispositivoByUsuarioId: result {%s}", result));
        //endregion

        return result;
    }

}




