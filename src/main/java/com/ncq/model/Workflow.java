package com.ncq.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "workflows")
public class Workflow implements Serializable {

    @Id
    @Column(name = "id_workflow")
    private String idWorkflow;

    private String name;
    private String description;
    private boolean enabled;

    @ManyToOne
    private Workflow original;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "workflows")
    private Set<WorkflowCategory> categories;

    @OneToMany(mappedBy = "original")
    private Set<Workflow> variants;

    public Workflow() {
    }

    public Workflow(String name, String description, boolean enabled, Workflow original, Set<Workflow> variants) {
        this.name = name;
        this.description = description;
        this.enabled = enabled;
        this.original = original;
        this.variants = variants;
    }

    public String getIdWorkflow() {
        return idWorkflow;
    }

    public void setIdWorkflow(String idWorkflow) {
        this.idWorkflow = idWorkflow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Workflow getOriginal() {
        return original;
    }

    public void setOriginal(Workflow original) {
        this.original = original;
    }

    public Set<Workflow> getVariants() {
        return variants;
    }

    public void setVariants(Set<Workflow> variants) {
        this.variants = variants;
    }

    public Set<WorkflowCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<WorkflowCategory> categories) {
        this.categories = categories;
    }
}
