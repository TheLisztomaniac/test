package jpa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class student {
	@Id
	private int std_id;
	private String std_name; 
	private int batch_name;
	private int p_id;
	private String gender;
	@Temporal(TemporalType.DATE)
	private Date birth_date;
	private String contact_number;
	private double height;
	private String id_mark;
	private String blood_grp;
	private String address;
	
	public int getStd_id() {
		return std_id;
	}
	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}
	public String getStd_name() {
		return std_name;
	}
	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	public int getBatch_name() {
		return batch_name;
	}
	public void setBatch_name(int batch_name) {
		this.batch_name = batch_name;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getId_mark() {
		return id_mark;
	}
	public void setId_mark(String id_mark) {
		this.id_mark = id_mark;
	}
	public String getBlood_grp() {
		return blood_grp;
	}
	public void setBlood_grp(String blood_grp) {
		this.blood_grp = blood_grp;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
