package com.cultivated.app.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "`word_group`")
public class WordGroup extends Base {
    private String word;
    private String group;

    public WordGroup() {}

    public WordGroup(String word, String group) {
        this.word = word;
        this.group = group;
    }

    public WordGroup(String word) {
        this.word = word;
    }

    @Basic
    @Column(name = "word")
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Basic
    @Column(name = "group")
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
