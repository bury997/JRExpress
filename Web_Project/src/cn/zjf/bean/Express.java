package cn.zjf.bean;

import java.sql.Timestamp;

public class Express {
	//编号
	private int id;
	//快递单号
	private String eNumber;
	//快递公司
	private String company;
	//收件人姓名
	private String userName;
	//收件人手机号
	private String userPhone;
	//快件状态
	private int status;
	// 入库时间
	private Timestamp inTime;
	//取件时间
	private Timestamp outTime;
	//录入人手机号
	private String inputPhone;
	//取件码
	private int code;
	public Express(String eNumber, String company, String userName, String userPhone, String inputPhone) {
		super();
		this.eNumber = eNumber;
		this.company = company;
		this.userName = userName;
		this.userPhone = userPhone;
		this.inputPhone = inputPhone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((eNumber == null) ? 0 : eNumber.hashCode());
		result = prime * result + id;
		result = prime * result + ((inTime == null) ? 0 : inTime.hashCode());
		result = prime * result + ((inputPhone == null) ? 0 : inputPhone.hashCode());
		result = prime * result + ((outTime == null) ? 0 : outTime.hashCode());
		result = prime * result + status;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPhone == null) ? 0 : userPhone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Express other = (Express) obj;
		if (code != other.code)
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (eNumber == null) {
			if (other.eNumber != null)
				return false;
		} else if (!eNumber.equals(other.eNumber))
			return false;
		if (id != other.id)
			return false;
		if (inTime == null) {
			if (other.inTime != null)
				return false;
		} else if (!inTime.equals(other.inTime))
			return false;
		if (inputPhone == null) {
			if (other.inputPhone != null)
				return false;
		} else if (!inputPhone.equals(other.inputPhone))
			return false;
		if (outTime == null) {
			if (other.outTime != null)
				return false;
		} else if (!outTime.equals(other.outTime))
			return false;
		if (status != other.status)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPhone == null) {
			if (other.userPhone != null)
				return false;
		} else if (!userPhone.equals(other.userPhone))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Express [id=" + id + ", eNumber=" + eNumber + ", company=" + company + ", userName=" + userName
				+ ", userPhone=" + userPhone + ", status=" + status + ", inTime=" + inTime + ", outTime=" + outTime
				+ ", inputPhone=" + inputPhone + ", code=" + code + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String geteNumber() {
		return eNumber;
	}
	public void seteNumber(String eNumber) {
		this.eNumber = eNumber;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Timestamp getInTime() {
		return inTime;
	}
	public void setInTime(Timestamp inTime) {
		this.inTime = inTime;
	}
	public Timestamp getOutTime() {
		return outTime;
	}
	public void setOutTime(Timestamp outTime) {
		this.outTime = outTime;
	}
	public String getInputPhone() {
		return inputPhone;
	}
	public void setInputPhone(String inputPhone) {
		this.inputPhone = inputPhone;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Express(int id, String eNumber, String company, String userName, String userPhone, int status,
			Timestamp inTime, Timestamp outTime, String inputPhone, int code) {
		super();
		this.id = id;
		this.eNumber = eNumber;
		this.company = company;
		this.userName = userName;
		this.userPhone = userPhone;
		this.status = status;
		this.inTime = inTime;
		this.outTime = outTime;
		this.inputPhone = inputPhone;
		this.code = code;
	}
	public Express() {
		super();
		// TODO Auto-generated constructor stub
	}
}
