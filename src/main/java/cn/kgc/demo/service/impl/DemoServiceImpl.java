package cn.kgc.demo.service.impl;

import cn.kgc.demo.dao.InvitationMapper;
import cn.kgc.demo.dao.ReplyDetailMapper;
import cn.kgc.demo.pojo.Invitation;
import cn.kgc.demo.pojo.ReplyDetail;
import cn.kgc.demo.service.DemoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName DemoServiceImpl
 * @Description TODO
 * @Author zhaojing
 * @Date 2021/2/22 10:32
 * @Version 1.0
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private InvitationMapper invitationMapper;

    @Autowired
    private ReplyDetailMapper replyDetailMapper;

    @Override
    public PageInfo<Invitation> getInvitationByPage(String name, Integer pageNum, Integer pageSize) {
        //1.开启分页查询
        PageHelper.startPage(pageNum,pageSize);
        //2.查询数据
        List<Invitation> invitationList = invitationMapper.getInvitationByName(name);
        //3.创建PageInfo
        PageInfo pageInfo = new PageInfo(invitationList);
        return pageInfo;
    }

    @Override
    public PageInfo<ReplyDetail> getReplyDetailByPage(Integer id, Integer pageNum, int pageSize) {
        //1.开启分页查询
        PageHelper.startPage(pageNum,pageSize);
        //2.查询数据
        List<ReplyDetail> replyDetailList = replyDetailMapper.getReplyDetailById(id);
        PageInfo pageInfo = new PageInfo(replyDetailList);
        return pageInfo;
    }

    @Transactional
    @Override
    public boolean addReplyDetail(ReplyDetail replyDetail) {
        int i = replyDetailMapper.addReplyDetail(replyDetail);
        if(i>0){
            return true;
        }
        return false;
    }

    //事务管理
    @Transactional
    @Override
    public boolean delInvitation(Integer id) {
        try{
            //根据帖子id删除回复信息
            replyDetailMapper.delReplyDetailByInvid(id);
            //根据帖子id删除帖子
            invitationMapper.delInvitationById(id);
            return true;
           }catch (Exception e){
               e.printStackTrace();
           }
        return false;
    }
}
