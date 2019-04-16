package jpa;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class paid_fees_id implements Serializable {

	private term_acad_id taid;
	private int std_id;
	private int f_id;

	public paid_fees_id(int std_id, int f_id, String t_name, int a_year) {
		this.taid = new term_acad_id(t_name, a_year);
		this.std_id = std_id;
		this.f_id = f_id;
	}

	public paid_fees_id() {
		
	}

	public term_acad_id getTaid() {
		return taid;
	}

	public int getStd_id() {
		return std_id;
	}

	public int getF_id() {
		return f_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + f_id;
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
		paid_fees_id other = (paid_fees_id) obj;
		if (f_id != other.f_id)
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
