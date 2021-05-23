package cn.kgc.demo.dao;

import cn.kgc.demo.pojo.Invitation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName InvitationMapper
 * @Description TODO
 * @Author zhaojing
 * @Date 2021/2/22 10:33
 * @Version 1.0
 */
public interface InvitationMapper {

    //根据搜索条件进行查询帖子列表
    public List<Invitation> getInvitationByName(@Param("name") String name);

    //根据id删除帖子信息
    @Delete("delete from invitation where id = #{id}")
    public int delInvitationById(@Param("id") Integer id);
}
