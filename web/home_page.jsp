<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <title>首页</title>
  <link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
  <script type="text/javascript" src="js/jquery-3.2.1.js" ></script>
  <script type="text/javascript" src="bootstrap/js/bootstrap.js" ></script>
  </script>
  <script src="./js/list.js"></script>
  <style>
    *{
      border-radius: 0px !important;
    }
    #content{
      min-height: 500px;
    }
    #iframe{
      position: absolute;
      top: 0;
      bottom: 0;
      border: 0px;
      width: 100%;
      height: 100%;
      padding-right: 20px;
    }
  </style>
</head>
<body>
<!-- 导航条 -->
<div class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a href="home_page.jsp" class="navbar-brand">仓库管理系统</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li class="dropdown">
        <a href="" class="dropdown-toggle" data-toggle="dropdown" >
          ${u.username}&nbsp;<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li>
            <a href="home_page_copy.jsp">
              <span class="glyphicon glyphicon-user"></span>
              个人信息
            </a>
          </li>
          <li role="separator" class="divider"></li>
          <li>
            <a href="logoutServlet">
              <span class="glyphicon glyphicon-log-out"></span>
              安全退出
            </a>
          </li>
        </ul>
      </li>
    </ul>
  </div>
</div>
<!-- 菜单和内容区域 -->
<div class="container-fluid">
  <!-- 菜单 -->
  <div class="col-md-2 col-sm-2 col-xs-5" id="menu">
    <div class="list-group">
      <a href="goods_list.jsp" class="list-group-item" target="page"><span class="glyphicon glyphicon-list"></span>&nbsp;仓库列表</a>
      <a href="add_goods.jsp" class="list-group-item" target="page"><span class="glyphicon glyphicon-cloud-upload"></span>&nbsp;仓库添加</a>
      <a href="personal_information.jsp"  class="list-group-item" target="page"><span class="glyphicon glyphicon-user"></span>&nbsp;个人信息</a>
      <a href="change_password.jsp" class="list-group-item" target="page"><span class="glyphicon glyphicon-cloud-upload"></span>&nbsp;修改密码</a>
      <a href="client.jsp"  class="list-group-item" target="page"><span class="glyphicon glyphicon-user"></span>&nbsp;客户信息</a>
      <a href="logoutServlet" class="list-group-item"><span class="glyphicon glyphicon-log-out"></span>&nbsp;安全退出</a>
    </div>

  </div>
  <!-- 内容 -->
  <div class="col-md-10 col-sm-10 col-xs-7" id="content">
    <iframe id="iframe" name="page" src="goods_list.jsp"></iframe>
  </div>

  <!-- 版权区 -->
  <p class="text-center">&copy;财校 By Mr.Liu</p>
</div>
</body>
</html>
