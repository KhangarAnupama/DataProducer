package com.anupama.ks.consumer.service;

public class DeviceTO {
	
	private String data;
	private String macAddress;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	@Override
	public String toString() {
		return "DeviceTO [data=" + data + ", macAddress=" + macAddress + "]";
	}
	
}
