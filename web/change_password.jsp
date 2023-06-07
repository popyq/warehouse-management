<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>修改密码</title>
  <link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
  <script type="text/javascript" src="js/jquery-3.2.1.js" ></script>
  <script type="text/javascript" src="layer/layer.js" ></script>
  <style>
    .content{
      margin-top: 20px;
    }
    .table{
      font-size: 10px;
    }
  </style>
</head>
<body>
<!-- 路径导航 -->
<ol class="breadcrumb">
  <li><a href="">修改密码</a></li>
</ol>
<!-- 面板 -->
<div class="panel panel-primary">
  <div class="panel-heading">用户详情</div>
  <div class="panel-body">
    <form action="changePasswordServlet" class="form-horizontal"  target="_parent">

      <!--     将id的数据隐藏起来,方便后面传给更新serlvlet.但是不显示到页面上 -->
      <input value="${sessionScope.u.id}" name="id" type="hidden">


      <div class="form-group form-group-sm">
        <label class="col-sm-2 col-md-1 control-label">用户名</label>
        <div class="col-sm-5 col-md-6">
          <input type="text" class="form-control" name="username"
                 id="music_name" readonly value="${sessionScope.u.username}">
        </div>
      </div>
      <div class="form-group form-group-sm">
        <label class="col-sm-2 col-md-1 control-label">原密码</label>
        <div class="col-sm-5 col-md-6">
          <input type="text" class="form-control" name="oldpwd" id="artist"
           value="${sessionScope.u.password}" readonly>
        </div>
      </div>
      <div class="form-group form-group-sm">
        <label class="col-sm-2 col-md-1 control-label">新密码</label>
        <div class="col-sm-5 col-md-6">
          <input type="text" class="form-control" id="ablum" name="newpwd" >
        </div>
      </div>

      <div class="form-group">
        <div class="col-sm-3 col-md-4 col-sm-offset-4">
          <a><button id="btn" type="submit" class="btn btn-primary btn-block">确认修改</button></a>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
</html>
