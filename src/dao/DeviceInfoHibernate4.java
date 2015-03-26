package dao;

import java.util.List;

import model.DeviceInfo;

public class DeviceInfoHibernate4 extends BaseDaoHibernate4<DeviceInfo> implements DeviceInfoDao{

	@Override
	public int checkDevicePin(DeviceInfo deviceInfo) {
		String hql = "from DeviceInfo where device_pin = ?0";
		List<DeviceInfo> list = find(hql, deviceInfo.getPin());
		if(null == list || 0 == list.size()){
			return -1;    
		}
		return list.get(0).getDeviceid();
	}
	
}
