package com.ncq.dao;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public interface IGenericDAO<T, PK extends Serializable> {

    T create(T t);

    T get(PK id);

    T update(T t);

    void delete(T t);

    List<T> findAll();
}
