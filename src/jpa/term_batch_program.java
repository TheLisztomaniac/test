package jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class term_batch_program {
	
	@EmbeddedId
	private term_batch_program_id tbpid;
	private int semester;
	public term_batch_program_id getTbpid() {
		return tbpid;
	}
	public void setTbpid(term_batch_program_id tbpid) {
		this.tbpid = tbpid;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
}
