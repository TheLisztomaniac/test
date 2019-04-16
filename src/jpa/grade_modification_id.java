package jpa;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class grade_modification_id implements Serializable {
	private student_registration_id srid;

	public grade_modification_id(int std_id, String t_name, int a_year, String c_code) {
		this.srid = new student_registration_id(t_name, a_year, std_id, c_code);
	}

	public student_registration_id getSrid() {
		return srid;
	}

	public grade_modification_id() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((srid == null) ? 0 : srid.hashCode());
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
		grade_modification_id other = (grade_modification_id) obj;
		if (srid == null) {
			if (other.srid != null)
				return false;
		} else if (!srid.equals(other.srid))
			return false;
		return true;
	}

}
