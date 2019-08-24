package com.ncq.dao;

import com.ncq.model.Category;
import org.springframework.stereotype.Service;

@Service
public interface ICategoryDAO extends IGenericDAO<Category, String> {
}
