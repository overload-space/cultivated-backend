package com.cultivated.app.service;

import com.cultivated.app.persistence.mapper.impl.GroupMapper;
import com.cultivated.app.persistence.model.Group;
import com.cultivated.app.persistence.type.GroupType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GroupService {
    @Resource
    private GroupMapper groupMapper;

    public void addGroup(String group, GroupType type) {
        groupMapper.insertSelective(new Group(group, type));
    }

    public Group getGroup(String group) {
        return groupMapper.selectOne(new Group(group));
    }
}
