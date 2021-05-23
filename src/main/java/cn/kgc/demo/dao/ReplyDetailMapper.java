package cn.kgc.demo.dao;

import cn.kgc.demo.pojo.ReplyDetail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName ReplyDetailMapper
 * @Description TODO
 * @Author zhaojing
 * @Date 2021/2/23 8:29
 * @Version 1.0
 */
public interface ReplyDetailMapper {

    //根据帖子id查询回复信息
    @Select("select * from reply_detail where invid = #{id}")
    public List<ReplyDetail> getReplyDetailById(@Param("id") Integer id);

    //插入回复信息
    @Insert("insert into reply_detail values (null,#{invid},#{content},#{author},#{createdate})")
    public int addReplyDetail(ReplyDetail replyDetail);

    //根据帖子id删除回复信息
    @Delete("delete from reply_detail where invid = #{invid}")
    public int delReplyDetailByInvid(@Param("invid") Integer invid);
}
