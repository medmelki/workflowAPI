package com.ncq.dao.impl;


import com.ncq.dao.IGenericDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;


@Repository
public class GenericDAO<T, PK extends Serializable>
        implements IGenericDAO<T, PK> {

    private Class<T> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public GenericDAO() {

    }

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Transactional
    @Override
    public T create(T t) {
        this.entityManager.persist(t);
        return t;
    }

    @Transactional
    @Override
    public T get(PK id) {
        return this.entityManager.find(entityClass, id);
    }

    @Transactional
    @Override
    public T update(T t) {
        return this.entityManager.merge(t);
    }

    @Transactional
    @Override
    public void delete(T t) {
        t = this.entityManager.merge(t);
        this.entityManager.remove(t);
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return entityManager.createQuery("Select t from " + entityClass.getSimpleName() + " t").getResultList();
    }
}
