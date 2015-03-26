<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>ubiq1_0</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		function goLogin() {
			document.forms["login"].action = "login.action";
			document.forms["login"].submit();	
		}
		function goNewAccount() {
			window.location = 'addUserInfoForm.action';
		}
	
	</script>
</head>

<body>

	<h4>| main page |</h4>
	<form name="login" method="post">
	<table>
	<tr>
		<td colspan="2">
			<c:if test="${fieldErrors['userInfo.email'] != null}">
				<p style="color:red; display:inline;">${fieldErrors['userInfo.email']}</p>
			</c:if>
		</td>
	</tr>
	<tr>
		<td>email:</td>
		<td><input name="userInfo.email" type="text" /></td>
		
	</tr>
	
	<tr>
		<td>password:</td>
		<td><input name="userInfo.password" type="password" /></td>
	</tr>
	<tr>
		<td><input type="button" value="login" onclick="goLogin();"/></td>
		<td><input type="button" value="new account"onclick="goNewAccount();" /></td>
	</tr>
	</table>
	</form>
	<s:debug />
</body>

</html>