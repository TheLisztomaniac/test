package jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class program_batch {

	@EmbeddedId
	private program_batch_id pbid;

	public program_batch_id getPbid() {
		return pbid;
	}

	public void setPbid(program_batch_id pbid) {
		this.pbid = pbid;
	}
}
