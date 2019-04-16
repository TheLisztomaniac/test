package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class offer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int offer_id;
	private String c_code;
	private int f_id;
	private String t_name;
	private int a_year;

	public int getOffer_id() {
		return offer_id;
	}

	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
	}

	public String getC_code() {
		return c_code;
	}

	public void setC_code(String c_code) {
		this.c_code = c_code;
	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public int getA_year() {
		return a_year;
	}

	public void setA_year(int a_year) {
		this.a_year = a_year;
	}

	@Override
	public String toString() {
		return "offer [offer_id=" + offer_id + ", c_code=" + c_code + ", f_id=" + f_id + ", t_name=" + t_name
				+ ", a_year=" + a_year + "]";
	}
	
}
