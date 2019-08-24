package com.ncq.dao.impl;


import com.ncq.dao.IWorkflowDAO;
import com.ncq.model.Workflow;
import org.springframework.stereotype.Repository;

@Repository
public class WorkflowDAO extends GenericDAO<Workflow, String> implements IWorkflowDAO {

    public WorkflowDAO() {
        super(Workflow.class);
    }
}
