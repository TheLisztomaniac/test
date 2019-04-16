package jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class faculty {

	@Id
	private int f_id;
	private String f_name;

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

}
