package cn.kgc.demo.interceptor;

import cn.kgc.demo.utils.Constants;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName SysInterceptor
 * @Description TODO 自定义拦截器类
 * @Author zhaojing
 * @Date 2020/10/23 11:39
 * @Version 1.0
 */
public class SysInterceptor extends HandlerInterceptorAdapter {

    //表示在调用具体的控制器之前，就拦截请求
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //判断session
        HttpSession session = request.getSession();

        Object obj = session.getAttribute(Constants.DATE_TIME);

        //如果是Null，说明没有登录，重定向到指定页面上
        if(obj == null){
           session.setAttribute(Constants.DATE_TIME,(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
        }
        //通过
        return true;
    }
}
