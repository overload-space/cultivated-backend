package com.cultivated.app.service;

import com.cultivated.app.persistence.mapper.impl.WordGroupMapper;
import com.cultivated.app.persistence.model.WordGroup;
import com.cultivated.app.persistence.type.GroupType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordGroupService {
    @Resource
    private GroupService groupService;

    @Resource
    private WordGroupMapper wordGroupMapper;

    public void addWordGroup(String word, String group) {
        if (null == groupService.getGroup(group)) {
            groupService.addGroup(group, GroupType.WORD_GROUP);
        }
        wordGroupMapper.insertSelective(new WordGroup(word, group));
    }

    public List<String> getGroupsByWord(String word) {
        return wordGroupMapper.select(new WordGroup(word))
                .stream().map(WordGroup::getGroup).collect(Collectors.toList());
    }

    public List<String> getWordsByGroup(String group) {
        return wordGroupMapper.select(new WordGroup(group))
                .stream().map(WordGroup::getWord).collect(Collectors.toList());
    }
}
