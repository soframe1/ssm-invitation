package cn.kgc.demo.controller;

import cn.kgc.demo.pojo.Invitation;
import cn.kgc.demo.pojo.ReplyDetail;
import cn.kgc.demo.service.DemoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * @ClassName TestController
 * @Description TODO  帖子管理系统控制器
 * @Author zhaojing
 * @Date 2021/2/22 10:24
 * @Version 1.0
 */
@Controller
@RequestMapping("/invitation")
public class TestController {

    @Autowired
    private DemoService demoService;

    //分页查询用户列表
    @RequestMapping("/list")
    public String list(
            @RequestParam(value = "searchName",required = false) String name,
            @RequestParam(defaultValue = "1") Integer pageNum,
            Model model){
        //每页显示多少条记录
        int pageSize = 3;
        PageInfo<Invitation> pageInfo = demoService.getInvitationByPage(name, pageNum, pageSize);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("searchName",name);
        return "list";
    }

    //分页查看回复信息
    @RequestMapping("/cat/{id}")
    public String cat(
            @PathVariable("id") Integer id,
            @RequestParam(defaultValue = "1") Integer pageNum,
            Model model){
        //每页显示多少条记录
        int pageSize = 3;
        PageInfo<ReplyDetail> pageInfo = demoService.getReplyDetailByPage(id, pageNum, pageSize);
        model.addAttribute("pageInfo",pageInfo);
        //回显帖子的id
        model.addAttribute("id",id);
        return "replyDetail";
    }

    //跳转到添加回复页面
    @RequestMapping("/addUI/{id}")
    public String addUI(@PathVariable("id") Integer id,Model model){
        model.addAttribute("id",id);
        return "add";
    }

    //实现添加回复信息
    @RequestMapping("/add/{id}")
    public String add(@PathVariable("id") Integer id,ReplyDetail replyDetail,Model model){
        //id： 表示帖子的id
        replyDetail.setInvid(id);
        replyDetail.setCreatedate(new Date());
        //添加数据
        boolean b = demoService.addReplyDetail(replyDetail);
        if(b){
            model.addAttribute("addMsg","添加回复成功！");
        }else{
            model.addAttribute("addMsg","添加回复失败！");
        }
        //重定向和转发，不走视图解析器
        //redirect , forward
        return "forward:/invitation/cat/"+id;
    }

    //实现删除帖子及回复信息
    @RequestMapping("/del/{id}")
    public String add(@PathVariable("id") Integer id,Model model){
        boolean b = demoService.delInvitation(id);
        if(b){
            model.addAttribute("delMsg","删除成功！");
        }else{
            model.addAttribute("delMsg","删除失败！");
        }
        return "forward:/invitation/list";
    }
}
