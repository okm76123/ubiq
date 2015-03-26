//XMLHttpRequest returns either object or false
function newXMLHttpRequest() {
	var xmlreq = false;
	
	//if it is not IE, XMLHttpRequest object is created
	if (window.XMLHttpRequest) {
		xmlreq = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		try {
			//At IE latest version, XMLHttpRequest object is created
			xmlreq = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e1) {
			//if fail to request ActiveX object
			try {
				//previous version of IE is supported by this code
				xmlreq = new ActiveObjext("Microsoft.XMLHTTP");
			} catch (e2) {
				//if anyway cannot create XMLHttpRequset
				xmlreq = false;
			}
		}
	}
	return xmlreq;
}
	
//After stand by XMLHttpRequest, create callback method that
//XML response is returned to Handler 
/**
* req: status of XMLHttpRequest
* responseXmlHandler: function for XML response 
*/
	
function getReadyStateHandler(req, responseXmlHandler) {
		
	//return function that wait for XMLHttpRequest instance
	return function () {
			
		//if status of XMLHttpRequest is "complete"
		if (req.readyState == 4) {
				
			//validate if receive the response from server successfully
			if (req.status == 200) {
				//send XML response to handler
				responseXmlHandler(req.responseXML);
			} else {
				//if HTTP has problem
				alert("HTTP error" + req.status + ": " + req.statusText);
			}
		}
	}
}
