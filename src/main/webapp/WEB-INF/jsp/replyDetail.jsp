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
            <div class="col-lg-6 col-md-offset-3">
                <h3>回复信息列表</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 col-md-offset-9">
                <a href="/invitation/addUI/${id}">添加回复</a> &nbsp;&nbsp;
                <a href="/invitation/list">返回帖子列表</a>
            </div>
        </div>
        <div class="row">
            <table class="table table-bordered table-striped table-hover">
                <tr>
                    <th>回复内容</th>
                    <th>回复昵称</th>
                    <th>发布时间</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="replyDetail">
                    <tr align="center">
                        <td>${replyDetail.content}</td>
                        <td>${replyDetail.author}</td>
                        <td>
                            <fmt:formatDate value="${replyDetail.createdate}" pattern="yyyy-MM-dd"></fmt:formatDate>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <!--分页组件-->
                <ul id="page"></ul>
            </div>
        </div>
    </div>
    <script th:inline="javascript">
        $(function() {
            var currentPage = ${pageInfo.pageNum};
            var totalPages = ${pageInfo.pages};
            //帖子的id
            var id = ${id};
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
                    window.location.href = "/invitation/cat/" + id + "?pageNum="+page;
                }
            });
        });

        if(${addMsg !=null and addMsg !=''}){
            alert("${addMsg}");
        }
    </script>
</body>
</html>
