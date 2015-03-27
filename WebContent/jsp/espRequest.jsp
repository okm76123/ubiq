<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script language="javascript" src="script/ajax.js"></script>
	<script language="javascript">
		
		function on() {
			var req = newXMLHttpRequest();
			req.open("GET", "http://172.25.66.38?ON ", true); 
			req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			req.timeout = 100;
			req.send();
			var body = document.getElementById('body');
			body.innerHTML+="<p>Off</p>";
		}
		function off() {
			var req = newXMLHttpRequest();
			req.open("GET", "http://172.25.66.38?OFF", true); 
			req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			req.timeout = 100;
			req.send();
			var body = document.getElementById('body');
			body.innerHTML+="<p>Off</p>";
		}
	</script>
	
</head>

<body id="body">
	<input type="button" onclick="on()" value=" On "/>
	<input type="button" onclick="off()" value=" Off " />
</body>

</html>