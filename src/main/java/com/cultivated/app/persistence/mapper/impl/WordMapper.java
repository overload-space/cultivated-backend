package com.cultivated.app.persistence.mapper.impl;

import com.cultivated.app.persistence.mapper.BaseMapper;
import com.cultivated.app.persistence.model.Word;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WordMapper extends BaseMapper<Word> {
    @Select("select `word` from `word` order by `word` desc")
    List<String> selectByOrder();
}
