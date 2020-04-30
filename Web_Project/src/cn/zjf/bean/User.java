package cn.zjf.bean;

public class User {
	private int id;
	private String uName;
	private String uPhone;
	private String uPass;
	private String uSex;
	private String active;
	public User() {
		super();
	}
	public User(String uName, String uPhone, String uPass, String uSex) {
		super();
		this.uName = uName;
		this.uPhone = uPhone;
		this.uPass = uPass;
		this.uSex = uSex;
	}
	public User(int id, String uName, String uPhone, String uPass, String uSex, String active) {
		super();
		this.id = id;
		this.uName = uName;
		this.uPhone = uPhone;
		this.uPass = uPass;
		this.uSex = uSex;
		this.active = active;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	public String getuPass() {
		return uPass;
	}
	public void setuPass(String uPass) {
		this.uPass = uPass;
	}
	public String getuSex() {
		return uSex;
	}
	public void setuSex(String uSex) {
		this.uSex = uSex;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + id;
		result = prime * result + ((uName == null) ? 0 : uName.hashCode());
		result = prime * result + ((uPass == null) ? 0 : uPass.hashCode());
		result = prime * result + ((uPhone == null) ? 0 : uPhone.hashCode());
		result = prime * result + ((uSex == null) ? 0 : uSex.hashCode());
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
		User other = (User) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (id != other.id)
			return false;
		if (uName == null) {
			if (other.uName != null)
				return false;
		} else if (!uName.equals(other.uName))
			return false;
		if (uPass == null) {
			if (other.uPass != null)
				return false;
		} else if (!uPass.equals(other.uPass))
			return false;
		if (uPhone == null) {
			if (other.uPhone != null)
				return false;
		} else if (!uPhone.equals(other.uPhone))
			return false;
		if (uSex == null) {
			if (other.uSex != null)
				return false;
		} else if (!uSex.equals(other.uSex))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", uName=" + uName + ", uPhone=" + uPhone + ", uPass=" + uPass + ", uSex=" + uSex
				+ ", active=" + active + "]";
	}
	
	
}
