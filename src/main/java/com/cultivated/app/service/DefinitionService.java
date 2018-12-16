package com.cultivated.app.service;

import com.cultivated.app.persistence.entity.DefinitionEntity;
import com.cultivated.app.persistence.mapper.impl.DefinitionMapper;
import com.cultivated.app.persistence.model.Definition;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefinitionService {
    @Resource
    private DefinitionMapper definitionMapper;

    public void addDefinition(String word, String def, String pos) {
        Definition definition = new Definition();
        definition.setWord(word);
        definition.setDefinition(def);
        definition.setPos(pos);
        definitionMapper.insertSelective(new Definition(word, def, pos));
    }

    public List<DefinitionEntity> getDefinitionsByWord(String word) {
        return definitionMapper.select(new Definition(word))
                .stream().map(definition -> new DefinitionEntity(definition.getDefinition(), definition.getPos()))
                .collect(Collectors.toList());
    }

    public void updateDefinition(Long id, String word, String definition, String pos) {
        definitionMapper.updateByPrimaryKeySelective(new Definition(id, word, definition, pos));
    }
}
