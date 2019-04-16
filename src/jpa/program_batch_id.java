package jpa;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class program_batch_id implements Serializable {

	private int p_id;
	private int batch_name;

	public program_batch_id(int p_id, int batch_name) {
		this.p_id = p_id;
		this.batch_name = batch_name;
	}

	public program_batch_id() {
		
	}

	public int getP_id() {
		return p_id;
	}

	public int getBatch_name() {
		return batch_name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batch_name;
		result = prime * result + p_id;
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
		program_batch_id other = (program_batch_id) obj;
		if (batch_name != other.batch_name)
			return false;
		if (p_id != other.p_id)
			return false;
		return true;
	}
}
