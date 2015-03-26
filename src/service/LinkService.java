package service;

import model.DeviceInfo;
import model.UserInfo;

public interface LinkService {
	void unlinkUserAndDevice(UserInfo userInfo, DeviceInfo deviceInfo);
	void linkUserAndDevice(UserInfo userInfo, DeviceInfo deviceInfo);
}
