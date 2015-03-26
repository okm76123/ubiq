package action;

import model.UserInfo;
import service.UserInfoService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;

public class LoginAction extends ActionSupport{
	
	private UserInfoService userInfoService;
	private UserInfo userInfo;
	private int userid;
	
	@EmailValidator(
			fieldName = "userInfo.email",
			message = "email is not valid")
	public String execute() throws Exception {
		userid = userInfoService.checkLogin(userInfo);
		if (userid != -1){
			return SUCCESS;
		} else {
			addFieldError("userInfo.email", "email or password is not valid");
			return "input";
		}
	}
	
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
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
	
	
}
