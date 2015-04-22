<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<!--[if lt IE 9]>
			<script src="script/html5shiv.js"></script>
	<![endif]--> 
	
	<script type="text/javascript" src="script/jquery-1.11.2.min.js"></script>
	
	<script type="text/javascript">
		
		var espIp;
		var espStatus;
		
		$(function() {
			$("#on").click(function() {
				$('#check').html("http://" + espIp + "?ONN");
				$.ajax({
					url: "http://" + espIp + "?ONN",
					type: "get",
			    	timeout: 1000
				});
			});  
		});
			
		$(function() {
			$("#off").click(function() {
				$('#check').html("http://" + espIp + "?OFF");
				$.ajax({
					url: "http://" + espIp + "?OFF",
					type: "get",
			    	timeout: 1000
				});
			});
		});
		
		$(document).ready(function() {
			setInterval(function(){
					$.ajax({
						url: "getRespondEsp.action",
						type: "get",
						dataType: "xml",
				    	timeout: 1000,
				    	success: function(xml) {
				    		espIp = $(xml).find("ip").text();
				    		espStatus = $(xml).find("status").text();
				    		$('#status').html(espStatus);
				    		$('#ip').html(espIp);
						}
					});        
			}, 1000);
		});
			
	</script>
	
</head>

<body id="body">
	<p id="status"></p>
	<p id="ip"></p>
	<p id="check"></p>
	<input type="button" id="on" value=" On "/>
	<input type="button" id="off" value=" Off " />
</body>

</html>