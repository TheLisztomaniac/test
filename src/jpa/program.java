package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class program {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int p_id;
	private String p_name;
	private int duration;
	private String duration_unit;
	private String p_code;
	private String discription;
	private int coordinator_id;

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDuration_unit() {
		return duration_unit;
	}

	public void setDuration_unit(String duration_unit) {
		this.duration_unit = duration_unit;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public int getCoordinator_id() {
		return coordinator_id;
	}

	public void setCoordinator_id(int coordinator_id) {
		this.coordinator_id = coordinator_id;
	}

	@Override
	public String toString() {
		return "program [p_id=" + p_id + ", p_name=" + p_name + ", duration=" + duration + ", duration_unit="
				+ duration_unit + ", p_code=" + p_code + ", discription=" + discription + ", coordinator_id="
				+ coordinator_id + "]";
	}
	
	

}
