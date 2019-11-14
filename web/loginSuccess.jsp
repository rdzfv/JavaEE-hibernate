<%@ page import="org.apache.struts2.ServletActionContext" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/9/29
  Time: 8:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<s:property value="#request.tip"/>
<p> 修改个人信息
<p>
    <s:form action="Userupdate" method="post">
        <s:hidden name="loginUser.customerId" value="%{#request.loginUser.customerId}"/>
        <s:textfield name="loginUser.account" label="用户名不能修改" value="%{#request.loginUser.account}" readonly="true"/>
        <s:textfield type="password" name="loginUser.password" label="修改密码" value="%{#request.loginUser.password}"/>
        <s:textfield type="text" name="loginUser.birthday" label="修改生日" value="%{#request.loginUser.birthday}"/>
        <s:textfield type="text" name="loginUser.name" label="修改姓名" value="%{#request.loginUser.name}"/>
        <s:textfield type="text" name="loginUser.sex" label="修改性别" value="%{#request.loginUser.sex}"/>
        <s:textfield type="text" name="loginUser.contactInfo.phone" label="修改电话号码"
                     value="%{#request.loginUser.contactInfo.phone}"/>
        <s:textfield type="text" name="loginUser.contactInfo.email" label="修改邮箱"
                     value="%{#request.loginUser.contactInfo.email}"/>
        <s:textfield type="text" name="loginUser.contactInfo.address" label="修改住址"
                     value="%{#request.loginUser.contactInfo.address}"/>
        <s:textfield type="text" name="loginUser.contactInfo.zipcode" label="修改邮编"
                     value="%{#request.loginUser.contactInfo.zipcode}"/>
        <s:textfield type="text" name="loginUser.contactInfo.fax" label="修改传真"
                     value="%{#request.loginUser.contactInfo.fax}"/>
        <s:submit value="修改"/>
    </s:form>
    <s:form action="Userdelete" method="post">
        <s:hidden name="loginUser.customerId" value="%{#request.loginUser.customerId}"/>
        <s:submit value="删除"/>
    </s:form>
    <a href="./allItems">查看商品信息</a>
</body>
</html>
