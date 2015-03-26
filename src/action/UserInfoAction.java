package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import model.UserInfo;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UserInfoService;

import com.opensymphony.xwork2.ActionSupport;

public class UserInfoAction extends ActionSupport {

	private int userid;
	private UserInfoService userInfoService;
	private UserInfo userInfo;
	private InputStream inputStream;
	private String email;
	private String checkemailResult;
	private String reEnterPassword;
	
	
	@SkipValidation
	public String addForm() throws Exception {
		return SUCCESS;
	}
	
	public String add() throws Exception {
		userInfoService.add(userInfo);
		return SUCCESS;
	}	
	
	@SkipValidation
	public String get() throws Exception {
		userInfo = userInfoService.get(userid);
		return SUCCESS;
	}
	
	@SkipValidation
	public String checkemail() throws Exception {
		String xml = "";
		if (email != null && userInfoService.checkemail(email)){
			xml = toXml("no_available");
		} else {
			xml = toXml("available");
		}
		setInputStream(new ByteArrayInputStream(xml.getBytes()));
		return SUCCESS;
	}
	
	public String toXml(String checkemailResult) throws UnsupportedEncodingException {
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding='UTF-8'?>\n");
		xml.append("<checkemailResult>");
		xml.append(checkemailResult);
		xml.append("</checkemailResult>\n");
		return xml.toString();
	}
	
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	public UserInfoService getUserInfoService() {
		return userInfoService;
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
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getReEnterPassword() {
		return reEnterPassword;
	}
	public void setReEnterPassword(String reEnterPassword) {
		this.reEnterPassword = reEnterPassword;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCheckemailResult() {
		return checkemailResult;
	}

	public void setCheckemailResult(String checkemailResult) {
		this.checkemailResult = checkemailResult;
	}

	
	
}
