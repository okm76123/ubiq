package action.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.DeviceInfo;

import org.apache.struts2.ServletActionContext;

import service.DeviceInfoService;

import com.opensymphony.xwork2.ActionSupport;

public class RespondEspAction extends ActionSupport{
	
	private String espPin;
	private String espStatus;
	private DeviceInfo deviceInfo;
	private DeviceInfoService deviceInfoService;
	private InputStream inputStream;
	
	public void update() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String espIp = request.getHeader("X-FORWARDED-FOR");  
		if (espIp == null) {
			espIp = request.getRemoteAddr();  
		}
		deviceInfo = deviceInfoService.get(3);
		deviceInfo.setPin(espPin);
		deviceInfo.setStatus(espStatus);
		deviceInfo.setIp(espIp);
		deviceInfoService.update(deviceInfo);
		
		System.out.println(espPin);
		System.out.println(espStatus);
		System.out.println(espIp);
	}
	
	public String get() throws Exception {
		deviceInfo = deviceInfoService.get(3);
		String xml = toXml(deviceInfo);
		setInputStream(new ByteArrayInputStream(xml.getBytes()));
		return SUCCESS;
	}
	
	public String toXml(DeviceInfo deviceInfo) throws UnsupportedEncodingException {
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding='UTF-8'?>\n");
		xml.append("<device>");
		xml.append("<status>");
		xml.append(deviceInfo.getStatus());
		xml.append("</status>\n");
		xml.append("<ip>");
		xml.append(deviceInfo.getIp());
		xml.append("</ip>\n");
		xml.append("</device>\n");
		return xml.toString();
	}
	
	public String getEspPin() {
		return espPin;
	}

	public void setEspPin(String espPin) {
		this.espPin = espPin;
	}

	public String getEspStatus() {
		return espStatus;
	}

	public void setEspStatus(String espStatus) {
		this.espStatus = espStatus;
	}

	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public DeviceInfoService getDeviceInfoService() {
		return deviceInfoService;
	}

	public void setDeviceInfoService(DeviceInfoService deviceInfoService) {
		this.deviceInfoService = deviceInfoService;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	
}
