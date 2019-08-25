package com.ncq.dao;


import com.ncq.model.Category;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CategoryDAOIT extends AbstractDAOIT {

    @Before
    public void setUp() {

        super.setUp();
    }


    @After
    public void tearDown() {

        super.tearDown();
    }

    @Test
    public void findAllTest() {
        List<Category> categories = categoryDAO.findAll();

        assertNotNull(categories);
        assertEquals(4, categories.size());
    }


}
