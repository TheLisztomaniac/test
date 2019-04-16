package jpa;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class term_batch_program_id implements Serializable{
	
	private term_acad_id taid;
	private program_batch_id pbid;
	public term_batch_program_id() {
		
	}
	public term_batch_program_id(String t_name,int a_year,int p_id,int batch_name)
	{
		this.taid = new term_acad_id(t_name,a_year);
		this.pbid = new program_batch_id(p_id,batch_name);
	}

	public term_acad_id getTaid() {
		return taid;
	}

	public program_batch_id getPbid() {
		return pbid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		term_batch_program_id other = (term_batch_program_id) obj;
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
