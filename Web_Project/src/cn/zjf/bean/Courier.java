package cn.zjf.bean;

public class Courier {
	//快递员id
	private int id;
	//快递员姓名
	private String cName;
	//快递员手机号
	private String cPhone;
	//快递员身份证号
	private String cCard;
	//快递员密码
	private String pass;
	//快递员性别
	private String sex;
	//快递员是否激活
	private int active;
	public Courier() {
		super();
	}
	
	public Courier(String cName, String cPhone, String cCard, String pass, String sex) {
		super();
		this.cName = cName;
		this.cPhone = cPhone;
		this.cCard = cCard;
		this.pass = pass;
		this.sex = sex;
	}

	public Courier(int id, String cName, String cPhone, String cCard, String pass, String sex, int active) {
		super();
		this.id = id;
		this.cName = cName;
		this.cPhone = cPhone;
		this.cCard = cCard;
		this.pass = pass;
		this.sex = sex;
		this.active = active;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcPhone() {
		return cPhone;
	}
	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}
	public String getcCard() {
		return cCard;
	}
	public void setcCard(String cCard) {
		this.cCard = cCard;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Courier [id=" + id + ", cName=" + cName + ", cPhone=" + cPhone + ", cCard=" + cCard + ", pass=" + pass
				+ ", sex=" + sex + ", active=" + active + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + active;
		result = prime * result + ((cCard == null) ? 0 : cCard.hashCode());
		result = prime * result + ((cName == null) ? 0 : cName.hashCode());
		result = prime * result + ((cPhone == null) ? 0 : cPhone.hashCode());
		result = prime * result + id;
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
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
		Courier other = (Courier) obj;
		if (active != other.active)
			return false;
		if (cCard == null) {
			if (other.cCard != null)
				return false;
		} else if (!cCard.equals(other.cCard))
			return false;
		if (cName == null) {
			if (other.cName != null)
				return false;
		} else if (!cName.equals(other.cName))
			return false;
		if (cPhone == null) {
			if (other.cPhone != null)
				return false;
		} else if (!cPhone.equals(other.cPhone))
			return false;
		if (id != other.id)
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}
	
	
}
