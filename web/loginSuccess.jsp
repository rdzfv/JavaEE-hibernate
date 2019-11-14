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
        <s:submit value="修改"/>
    </s:form>
    <s:form action="Userdelete" method="post">
        <s:hidden name="loginUser.customerId" value="%{#request.loginUser.customerId}"/>
        <s:submit value="删除"/>
    </s:form>
    <a href="./allItems">查看商品信息</a>
<table>
    <tr>
        <td>个人信息：</td>
    </tr>
    <tr>
        <td>用户名：</td>
        <td><s:property value="#request.loginUser.account"/></td>
    </tr>
    <s:iterator value="#request.loginUser.addresses" status="st">
    <tr>
        <td>地址<s:property value="#st.count"/>：</td>
    </tr>
    <tr>
        <td>详细地址：</td>
        <td><s:property value="detail"/></td>
    <tr>
        </s:iterator>
</table>
添加新地址：<br>
<s:form action="UseraddAddr" method="post">
    <s:hidden name="loginUser.customerId" value="%{#request.loginUser.customerId}"/>
    <s:textfield name="address.detail" label="详细地址"/>
    <s:textfield name="address.zipcode" label="邮政编码"/>
    <s:textfield name="address.phone" label="联系电话"/>
    <s:textfield name="address.type" label="地址类型（office,home,etc.）"/>
    <s:submit value="添加"/>
</s:form>
</body>
</html>
