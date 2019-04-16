package jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class slot {
	@Id
	private int slot_no;
	private String slot_name;
	
	public int getSlot_no() {
		return slot_no;
	}
	public void setSlot_no(int slot_no) {
		this.slot_no = slot_no;
	}
	public String getSlot_name() {
		return slot_name;
	}
	public void setSlot_name(String slot_name) {
		this.slot_name = slot_name;
	}
	
	
}
