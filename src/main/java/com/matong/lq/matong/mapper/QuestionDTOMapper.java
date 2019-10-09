package com.matong.lq.matong.mapper;

import com.matong.lq.matong.dto.QuestionDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
    @Select("select q.id,q.title,q.description,q.gmt_create,q.gmt_modified,q.creator,q.comment_count,q.view_count,q.like_count,q.unlike_count,q.tag,u.account_id,u.name,u.token,u.pic_url from question q,user u where q.creator=u.account_id")
    public List<QuestionDTO> selectQuestionDTOList();

    @Select("select q.id,q.title,q.description,q.gmt_create,q.gmt_modified,q.creator,q.comment_count,q.view_count,q.like_count,q.unlike_count,q.tag,u.account_id,u.name,u.token,u.pic_url from question q,user u where q.creator=u.account_id and q.creator=#{id}")
    public List<QuestionDTO> selectQuestionDTOListByUserId(@Param("id") int id);

    @Select("select q.id,q.title,q.description,q.gmt_create,q.gmt_modified,q.creator,q.comment_count,q.view_count,q.like_count,q.unlike_count,q.tag,u.account_id,u.name,u.token,u.pic_url from question q,(SELECT\n" +
            "\t*\n" +
            "\tFROM\n" +
            "\tUSER\n" +
            "\tHAVING name=#{name}\n" +
            "\tORDER BY\n" +
            "\tgmt_create DESC\n" +
            "\tLIMIT 1) u where q.creator=u.account_id and q.id=#{id}")
    public QuestionDTO selectUserQuestionDetile(@Param("id") int id,@Param("name") String name);
}
