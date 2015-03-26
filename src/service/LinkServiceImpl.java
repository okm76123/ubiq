package service;

import dao.DeviceInfoDao;
import dao.UserInfoDao;
import model.DeviceInfo;
import model.UserInfo;

public class LinkServiceImpl implements  LinkService{
	private UserInfoDao userInfoDao;
	private DeviceInfoDao deviceInfoDao;

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}
	public void setDeviceInfoDao(DeviceInfoDao deviceInfoDao) {
		this.deviceInfoDao = deviceInfoDao;
	}	
	
	@Override
	public void unlinkUserAndDevice(UserInfo userInfo, DeviceInfo deviceInfo) {
		userInfo = userInfoDao.get(UserInfo.class, userInfo.getUserid());
		deviceInfo = deviceInfoDao.get(DeviceInfo.class,  deviceInfo.getDeviceid());
		userInfo.getDeviceInfos().remove(deviceInfo);
		userInfoDao.save(userInfo);
	}
	
	@Override
	public void linkUserAndDevice(UserInfo userInfo, DeviceInfo deviceInfo) {
		userInfo = userInfoDao.get(UserInfo.class, userInfo.getUserid());
		deviceInfo = deviceInfoDao.get(DeviceInfo.class,  deviceInfo.getDeviceid());
		deviceInfo.getUserInfos().add(userInfo);
		deviceInfoDao.update(deviceInfo);
	}
	

}
