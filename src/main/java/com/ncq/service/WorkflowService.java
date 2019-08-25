package com.ncq.service;

import com.ncq.dao.IWorkflowDAO;
import com.ncq.model.Workflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workflow")
public class WorkflowService {

    private IWorkflowDAO workflowDao;

    @Autowired
    public WorkflowService(IWorkflowDAO workflowDAO) {
        this.workflowDao = workflowDAO;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Workflow>> listByFilters(@PathVariable String name,
                                                        @PathVariable List<String> ids,
                                                        @PathVariable int status,
                                                        @PathVariable int firstResult,
                                                        @PathVariable int maxResults) {
        List<Workflow> workflows = workflowDao.getWorkflowsByFilters(name, ids, status, firstResult, maxResults);
        if (workflows.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(workflows, HttpStatus.OK);
    }


}
