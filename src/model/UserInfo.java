package model;

// Generated 2015. 2. 11 ���� 7:13:18 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * UserInfo generated by hbm2java
 */
@Entity
@Table(name = "user_info", catalog = "ubiq")
public class UserInfo implements java.io.Serializable {

	private Integer userid;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Set<DeviceInfo> deviceInfos = new HashSet<DeviceInfo>(0);

	public UserInfo() {
	}

	public UserInfo(String email, String password, String firstName,
			String lastName, Set<DeviceInfo> deviceInfos) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.deviceInfos = deviceInfos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userid", unique = true, nullable = false)
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "first_name", length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_info_has_device_info", catalog = "ubiq", joinColumns = { @JoinColumn(name = "user_info_userid", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "device_info_deviceid", nullable = false, updatable = false) })
	public Set<DeviceInfo> getDeviceInfos() {
		return this.deviceInfos;
	}

	public void setDeviceInfos(Set<DeviceInfo> deviceInfos) {
		this.deviceInfos = deviceInfos;
	}

}
