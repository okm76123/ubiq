package dao;

import model.DeviceInfo;

public interface DeviceInfoDao extends BaseDao<DeviceInfo>{
	int checkDevicePin(DeviceInfo deviceInfo) ;
}
