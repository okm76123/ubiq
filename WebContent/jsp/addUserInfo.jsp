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
	<script language="javascript" src="script/ajax.js"></script>
	<script language="javascript" src="script/checkemail.js"></script>
	<script type="text/javascript">
		function goSave() {
			document.forms["newAccount"].action = "addUserInfo.action";
			document.forms["newAccount"].submit();	
		}
		function goPrev() {
			window.location = 'index.jsp';
		}
	</script>
</head>

<body>
	
	<h4>|new account|</h4>
	
	<s:form name="newAccount" method="post" theme="simple">
	<input type="hidden" name="checkemailResult" value="${checkemailResult }" />
	<table>
	<tr>
		<td>email</td>
		<td><input type="text" name="userInfo.email" value="${userInfo.email }" onblur="checkemail()"/></td>	
		<td><p id="checkemailResult" style="color:red; display:inline;">${fieldErrors['userInfo.email']}${fieldErrors['checkemailResult']}</p></td>		
	</tr>
	<tr>
		<td>password</td>
		<td><input type="password" name="userInfo.password"/></td>
		<td><p style="color:red; display:inline;">${fieldErrors['userInfo.password']}</p></td>		
	</tr>
	<tr>
		<td>re-enter password</td>
		<td><input type="password" name="reEnterPassword"/></td>
		<td><p style="color:red; display:inline;">${fieldErrors['reEnterPassword']}</p></td>		
	</tr>
	<tr>
		<td>first name</td>
		<td><input type="text" name="userInfo.firstName" value="${userInfo.firstName }"/></td>	
		<td><p style="color:red; display:inline;">${fieldErrors['userInfo.firstName']}</p></td>		
	</tr>
	<tr>
		<td>last name</td>
		<td><input type="text" name="userInfo.lastName" value="${userInfo.lastName }"/></td>
		<td><p style="color:red; display:inline;">${fieldErrors['userInfo.lastName']}</p></td>		
	</tr>
	<tr>
		<td></td>
		<td colspan="2">
			<input type="button" value="submit" onclick="goSave();" method="add"/>
			<input type="button" value="cancel" onclick="goPrev();" />
		</td>		
	</tr>
	</table>
	
	</s:form>
	<s:debug />
</body>

</html>