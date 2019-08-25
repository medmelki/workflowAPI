package com.ncq.dao;

import com.ncq.model.Workflow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IWorkflowDAO extends IGenericDAO<Workflow, String> {

    List<Workflow> getWorkflowsByFilters(String name, List<String> categoryIds, int status, int firstResult, int maxResult);
}
