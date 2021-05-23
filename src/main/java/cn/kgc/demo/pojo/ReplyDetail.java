package cn.kgc.demo.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName ReplyDetail
 * @Description TODO 帖子回复列表实体类
 * @Author zhaojing
 * @Date 2021/2/21 19:43
 * @Version 1.0
 */
@Data
public class ReplyDetail implements Serializable {

    private Integer id;
    private Integer invid;
    private String content;
    private String author;
    private Date createdate;
}
