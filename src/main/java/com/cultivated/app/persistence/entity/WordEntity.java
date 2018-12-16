package com.cultivated.app.persistence.entity;

import java.util.List;

public class WordEntity {
    private String word;
    private List<String> groups;
    private List<DefinitionEntity> definitions;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public List<DefinitionEntity> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<DefinitionEntity> definitions) {
        this.definitions = definitions;
    }
}
