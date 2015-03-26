//recall Ajax to check email in a way of asynchronized
//email: userInfo.email
//create XmlHttpRequest object
//set handler using XHR property of onreadystatechange
function checkemail() {
	var email = document.getElementsByName("userInfo.email")[0].value;
	var req = newXMLHttpRequest(); 
	req.onreadystatechange = getReadyStateHandler(req, getCheckemailResult);
	req.open("POST", "checkemail.action", true);
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	req.send("email=" + email);
}

//get result from server 
//assign checkemailresultfromxml to hidden tag 
//(this tag field will be used for userInfoAvtion-validation.xml)
function getCheckemailResult(xml) {
	var checkemailResultFromXml = xml.getElementsByTagName("checkemailResult")[0].firstChild.nodeValue;
	document.getElementsByName("checkemailResult")[0].value = checkemailResultFromXml;
	if (checkemailResultFromXml == "no_available") {
		document.getElementById("checkemailResult").innerHTML = "[email address is already used]";
	} else {
		document.getElementById("checkemailResult").innerHTML = "";
	}
}
