package dao;

import model.UserInfo;

public interface UserInfoDao extends BaseDao<UserInfo> {
	int checkLogin(UserInfo userInfo);
	boolean checkEmail(String email);
}
