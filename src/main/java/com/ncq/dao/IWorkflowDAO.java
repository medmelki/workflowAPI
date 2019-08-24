package com.ncq.dao;

import com.ncq.model.Workflow;
import org.springframework.stereotype.Service;

@Service
public interface IWorkflowDAO extends IGenericDAO<Workflow, String> {
}
