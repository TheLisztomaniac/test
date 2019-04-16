package jpa;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class paid_fees {
	@EmbeddedId
	private paid_fees_id pfid;
	private String payment_mode;
	@Temporal(TemporalType.DATE)
	private Date pf_date;
	private String bank;
	private String fee_recipt;

	public paid_fees_id getPfid() {
		return pfid;
	}

	public void setPfid(paid_fees_id pfid) {
		this.pfid = pfid;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public Date getPf_date() {
		return pf_date;
	}

	public void setPf_date(Date pf_date) {
		this.pf_date = pf_date;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getFee_receipt() {
		return fee_recipt;
	}

	public void setFee_receipt(String fee_receipt) {
		this.fee_recipt = fee_receipt;
	}

}
