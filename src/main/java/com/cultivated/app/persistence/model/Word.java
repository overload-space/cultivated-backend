package com.cultivated.app.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "`word`")
public class Word extends Base {
    private String word;

    public Word() {
    }

    public Word(String word) {
        this.word = word;
    }

    public Word(Long id, String word) {
        this.setId(id);
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
}
