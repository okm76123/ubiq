package action;

import model.DeviceInfo;
import model.UserInfo;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.DeviceInfoService;
import service.UserInfoService;

import com.opensymphony.xwork2.ActionSupport;

public class DeviceInfoAction extends ActionSupport{
	private UserInfoService userInfoService;
	private DeviceInfoService deviceInfoService;
	private DeviceInfo deviceInfo;
	private UserInfo userInfo;
	private int userid;
	
	public String execute() throws Exception {
		userInfo = userInfoService.get(userid);
		return SUCCESS;
	}

	@SkipValidation
	public String addForm() throws Exception {
		return SUCCESS;
	}
	
	public String link() throws Exception {;
		int deviceid = deviceInfoService.checkPin(deviceInfo);
	    DeviceInfo TempDeviceInfo = deviceInfoService.get(deviceid);
	    TempDeviceInfo.setNickName(deviceInfo.getNickName());
	    deviceInfoService.update(TempDeviceInfo);
		return SUCCESS;
	}	
	
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public DeviceInfoService getDeviceInfoService() {
		return deviceInfoService;
	}

	public void setDeviceInfoService(DeviceInfoService deviceInfoService) {
		this.deviceInfoService = deviceInfoService;
	}

}
