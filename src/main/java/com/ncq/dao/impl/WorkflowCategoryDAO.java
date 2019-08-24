package com.ncq.dao.impl;


import com.ncq.dao.IWorkflowCategoryDAO;
import com.ncq.model.WorkflowCategory;
import org.springframework.stereotype.Repository;

@Repository
public class WorkflowCategoryDAO extends GenericDAO<WorkflowCategory, String> implements IWorkflowCategoryDAO {

    public WorkflowCategoryDAO() {
        super(WorkflowCategory.class);
    }
}
