package service;

import dao.DeviceInfoDao;
import dao.UserInfoDao;
import model.DeviceInfo;
import model.UserInfo;

public class DeviceInfoServiceImpl implements DeviceInfoService {
	private UserInfoDao userInfoDao;
	private DeviceInfoDao deviceInfoDao;

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}
	public void setDeviceInfoDao(DeviceInfoDao deviceDao) {
		this.deviceInfoDao = deviceDao;
	}
	
	@Override
	public void add(UserInfo userInfo, DeviceInfo deviceInfo) {
		deviceInfo.getUserInfos().add(userInfo);
		deviceInfoDao.save(deviceInfo);
	}
	
	@Override
	public int checkPin(DeviceInfo deviceInfo) {
		return deviceInfoDao.checkDevicePin(deviceInfo);
	}
	
	@Override
	public void delete(DeviceInfo deviceInfo) {
		deviceInfoDao.delete(DeviceInfo.class, deviceInfo.getDeviceid());
	}
	
	@Override
	public DeviceInfo get(int deviceid) {
		DeviceInfo deviceInfo = deviceInfoDao.get(DeviceInfo.class,deviceid);	
		deviceInfo.getUserInfos().size();
		return deviceInfo;
	}
	@Override
	public void update(DeviceInfo deviceInfo) {
		deviceInfoDao.update(deviceInfo);
		
	}








}
