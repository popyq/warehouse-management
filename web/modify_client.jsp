<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>客户信息修改</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
    <script type="text/javascript" src="js/jquery-3.2.1.js" ></script>
    <script type="text/javascript" src="layer/layer.js" ></script>
    <script src="./js/xhr.js"></script>
    <script src="./js/list.js"></script>

</head>
<body>
<!-- 路径导航 -->
<ol class="breadcrumb">
    <li><a href="">客户信息修改</a></li>
</ol>
<!-- 面板 -->
<div class="panel panel-primary">
    <div class="panel-heading">客户信息修改</div>
    <div class="panel-body">
        <form action="updateClientServlet" class="form-horizontal">

            <input value="${sessionScope.u.id}" name="uid" type="hidden">

            <div class="form-group form-group-sm">
                <label class="col-sm-2 col-md-1 control-label">客户编号</label>
                <div class="col-sm-5 col-md-6">
                    <input type="text" class="form-control" name="clientId" id="clientId"  value="${c.clientId}" readonly >
                </div>
            </div>

            <div class="form-group form-group-sm">
                <label class="col-sm-2 col-md-1 control-label">客户姓名</label>
                <div class="col-sm-5 col-md-6">
                    <input type="text" class="form-control" name="name" value="${c.name}" readonly>
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label class="col-sm-2 col-md-1 control-label">客户性别</label>
                <div class="col-sm-5 col-md-6">
                    <input type="text" class="form-control" name="gender" id="gender" value="${c.gender}" readonly>
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label class="col-sm-2 col-md-1 control-label">货物ID</label>
                <div class="col-sm-5 col-md-6">
                    <input type="text" class="form-control" name="goodsId" value="${c.goodsId}" >
                </div>
            </div>

            <div class="form-group form-group-sm">
                <label class="col-sm-2 col-md-1 control-label">需求数量</label>
                <div class="col-sm-5 col-md-6 music_style">
                    <input type="text" class="form-control" id="goodsNum" name="goodsNum"  value="${c.goodsNum}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-3 col-md-4 col-sm-offset-4">
                    <button id="submit" class="btn btn-primary btn-block" >确认修改</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
