package jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class course {
	@Id
	private String c_code;
	private String course_name;
	private String url;
	private String c_level;
	private String description;
	private String descipline;
	private String category;
	private int L;
	private int T;
	private int P;
	private double C;
	private String accessment_type;
	
	public String getC_code() {
		return c_code;
	}
	public void setC_code(String c_code) {
		this.c_code = c_code;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getC_level() {
		return c_level;
	}
	public void setC_level(String c_level) {
		this.c_level = c_level;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescipline() {
		return descipline;
	}
	public void setDescipline(String descipline) {
		this.descipline = descipline;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getL() {
		return L;
	}
	public void setL(int i) {
		L = i;
	}
	public int getT() {
		return T;
	}
	public void setT(int t) {
		T = t;
	}
	public int getP() {
		return P;
	}
	public void setP(int p) {
		P = p;
	}
	public double getC() {
		return C;
	}
	public void setC(double c) {
		C = c;
	}
	public String getAccessment_type() {
		return accessment_type;
	}
	public void setAccessment_type(String accessment_type) {
		this.accessment_type = accessment_type;
	}
	@Override
	public String toString() {
		return "course [c_code=" + c_code + ", course_name=" + course_name + ", url=" + url + ", c_level=" + c_level
				+ ", description=" + description + ", descipline=" + descipline + ", category=" + category + ", L=" + L
				+ ", T=" + T + ", P=" + P + ", C=" + C + ", accessment_type=" + accessment_type + "]";
	}
	
}
