package com.ncq.model;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

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
@FilterDefs({
        @FilterDef(name = "workflowsByName", defaultCondition = "name like :name", parameters = {@ParamDef(name = "name", type = "string")}),
        @FilterDef(name = "workflowsByStatus", defaultCondition = "enabled <= 5 and enabled >= 1")
})
@Filters({
        @Filter(name = "workflowsByName"),
        @Filter(name = "workflowsByStatus")
})
public class Workflow implements Serializable {

    @Id
    @Column(name = "id_workflow")
    private String idWorkflow;

    private String name;
    private String description;
    private int enabled;

    @ManyToOne
    private Workflow original;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "workflows")
    @Filters({
            @Filter(name = "categoriesByIds")
    })
    private Set<Category> categories;

    @OneToMany(mappedBy = "original")
    private Set<Workflow> variants;

    public Workflow() {
    }

    public Workflow(String idWorkflow, String name, String description, int enabled, Workflow original,
                    Set<Category> categories, Set<Workflow> variants) {
        this.idWorkflow = idWorkflow;
        this.name = name;
        this.description = description;
        this.enabled = enabled;
        this.original = original;
        this.categories = categories;
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

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
