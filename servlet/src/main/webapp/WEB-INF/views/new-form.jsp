<%--
  Created by IntelliJ IDEA.
  User: yushinkim
  Date: 24. 3. 27.
  Time: 오후 5:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<!-- 상대 경로 사용 -->
<form action="save" method="post">
  username: <input type="text" name="username" />
  age: <input type="text" name="age" />
  <button type="submit">전송</button>
</form>

</body>
</html>
