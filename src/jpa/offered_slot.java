package jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class offered_slot {
	@EmbeddedId
	private offered_slot_id osid;
	private boolean base_or_not;
	private String c_type;

	public offered_slot_id getOsid() {
		return osid;
	}

	public void setOsid(offered_slot_id osid) {
		this.osid = osid;
	}

	public boolean isBase_or_not() {
		return base_or_not;
	}

	public void setBase_or_not(boolean base_or_not) {
		this.base_or_not = base_or_not;
	}

	public String getC_type() {
		return c_type;
	}

	public void setC_type(String c_type) {
		this.c_type = c_type;
	}
}
