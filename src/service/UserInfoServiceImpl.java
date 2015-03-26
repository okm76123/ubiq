package service;

import java.util.List;

import model.DeviceInfo;
import model.UserInfo;
import dao.DeviceInfoDao;
import dao.UserInfoDao;


public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDao userInfoDao;
	private DeviceInfoDao deviceInfoDao;

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}
	public void setDeviceInfoDao(DeviceInfoDao deviceInfoDao) {
		this.deviceInfoDao = deviceInfoDao;
	}
	
	@Override
	public int add(UserInfo userInfo){
		return(Integer) userInfoDao.save(userInfo);
	}
	
	@Override
	public UserInfo get(int userid) {
		UserInfo userInfo = userInfoDao.get(UserInfo.class,userid);	
		userInfo.getDeviceInfos().size();
		return userInfo;
	}
	
	@Override
	public List<UserInfo> getAll(){
		return userInfoDao.findAll(UserInfo.class);
	}
	
	@Override
	public void delete(UserInfo userInfo){
		userInfoDao.delete(UserInfo.class, userInfo.getUserid());
	}

	@Override
	public int checkLogin(UserInfo userInfo) {
		return userInfoDao.checkLogin(userInfo);
	}

	@Override
	public boolean checkemail(String email) {
		return userInfoDao.checkEmail(email);
	}

	@Override
	public void update(UserInfo userInfo) {
		userInfoDao.update(userInfo);		
	}
	
	
	


	
}
