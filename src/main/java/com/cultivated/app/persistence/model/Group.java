package com.cultivated.app.persistence.model;

import com.cultivated.app.persistence.type.GroupType;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "`group`")
public class Group extends Base {
    private String group;
    private GroupType type;

    public Group() {

    }

    public Group(String group) {
        this.group = group;
    }

    public Group(String group, GroupType type) {
        this.group = group;
        this.type = type;
    }

    @Basic
    @Column(name = "group")
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Basic
    @Column(name = "type")
    public GroupType getType() {
        return type;
    }

    public void setType(GroupType type) {
        this.type = type;
    }
}
