package com.ncq.dao.impl;


import com.ncq.dao.IWorkflowDAO;
import com.ncq.model.Workflow;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class WorkflowDAO extends GenericDAO<Workflow, String> implements IWorkflowDAO {

    public WorkflowDAO() {
        super(Workflow.class);
    }

    @Override
    @Transactional
    public List<Workflow> getWorkflowsByFilters(String name, List<String> categoryIds, int status, int firstResult, int maxResult) {
        Session session = entityManager.unwrap(Session.class);
        boolean nameFilterActive = false,
                categoriesFilterActive = false,
                statusFilterActive = false;

        // Activate filters
        if (!StringUtils.isEmpty(name)) {
            session.enableFilter("workflowsByName")
                    .setParameter("name", name);
            nameFilterActive = true;
        }
        if (!CollectionUtils.isEmpty(categoryIds)) {
            session.enableFilter("categoriesByIds")
                    .setParameter("ids", categoryIds);
            categoriesFilterActive = true;
        }
        if (status != 0) {
            session.enableFilter("workflowsByStatus")
                    .setParameter("status", status);
            statusFilterActive = true;
        }

        Query query = session.createQuery("FROM Workflow");
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult > 0 ? maxResult : 10);
        List<Workflow> result = query.list();

        // Disable filters enabled
        if (nameFilterActive) {
            session.disableFilter("workflowsByName");
        }
        if (categoriesFilterActive) {
            session.disableFilter("categoriesByIds");
        }
        if (statusFilterActive) {
            session.disableFilter("workflowsByStatus");
        }

        return result;
    }

}
