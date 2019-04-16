package jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class reminder_id implements Serializable {
	private term_acad_id taid;

	public reminder_id(String t_name, int a_year) {
		this.taid = new term_acad_id(t_name, a_year);
	}

	public term_acad_id getTaid() {
		return taid;
	}

	public reminder_id() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		reminder_id other = (reminder_id) obj;
		if (taid == null) {
			if (other.taid != null)
				return false;
		} else if (!taid.equals(other.taid))
			return false;
		return true;
	}
	
	

}
