package jpa;
import java.util.Date;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class student_registration {
	
	@EmbeddedId
	private student_registration_id srid;
	private boolean approval_status;
	private String grade;
	private String remark;
	@Temporal(TemporalType.DATE)
	private Date registration_date;
	
	public Date getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}
	public student_registration_id getSrid() {
		return srid;
	}
	public void setSrid(student_registration_id srid) {
		this.srid = srid;
	}
	public boolean isApproval_status() {
		return approval_status;
	}
	public void setApproval_status(boolean approval_status) {
		this.approval_status = approval_status;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
