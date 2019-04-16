package jpa;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class course_prerequisite_id implements Serializable{
	
	private String c_code;
	private String prerequisite_c_code;
	
	public course_prerequisite_id(String c_code,String prerequisite_c_code)
	{
		this.c_code = c_code;
		this.prerequisite_c_code = prerequisite_c_code;
	}
	
	public course_prerequisite_id()
	{
	}

	public String getC_code() {
		return c_code;
	}

	public String getPrerequisite_c_code() {
		return prerequisite_c_code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c_code == null) ? 0 : c_code.hashCode());
		result = prime * result + ((prerequisite_c_code == null) ? 0 : prerequisite_c_code.hashCode());
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
		course_prerequisite_id other = (course_prerequisite_id) obj;
		if (c_code == null) {
			if (other.c_code != null)
				return false;
		} else if (!c_code.equals(other.c_code))
			return false;
		if (prerequisite_c_code == null) {
			if (other.prerequisite_c_code != null)
				return false;
		} else if (!prerequisite_c_code.equals(other.prerequisite_c_code))
			return false;
		return true;
	}
	
	
}
