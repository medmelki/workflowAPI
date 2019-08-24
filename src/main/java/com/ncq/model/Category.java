package com.ncq.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category implements Serializable {

    @Id
    @Column(name = "id_category")
    private String idCategory;

    private String name;
    private String description;
    private boolean enabled;

    @Lob
    private byte[] logo;

    private long createdAt;
    private long updatedAt;

    @OneToOne
    private Category parent;

    @OneToOne(mappedBy = "parent")
    private Category child;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private Set<Category> workflows;

    public Category() {
    }

    public Category(String name, String description, boolean enabled, byte[] logo,
                    long createdAt, long updatedAt, Category parent, Category child) {
        this.name = name;
        this.description = description;
        this.enabled = enabled;
        this.logo = logo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.parent = parent;
        this.child = child;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
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

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public Category getChild() {
        return child;
    }

    public void setChild(Category child) {
        this.child = child;
    }

    public Set<Category> getWorkflows() {
        return workflows;
    }

    public void setWorkflows(Set<Category> workflows) {
        this.workflows = workflows;
    }
}
