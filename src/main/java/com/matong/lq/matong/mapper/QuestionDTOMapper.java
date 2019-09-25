package com.matong.lq.matong.mapper;

import com.matong.lq.matong.dto.QuestionDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description
 * @Author LiuQiang
 * @Date 2019/9/24 21:41
 * @Version 1.0
 */
@Mapper
@Component
public interface QuestionDTOMapper {
    @Select("select q.id,q.title,q.description,q.gmt_create,q.gmt_modified,q.creator,q.comment_count,q.view_count,q.like_count,q.unlike_count,q.tag,u.account_id,u.name,u.token,u.pic_url from question q,user u where q.creator=u.id")
    public List<QuestionDTO> selectQuestionDTOList();
}
