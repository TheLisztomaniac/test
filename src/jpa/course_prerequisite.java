package jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class course_prerequisite {
	
	@EmbeddedId
	private course_prerequisite_id cpid;
	private double min_required_pointer;
	public course_prerequisite_id getCpid() {
		return cpid;
	}
	public void setCpid(course_prerequisite_id cpid) {
		this.cpid = cpid;
	}
	public double getMin_required_pointer() {
		return min_required_pointer;
	}
	public void setMin_required_pointer(double min_required_pointer) {
		this.min_required_pointer = min_required_pointer;
	}
	
}

