<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>仓库列表</title>
    <script type="text/javascript" src="js/jquery-3.2.1.js" ></script>
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
    <li><a href="">仓库列表</a></li>
</ol>
<!-- 按钮组 -->
<div class="btn-group" role="group">
    <form action="add_goods.jsp">
        <button type="submit" class="btn btn-primary btn-sm">
            <span class="glyphicon glyphicon-cloud-upload"></span>
            仓库添加
        </button>
    </form>
</div>
<!-- 面板  -->
<div class="panel panel-primary content">
    <div class="panel-heading">
        <span class="glyphicon glyphicon-list"></span>
        仓库列表
    </div>

    <div class="panel-body">
        <input value="${sessionScope.u.id}" name="uid" type="hidden">
        <!-- 列表表格 -->
        <table class="table table-bordered table-hover table-striped table-condensed text-center">
            <tr>
                <td>
                    <input type="checkbox" />
                </td>
                <td>序号</td>
                <td>货物对应ID</td>
                <td>货物名称</td>
                <td>货物数量</td>
                <td>生产地址</td>
                <td>入库时间</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${goods}" var="goodss" varStatus="v">

            <tr>
                    <td>
                        <input type="checkbox" />
                    </td>
                    <td>${v.index+1}</td>
                    <td>${goodss.id}</td>
                    <td>${goodss.name}</td>
                    <td>${goodss.num}</td>
                    <td>${goodss.site}</td>
                    <td>${goodss.time}</td>
                    <td>
                        <button class="btn btn-primary btn-xs"
                                onclick="mydetails(${goodss.id})">
                            <span class="glyphicon glyphicon-info-sign"></span>
                            修改
                        </button>
                        <button class="btn btn-danger btn-xs" onclick="myDelete(${goodss.id},${sessionScope.u.id})">
                            <span class="glyphicon glyphicon-trash"></span>
                            删除
                        </button>
                    </td>
                </tr>
            </c:forEach>
            <tr>

            </tr>
        </table>


    </div>
</div>
</body>
</html>
