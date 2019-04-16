package jpa;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class reminder {
	@EmbeddedId
	private reminder_id rid;
	@Temporal(TemporalType.DATE)
	private Date open_registration;
	@Temporal(TemporalType.DATE)
	private Date close_registration;
	@Temporal(TemporalType.DATE)
	private Date reminder_date;
	@Temporal(TemporalType.DATE)
	private Date open_adddrop;
	@Temporal(TemporalType.DATE)
	private Date close_adddrop;

	
	
	public Date getOpen_adddrop() {
		return open_adddrop;
	}

	public void setOpen_adddrop(Date open_adddrop) {
		this.open_adddrop = open_adddrop;
	}

	public Date getClose_adddrop() {
		return close_adddrop;
	}

	public void setClose_adddrop(Date close_adddrop) {
		this.close_adddrop = close_adddrop;
	}

	public reminder_id getRid() {
		return rid;
	}

	public void setRid(reminder_id rid) {
		this.rid = rid;
	}

	public Date getOpen_registration() {
		return open_registration;
	}

	public void setOpen_registration(Date open_registration) {
		this.open_registration = open_registration;
	}

	public Date getClose_registration() {
		return close_registration;
	}

	public void setClose_registration(Date close_registration) {
		this.close_registration = close_registration;
	}

	public Date getReminder_date() {
		return reminder_date;
	}

	public void setReminder_date(Date reminder_date) {
		this.reminder_date = reminder_date;
	}
	
	
}
