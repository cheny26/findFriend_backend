package com.cheny.findFriend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cheny.findFriend.model.entity.Tags;
import com.cheny.findFriend.service.TagsService;
import com.cheny.findFriend.mapper.TagsMapper;
import org.springframework.stereotype.Service;

/**
* @author chen
* @description 针对表【tags(标签)】的数据库操作Service实现
* @createDate 2024-02-07 10:22:45
*/
@Service
public class TagsServiceImpl extends ServiceImpl<TagsMapper, Tags>
    implements TagsService{

}




