package com.lambdaexpression.notificationfiltering;

public class Alert {
	private String type;
	private String msg;
	Alert(String type,String msg){
		this.type=type;
		this.msg=msg;
	}
	public String getType() {
		return type;
	}
	public String getMsg() {
		return msg;
	}
	public String toString() {
		return "type: " + type + "msg : "+ msg;
	}

}