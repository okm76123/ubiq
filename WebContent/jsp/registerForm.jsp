<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserInfoForm</title>
</head>
<body>
	<s:form action="addUserInfo" >
		<s:textfield name="userInfo.email" label="email:"/>
		<br/>
		<s:textfield name="userInfo.password" label="password:"/>
		<s:submit value="submit"/> 
	</s:form>
</body>
</html>