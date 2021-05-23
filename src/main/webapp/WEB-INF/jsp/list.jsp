<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: zhaojing
  Date: 2021/4/23
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/statics/css/bootstrap.css">
    <script src="/statics/js/jquery-1.12.4.js"></script>
    <script src="/statics/js/bootstrap.js"></script>
    <script src="/statics/js/bootstrap-paginator.js"></script>
    <style>
        #page li{
            cursor:pointer;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-md-offset-3">
                <h3>帖子列表</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 col-md-offset-2">
                <form action="/invitation/list" class="form-inline" id="myForm">
                    <input type="hidden" name="pageNum" id="pageNum">
                    <div class="form-group">
                        帖子标题：
                        <input type="text" name="searchName"  value="${searchName}" id="" class="form-control" placeholder="请输入帖子标题">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">搜索</button>
                    </div>
                </form>
            </div>
        </div>
        <br><br>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <table class="table-striped table table-hover table-bordered">
                    <tr>
                        <th>标题</th>
                        <th>内容摘要</th>
                        <th>作者</th>
                        <th>发布时间</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${pageInfo.list}" var="invitation">
                        <tr align="center">
                            <td>${invitation.title}</td>
                            <td>${invitation.summary}</td>
                            <td>${invitation.author}</td>
                            <td>
                                <fmt:formatDate value="${invitation.createdate}" pattern="yyyy-MM-dd"></fmt:formatDate>
                            </td>
                            <td>
                                <a href="javascript:cat(${invitation.id})">查看回复</a> ||
                                <a href="javascript:del(${invitation.id})">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <!--分页组件-->
                <ul id="page"></ul>
            </div>
        </div>
    </div>
    <script>
        $(function() {
            var currentPage = ${pageInfo.pageNum};
            var totalPages = ${pageInfo.pages};
            $("#page").bootstrapPaginator({
                bootstrapMajorVersion:3, //对应的bootstrap版本
                currentPage: currentPage, //当前页数
                numberOfPages: 10, //每次显示页数
                totalPages:totalPages, //总页数
                useBootstrapTooltip:false,
                itemTexts : function(type, page, current) {//设置分页按钮显示字体样式
                    switch (type) {
                        case "first":
                            return "首页";
                        case "prev":
                            return "上一页";
                        case "next":
                            return "下一页";
                        case "last":
                            return "末页";
                        case "page":
                            return page;
                    }
                },
                //点击事件
                onPageClicked: function (event, originalEvent, type, page) {
                    console.log(page);
                    // 业务处理
                    //page: 表示当前页码
                    //获取pageNum,赋值page
                    $("#pageNum").val(page);
                    //提交表单
                    $("#myForm").submit();
                }
            });
        });

        function cat(id){
            window.location.href="/invitation/cat/"+id;
        }
        function del(id){
            if(confirm("确认删除该条发帖及相关回复？")){
                window.location.href="/invitation/del/"+id;
            }
        }

        if(${delMsg !=null and delMsg !=''}){
            alert("${delMsg}");
        }
    </script>
</body>
</html>
