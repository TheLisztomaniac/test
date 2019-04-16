package jpa;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class student_registration_id implements Serializable{
	private term_acad_id taid;
	private int std_id;
	private String c_code;
	
	public student_registration_id(String t_name,int a_year,int std_id,String c_code)
	{
		this.taid = new term_acad_id(t_name, a_year);
		this.std_id = std_id;
		this.c_code = c_code;
	}

	public student_registration_id() {
		
	}

	public term_acad_id getTaid() {
		return taid;
	}

	public int getStd_id() {
		return std_id;
	}

	public String getC_code() {
		return c_code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c_code == null) ? 0 : c_code.hashCode());
		result = prime * result + std_id;
		result = prime * result + ((taid == null) ? 0 : taid.hashCode());
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
		student_registration_id other = (student_registration_id) obj;
		if (c_code == null) {
			if (other.c_code != null)
				return false;
		} else if (!c_code.equals(other.c_code))
			return false;
		if (std_id != other.std_id)
			return false;
		if (taid == null) {
			if (other.taid != null)
				return false;
		} else if (!taid.equals(other.taid))
			return false;
		return true;
	}
}
