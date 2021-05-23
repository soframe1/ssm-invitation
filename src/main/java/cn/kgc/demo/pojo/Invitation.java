package cn.kgc.demo.pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Invitation
 * @Description TODO 帖子列表实体类
 * @Author zhaojing
 * @Date 2021/2/21 19:39
 * @Version 1.0
 */
@Data
public class Invitation implements Serializable {

    private Integer id;
    private String title;
    private String summary;
    private String author;
    private Date createdate;

}
