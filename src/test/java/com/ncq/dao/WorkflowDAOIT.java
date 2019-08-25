package com.ncq.dao;


import com.ncq.model.Workflow;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
    public void getWorkflowsByFiltersTest() {

        // test retrieval without filters
        List<Workflow> workflowList = workflowDAO.getWorkflowsByFilters(null, null, 0, 0, 10);

        assertNotNull(workflowList);
        assertEquals(5, workflowList.size());


        // test retrieval with name filter
        workflowList = workflowDAO.getWorkflowsByFilters("workflow1", null, 0, 0, 10);

        assertNotNull(workflowList);
        assertEquals(1, workflowList.size());


        // test retrieval with status filter
        workflowList = workflowDAO.getWorkflowsByFilters(null, null, 1, 0, 10);

        assertNotNull(workflowList);
        assertEquals(2, workflowList.size());

        // test retrieval with category ids filter
        workflowList = workflowDAO.getWorkflowsByFilters(null, asList(CATEGORY_ID_2, CATEGORY_ID_4), 1, 0, 10);

        assertNotNull(workflowList);
        assertEquals(2, workflowList.size());


        // test name, status and category ids filters combined with empty result
        workflowList = workflowDAO.getWorkflowsByFilters("workflow6", asList(CATEGORY_ID_1, CATEGORY_ID_2, CATEGORY_ID_3, CATEGORY_ID_4), 1, 0, 10);

        assertNotNull(workflowList);
        assertEquals(0, workflowList.size());


        // test name, status and category ids filters combined with empty result
        workflowList = workflowDAO.getWorkflowsByFilters("workflow1", asList(CATEGORY_ID_1, CATEGORY_ID_2, CATEGORY_ID_3, CATEGORY_ID_4), 1, 0, 10);

        assertNotNull(workflowList);
        assertEquals(1, workflowList.size());
    }


}
