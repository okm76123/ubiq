package dao;

import java.util.List;
import model.UserInfo;

public class UserInfoHibernate4 extends BaseDaoHibernate4<UserInfo> implements UserInfoDao {

	@Override
	public boolean checkEmail(String email) {
		String hql = "from UserInfo where email = ?0";
		List<UserInfo> list = find(hql, email);
		if(null == list || 0 == list.size()){
			return false;    
		}
		return true;
	}
	
	@Override
	public int checkLogin(UserInfo userInfo){
		String hql = "from UserInfo where email = ?0 and password = ?1";
		List<UserInfo> list = find(hql, userInfo.getEmail(), userInfo.getPassword());
		if(null == list || 0 == list.size()){
			return -1;    
		}
		userInfo.setUserid(list.get(0).getUserid());
		return userInfo.getUserid();
	}




	
	
}
