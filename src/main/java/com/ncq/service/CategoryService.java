package com.ncq.service;

import com.ncq.dao.ICategoryDAO;
import com.ncq.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryService {

    private ICategoryDAO categoryDao;

    @Autowired
    public CategoryService(ICategoryDAO categoryDAO) {
        this.categoryDao = categoryDAO;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> listAll() {
        List<Category> categories = categoryDao.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


}
