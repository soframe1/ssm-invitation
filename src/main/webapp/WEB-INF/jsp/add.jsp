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
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-2 col-md-offset-2">
                <h3>添加回复</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <form action="/invitation/add/${id}" method="post" class="form-horizontal">
                    <div class="form-group">
                        <label for="inputFuifu" class="col-md-3 control-label">回复内容：</label>
                        <div class="col-md-9">
                            <textarea class="form-control" name="content" id="inputFuifu" rows="3"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputFuifu1" class="col-md-3 control-label">回复昵称：</label>
                        <div class="col-md-9">
                            <input type="text" name="author" id="inputFuifu1" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-primary">提交</button>
                            <%--注意：这里必须要设置type="button"，否则chrome默认为submit--%>
                            <button type="button" class="btn btn-warning" onclick="window.history.back(-1);">返回</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script>

    </script>
</body>
</html>
