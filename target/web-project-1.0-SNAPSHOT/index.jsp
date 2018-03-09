<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/test/init" method="post">
    <input type="hidden" name="token" value="${token}">
    <input type="text" name="测试">
    <input type="submit">
</form>
</body>
</html>