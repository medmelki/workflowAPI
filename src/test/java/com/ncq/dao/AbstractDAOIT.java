package com.ncq.dao;

import com.ncq.model.Category;
import com.ncq.model.Workflow;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-context.xml")
public class AbstractDAOIT {

    @Autowired
    protected IWorkflowDAO workflowDAO;
    @Autowired
    protected ICategoryDAO categoryDAO;

    protected final String CATEGORY_ID_1 = "9656f3df-8a0d-4ab6-9e17-7886e1bd3ed1";
    protected final String CATEGORY_ID_2 = "511b304f-2dec-4892-91c2-85374584a059";
    protected final String CATEGORY_ID_3 = "9a1845aa-799b-482a-b3c0-390875782eb6";
    protected final String CATEGORY_ID_4 = "1d88ddaf-0b4c-4036-8264-d07e88561ab5";

    protected final String WORKFLOW_ID_1 = "2ddf40ec-0c07-43f5-9160-ea9486e01562";
    protected final String WORKFLOW_ID_2 = "ed553003-2c82-4336-a689-2cdcab4546ba";
    protected final String WORKFLOW_ID_3 = "e827cdca-f035-4484-8315-74f7f6d5b76a";
    protected final String WORKFLOW_ID_4 = "785ca1cc-3c96-4c8e-8a78-ac9d4341a6e7";
    protected final String WORKFLOW_ID_5 = "3fea220b-a16e-41b8-bc51-b4f4ee52f066";

    private List<Category> categories = Arrays.asList(
            new Category(CATEGORY_ID_1, "category1", "This is the category 1", true, null, 1566741473, 1566741473, null, null),
            new Category(CATEGORY_ID_2, "category2", "This is the category 2", true, null, 1566741473, 1566741473, null, null),
            new Category(CATEGORY_ID_3, "category3", "This is the category 3", true, null, 1566741473, 1566741473, null, null),
            new Category(CATEGORY_ID_4, "category4", "This is the category 4", true, null, 1566741473, 1566741473, null, null)
    );

    private List<Workflow> workflows = Arrays.asList(
            new Workflow(WORKFLOW_ID_1, "workflow1",
                    "This is the workflow 1", 1, null, new HashSet<>(Arrays.asList(categories.get(0), categories.get(1), categories.get(2), categories.get(3))), null),
            new Workflow(WORKFLOW_ID_2, "workflow2",
                    "This is the workflow 2", 6, null, new HashSet<>(Arrays.asList(categories.get(0), categories.get(1))), null),
            new Workflow(WORKFLOW_ID_3, "workflow3",
                    "This is the workflow 3", 0, null, new HashSet<>(Collections.singletonList(categories.get(0))), null),
            new Workflow(WORKFLOW_ID_4, "workflow4",
                    "This is the workflow 4", 2, null, new HashSet<>(Arrays.asList(categories.get(1), categories.get(2), categories.get(3))), null),
            new Workflow(WORKFLOW_ID_5, "workflow5",
                    "This is the workflow 5", 10, null, new HashSet<>(Collections.singletonList(categories.get(2))), null)
    );

    @Before
    public void setUp() {

        // create categories
        categories.forEach(categoryDAO::create);

        // create workflows
        workflows.forEach(workflowDAO::create);
    }


    @After
    public void tearDown() {

        categories.forEach(category -> {
            category.setWorkflows(null);
            categoryDAO.delete(category);
        });
        workflows.forEach(workflow -> {
            workflow.setCategories(null);
            workflowDAO.delete(workflow);
        });
    }
}
