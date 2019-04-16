package jpa;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class batch_program_fee_id implements Serializable {
	private program_batch_id pbid;
	private term_acad_id taid;
	private int f_id;

	public batch_program_fee_id(int p_id, int batch_name, String t_name, int a_year, int f_id) {
		this.pbid = new program_batch_id(p_id, batch_name);
		this.taid = new term_acad_id(t_name, a_year);
		this.f_id = f_id;
	}
	
	public batch_program_fee_id() {
		
	}

	public program_batch_id getPbid() {
		return pbid;
	}

	public term_acad_id getTaid() {
		return taid;
	}

	public int getF_id() {
		return f_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + f_id;
		result = prime * result + ((pbid == null) ? 0 : pbid.hashCode());
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
		batch_program_fee_id other = (batch_program_fee_id) obj;
		if (f_id != other.f_id)
			return false;
		if (pbid == null) {
			if (other.pbid != null)
				return false;
		} else if (!pbid.equals(other.pbid))
			return false;
		if (taid == null) {
			if (other.taid != null)
				return false;
		} else if (!taid.equals(other.taid))
			return false;
		return true;
	}

}
