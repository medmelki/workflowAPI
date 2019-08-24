package com.ncq.dao.impl;


import com.ncq.dao.ICategoryDAO;
import com.ncq.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAO extends GenericDAO<Category, String> implements ICategoryDAO {

    public CategoryDAO() {
        super(Category.class);
    }
}
