package com.cultivated.app.controller;

import com.cultivated.app.config.SwaggerConfig;
import com.cultivated.app.persistence.entity.WordEntity;
import com.cultivated.app.service.WordService;
import com.cultivated.app.util.Page;
import com.cultivated.app.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "Word")
@RestController
@RequestMapping(value = SwaggerConfig.API_V1 + "/word")
public class WordController {
    @Resource
    private WordService wordService;

    @ApiOperation(value = "添加单词")
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public void addWord(@RequestBody WordEntity entity) {
        wordService.addWord(entity);
    }

    @ApiOperation(value = "查询单词")
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public WordEntity getWord(@RequestParam("word") String word) {
        return wordService.getWord(word);
    }

    @ApiOperation(value = "查询单词")
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<WordEntity> getWords(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return PageUtil.getPage(wordService.getWords(), page, size);
    }

    @ApiOperation(value = "查询单词")
    @GetMapping(value = "/list/{group}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<WordEntity> getWordsByGroup(@PathVariable("group") String group) {
        return wordService.getWords(group);
    }

    @ApiOperation(value = "更新单词")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateWord(@PathVariable("id") Long id, @RequestParam("word") String word) {
        wordService.updateWord(id, word);
    }
}
