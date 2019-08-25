package com.ncq.dao;


import com.ncq.model.Workflow;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WorkflowDAOIT extends AbstractDAOIT {

    @Before
    public void setUp() {

        super.setUp();
    }


    @After
    public void tearDown() {

        super.tearDown();
    }

    @Test
    public void getWorkflowsWithoutFilters() {

        List<Workflow> workflowList = workflowDAO.getWorkflowsByFilters(null, null, 0, 0, 10);

        assertEquals(5, workflowList.size());
    }


}
