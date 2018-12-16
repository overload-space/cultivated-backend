package com.cultivated.app.persistence.entity;

public class DefinitionEntity {
    private String definition;
    private String pos;

    public DefinitionEntity() {

    }

    public DefinitionEntity(String definition, String pos) {
        this.definition = definition;
        this.pos = pos;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }
}
