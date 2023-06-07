<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>仓库添加</title>
  <link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
  <script type="text/javascript" src="js/jquery-3.2.1.js" ></script>
  <script type="text/javascript" src="layer/layer.js" ></script>
  <script>
  </script>
</head>
<body>
<!-- 路径导航 -->
<ol class="breadcrumb">
  <li><a href="">仓库添加</a></li>
</ol>
<!-- 面板 -->
<div class="panel panel-primary">
  <div class="panel-heading">仓库添加</div>
  <div class="panel-body">
    <form action="addGoodsServlet" class="form-horizontal">
      <input value="${sessionScope.u.id}" name="uid" type="hidden">
      <div class="form-group form-group-sm">
        <label class="col-sm-2 col-md-1 control-label">货物ID</label>
        <div class="col-sm-5 col-md-6">
          <input type="text" class="form-control" name="id" placeholder="货物ID">
        </div>
      </div>
      <div class="form-group form-group-sm">
        <label class="col-sm-2 col-md-1 control-label">货物名称</label>
        <div class="col-sm-5 col-md-6">
          <input type="text" class="form-control" name="name" placeholder="货物名称">
        </div>
      </div>
      <div class="form-group form-group-sm">
        <label class="col-sm-2 col-md-1 control-label">货物数量</label>
        <div class="col-sm-5 col-md-6">
          <input type="text" class="form-control" name="num" placeholder="货物数量">
        </div>
      </div>
      <div class="form-group form-group-sm">
        <label class="col-sm-2 col-md-1 control-label">生产地址</label>
        <div class="col-sm-5 col-md-6">
          <input type="text" class="form-control" name="site" placeholder="生产地址">
        </div>
      </div>

      <div class="form-group">
        <div class="col-sm-3 col-md-4 col-sm-offset-4">
          <button id="btn" type="submit" class="btn btn-primary btn-block">确认添加</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
</html>
