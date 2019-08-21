package com.example.demo;


import java.sql.Timestamp;


import lombok.NoArgsConstructor;
@NoArgsConstructor
public class MusicUnSub{
	public MusicUnSub(Long mid, String userId, String provinceCode, String userAccount, 
			String productCode, String serviceType, Timestamp launchTime, String channelId) {
		super();
		this.mid = mid;
		this.userId = userId;
		this.provinceCode = provinceCode;
		this.userAccount = userAccount;
		this.productCode = productCode;
		this.serviceType = serviceType;
		if (launchTime == null) {
			this.launchTime = null;
		} else {
			this.launchTime = (Timestamp) launchTime.clone();
		}
		this.channelId = channelId;
	}
	/**
	 * msg id
	 */
	private Long mid;

	/**
	 * 用户标识
	 */
	private String userId;
	/**
	 * 号码省编码
	 */
	private String provinceCode;
	/**
	 * 登录账号
	 */
	private String userAccount;
	/**
	 * 原产品code
	 */
	private String productCode;

	/**
	 * 业务类型serviceType
	 */
	private String serviceType;
	/**
	 * 发送时间
	 */
	private Timestamp launchTime;
	/**
	 * 渠道id
	 */
	private String channelId;

	public void setLaunchTime(Timestamp launchTime) {
		if (launchTime == null) {
			this.launchTime = null;
		} else {
			this.launchTime = (Timestamp) launchTime.clone();
		}
	}
	public Timestamp getLaunchTime() {
		if (launchTime == null) {
			return null;
		} else {
			return (Timestamp) launchTime.clone();
		}
	}
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
}
