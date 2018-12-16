package com.cultivated.app.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "`definition`")
public class Definition extends Base {
    private String word;
    private String definition;
    private String pos;

    public Definition() {}

    public Definition(String word, String def, String pos) {
        this.word = word;
        this.definition = def;
        this.pos = pos;
    }

    public Definition(String word) {
        this.word = word;
    }

    public Definition(Long id, String word, String definition, String pos) {
        this.setId(id);
        this.word = word;
        this.definition = definition;
        this.pos = pos;
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
    @Column(name = "definition")
    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Basic
    @Column(name = "pos")
    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }
}
