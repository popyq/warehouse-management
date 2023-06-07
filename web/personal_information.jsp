<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>个人信息</title>
  <link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
  <style>
    .content{
      margin-top: 20px;
    }
    .table{
      font-size: 10px;
    }
  </style>
  <script src="./js/xhr.js"></script>
  <script src="./js/list.js"></script>

</head>
<body>

<!-- 路径导航 -->
<ol class="breadcrumb">
  <li><a href="">个人信息</a></li>
</ol>
<!-- 按钮组 -->
<div class="btn-group" role="group">
  <form action="change_password.jsp">
    <button type="submit" class="btn btn-primary btn-sm">
      <span class="glyphicon glyphicon-cloud-upload"></span>
      修改密码
    </button>
  </form>
</div>
<!-- 面板  -->
<div class="panel panel-primary content">
  <div class="panel-heading">
    <span class="glyphicon glyphicon-list"></span>
    个人信息
  </div>

  <div class="panel-body">
    <!-- 列表表格 -->
    <table class="table table-bordered table-hover table-striped table-condensed text-center">
      <tr>
        <td>管理员ID</td>
        <td>管理员账号</td>
        <td>年龄</td>
        <td>性别</td>
      </tr>
        <tr>
          <td>${u.id}</td>
          <td>${u.username}</td>
          <td>${u.age}</td>
          <td>${u.gender}</td>
        </tr>
    </table>
  </div>
</div>
</body>
</html>
