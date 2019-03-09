<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>用户注册</h2>

<form action="${pageContext.request.contextPath}/regist" method="post" name="registForm">
    username:<input name="username"><br>
    password:<input type="password" name="password"/><br>
    age     :<input name="age"/><br>
    <input type="submit" value="注册"/>


</form>
</body>
</html>
