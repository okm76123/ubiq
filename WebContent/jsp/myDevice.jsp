<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>userInfoForm.jsp</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />

<head>

<body>
	<h4>|my device|</h4>
	<h4>Hello, ${userInfo.firstName} !</h4>
	<ul>
		<li>
			my devices
		</li>
		<li>
			<s:url id="url" action="addDeviceInfoForm" />
			<s:a href="%{url}">add device</s:a>
		</li>
	</ul>
</body>
<s:debug/>
</html>