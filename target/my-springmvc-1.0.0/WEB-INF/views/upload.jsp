<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangdan
  Date: 2019/2/28
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
  <form enctype="multipart/form-data" method="post" action="/upload">
      <label for="head">上传头像</label>
      <input name="head" id="head" type="file" value="上传头像">
      <input type="submit" value="提交">
  </form>
    <%--因为要用JSP标签库，在pom添加JSTL标签库--%>
 <c:if test="${head_data!=null}">
     <img src="${head_data}">
 </c:if>
</body>
</html>
