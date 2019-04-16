package jpa;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class term {
	@EmbeddedId
	private term_acad_id taid;
	@Temporal(TemporalType.DATE)
	private Date start_date;
	@Temporal(TemporalType.DATE)
	private Date end_date;
	private String semester;
	
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public term_acad_id getTaid() {
		return taid;
	}
	public void setTaid(term_acad_id taid) {
		this.taid = taid;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	@Override
	public String toString() {
		return "term [taid=" + taid.toString() + ", start_date=" + start_date + ", end_date=" + end_date + "]";
	}

}
