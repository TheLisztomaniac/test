package jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class batch_program_fee {
	@EmbeddedId
	private batch_program_fee_id bpfid;
	private double f_amount;

	public batch_program_fee_id getBpfid() {
		return bpfid;
	}

	public void setBpfid(batch_program_fee_id bpfid) {
		this.bpfid = bpfid;
	}

	public double getF_amount() {
		return f_amount;
	}

	public void setF_amount(double f_amount) {
		this.f_amount = f_amount;
	}

}
