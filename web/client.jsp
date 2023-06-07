<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>客户信息</title>
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
    <script src="./js/client.js"></script>

</head>
<body>

<!-- 路径导航 -->
<ol class="breadcrumb">
    <li><a href="">客户信息</a></li>
</ol>
<!-- 面板  -->
<div class="panel panel-primary content">
    <div class="panel-heading">
        <span class="glyphicon glyphicon-list"></span>
        客户信息
    </div>

    <div class="panel-body">
        <!-- 列表表格 -->
        <table class="table table-bordered table-hover table-striped table-condensed text-center">
            <tr>
                <td>客户编号</td>
                <td>客户名字</td>
                <td>客户性别</td>
                <td>客户年龄</td>
                <td>货物ID</td>
                <td>货物数量</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${client}" var="clients" varStatus="v">
            <tr>
                <td>${clients.clientId}</td>
                <td>${clients.name}</td>
                <td>${clients.gender}</td>
                <td>${clients.age}</td>
                <td>${clients.goodsId}</td>
                <td>${clients.goodsNum}</td>
                <td>
                    <button class="btn btn-primary btn-xs"
                            onclick="clientDetails(${clients.clientId})">
                        <span class="glyphicon glyphicon-info-sign"></span>
                        修改
                    </button>

                    <button class="btn btn-danger btn-xs" onclick="clientDelete(${clients.clientId},${sessionScope.u.id})">
                        <span class="glyphicon glyphicon-trash"></span>
                        删除
                    </button>
                </td>
            </tr>
            </c:forEach>

        </table>
    </div>
</div>
</body>
</html>
