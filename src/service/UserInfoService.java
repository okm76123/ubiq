package service;

import java.util.List;

import model.DeviceInfo;
import model.UserInfo;

public interface UserInfoService {
	int add(UserInfo userInfo);
	UserInfo get(int userid);
	List<UserInfo> getAll();
	void delete(UserInfo userInfo);
	int checkLogin(UserInfo userInfo);
	boolean checkemail(String email);
	void update(UserInfo userInfo);
	
	
}
