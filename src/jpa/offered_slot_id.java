package jpa;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class offered_slot_id implements Serializable {
	private program_batch_id pbid;
	private int offer_id;
	private int slot_no;

	public offered_slot_id(int p_id, int batch_name, int oi, int si) {
		this.pbid = new program_batch_id(p_id, batch_name);
		this.offer_id = oi;
		this.slot_no = si;
	}

	public offered_slot_id() {
		
	}

	public program_batch_id getPbid() {
		return pbid;
	}

	public int getOffer_id() {
		return offer_id;
	}

	public int getSlot_no() {
		return slot_no;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + offer_id;
		result = prime * result + ((pbid == null) ? 0 : pbid.hashCode());
		result = prime * result + slot_no;
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
		offered_slot_id other = (offered_slot_id) obj;
		if (offer_id != other.offer_id)
			return false;
		if (pbid == null) {
			if (other.pbid != null)
				return false;
		} else if (!pbid.equals(other.pbid))
			return false;
		if (slot_no != other.slot_no)
			return false;
		return true;
	}
}
