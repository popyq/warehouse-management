
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分页</title>
</head>
<body>
<form id="subPage_form" method="get" action="${pageInfo.uri}">
  <input type="hidden" name="method" value="${pageInfo.method}">
  <input id="page_currentPage" type="hidden" name="currentPage" value="">
</form>
<script>
  function pageDirect(currentPage){
    alert(currentPage)
    document.getElementById("page_currentPage").value = currentPage;
    document.getElementById("subPage_form").submit();
  }
</script>


<nav aria-label="Page navigation example">
  <ul class="pagination justify-context-lg-end">
    <li class="page-item disabled">
      <a class="page-link">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;总记录数:${pageInfo.recordCount} | 每页记录数: ${pageInfo.recordSize} |  总页数:${pageInfo.currentPage}/${pageInfo.pageCount}</a></li>

    <c:choose>
      <c:when test="${1==pageInfo.currentPage}">
        <li class="page-item disabled">
          <a class="page-link"  href="javascript:void(0)" onclick="pageDirect(${pageInfo.currentPage-1})">上一页</a>
        </li>
      </c:when>
      <c:otherwise>
        <li class="page-item ">
          <a class="page-link" href="javascript:void(0)"  onclick="pageDirect(${pageInfo.currentPage-1})">上一页</a>
        </li>
      </c:otherwise>
    </c:choose>

    <c:forEach begin="1" end="${pageInfo.pageCount}" var="pageNum">
      <c:choose>
        <c:when test="${pageNaum == pageInfo.currentPage}">
          <li class="page-item disabled">
            <a class="page-link"  href="javascript:void(0)"  onclick="pageDirect(${pageNum})">${pageNum}</a>
          </li>
        </c:when>
        <c:otherwise>
          <li class="page-item ">
            <a class="page-link" href="javascript:void(0)"  onclick="pageDirect(${pageInfo.currentPage})">${pageNum}</a>
          </li>
        </c:otherwise>
      </c:choose>
    </c:forEach>


    <%-- 下一页  --%>
    <c:choose>
      <c:when test="${pageInfo.pageCount==pageInfo.currentPage}">
        <li class="page-item disabled">
          <a class="page-link"  href="javascript:void(0)"  onclick="pageDirect(${pageInfo.currentPage+1})">下一页</a>
        </li>
      </c:when>
      <c:otherwise>
        <li class="page-item ">
          <a class="page-link" href="javascript:void(0)"  onclick="pageDirect(${pageInfo.currentPage+1})">下一页</a>
        </li>
      </c:otherwise>
    </c:choose>
  </ul>
</nav>


</body>
</html>
