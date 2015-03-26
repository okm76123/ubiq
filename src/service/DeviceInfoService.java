package service;

import model.DeviceInfo;
import model.UserInfo;

public interface DeviceInfoService {
	void add(UserInfo userInfo, DeviceInfo deviceInfo);
	int checkPin(DeviceInfo deviceInfo);
	void delete(DeviceInfo deviceInfo);
	DeviceInfo get(int deviceid);
	void update(DeviceInfo deviceInfo);
}
