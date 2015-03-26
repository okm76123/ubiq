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
	<script type="text/javascript">
	
		function goSave() {
			document.forms["newDevice"].action = "addDeviceInfo.action";
			document.forms["newDevice"].submit();	
		}
		
		function goPrev() {
			window.location = 'jsp/myDevice.jsp';
		}
	
	</script>
</head>

<body>
	<h4>|new device|</h4>
	
	<s:form name="newDevice" method="post" theme="simple">
	
	<table>
	<tr>
		<td>device name</td>
		<td><input type="text" name="deviceInfo.name"/></td>		
	</tr>
	<tr>
		<td>device pin</td>
		<td><input type="text" name="deviceInfo.pin"/></td>	
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