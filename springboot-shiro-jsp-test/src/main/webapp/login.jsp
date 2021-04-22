<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>life.jsp</title>
</head>
<body>
  <h1>登录页V1.0</h1>
  <form action="${pageContext.request.contextPath}/user/login" method="post">
      用户名：<input type="text" name="username"> </br>
      密码：<input type="text" name="password"> </br>
      <input type="submit" value="登录">
  </form>


</body>
</html>