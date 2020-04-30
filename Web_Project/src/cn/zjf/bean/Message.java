package cn.zjf.bean;

import com.google.gson.Gson;

public class Message {
	private int status;
	private String msg;
	private Object data;
	
	public String toJSON() {
		return new Gson().toJson(this);
	}

	public Message(int status, String msg, Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public Message(int status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	public Message(String msg, Object data) {
		super();
		this.msg = msg;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Message [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
}
