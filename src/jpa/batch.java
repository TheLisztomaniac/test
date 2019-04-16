package jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class batch {

	@Id
	private program_batch_id pbid;
	private term_acad_id taid;
	private byte[] student_file;

	public program_batch_id getPbid() {
		return pbid;
	}

	public void setPbid(program_batch_id pbid) {
		this.pbid = pbid;
	}

	public byte[] getStudent_file() {
		return student_file;
	}

	public void setStudent_file(byte[] student_file) {
		this.student_file = student_file;
	}

	public term_acad_id getTaid() {
		return taid;
	}

	public void setTaid(term_acad_id taid) {
		this.taid = taid;
	}


}
