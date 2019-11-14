<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/9/29
  Time: 8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<s:property value="#request.tip"/><p>
    <s:form action="Userlogin" method="post">
        <s:textfield name="loginUser.account" label="请输入用户名"/>
        <s:password name="loginUser.password" label="请输入密码"/>
        <s:submit value="登录"/>
    </s:form>
</body>
</html>
