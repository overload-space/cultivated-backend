package com.cultivated.app.service;

import com.cultivated.app.persistence.entity.WordEntity;
import com.cultivated.app.persistence.mapper.impl.WordMapper;
import com.cultivated.app.persistence.model.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordService {
    private static final Logger logger = LoggerFactory.getLogger(WordService.class);

    @Resource
    private DefinitionService definitionService;
    @Resource
    private WordGroupService wordGroupService;

    @Resource
    private WordMapper wordMapper;

    @Transactional
    public void addWord(WordEntity entity) {
        // add to word
        wordMapper.insertSelective(new Word(entity.getWord()));

        // add to definition
        entity.getDefinitions().forEach(defEntity -> definitionService.addDefinition(
                entity.getWord(), defEntity.getDefinition(), defEntity.getPos()));

        // add to word group
        entity.getGroups().forEach(group -> wordGroupService.addWordGroup(entity.getWord(), group));
        logger.info("add word: {}", entity.getWord());
    }

    public WordEntity getWord(String word) {
        WordEntity entity = new WordEntity();
        entity.setWord(word);
        entity.setGroups(wordGroupService.getGroupsByWord(word));
        entity.setDefinitions(definitionService.getDefinitionsByWord(word));
        return entity;
    }

    @Transactional
    public void updateWord(Long id, String word) {
        wordMapper.updateByPrimaryKeySelective(new Word(id, word));
    }

    public List<WordEntity> getWords() {
        List<String> words = wordMapper.selectByOrder();
        return words.stream().map(this::getWord).collect(Collectors.toList());
    }

    public List<WordEntity> getWords(String group) {
        List<String> words = wordGroupService.getWordsByGroup(group);
        return words.stream().map(this::getWord).collect(Collectors.toList());
    }
}
