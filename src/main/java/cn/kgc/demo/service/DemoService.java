package cn.kgc.demo.service;

import cn.kgc.demo.pojo.Invitation;
import cn.kgc.demo.pojo.ReplyDetail;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName DemoService
 * @Description TODO
 * @Author zhaojing
 * @Date 2021/2/22 10:31
 * @Version 1.0
 */
public interface DemoService {

    //分页查询帖子列表信息
    PageInfo<Invitation> getInvitationByPage(String name, Integer pageNum, Integer pageSize);

    //分页查询回复列表信息
    PageInfo<ReplyDetail> getReplyDetailByPage(Integer id, Integer pageNum, int pageSize);

    //添加回复信息
    boolean addReplyDetail(ReplyDetail replyDetail);

    //根据帖子id删除回复信息和帖子信息
    boolean delInvitation(Integer id);
}
