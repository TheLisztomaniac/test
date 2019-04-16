package jpa;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class grade_modification {
	@EmbeddedId
	private grade_modification_id gmid;
	private String modifide_grade;
	@Temporal(TemporalType.DATE)
	private Date responder_date;
	private String remark;
	private boolean approved_by_deen;
	private boolean approved_by_registrar;

	public grade_modification_id getGmid() {
		return gmid;
	}

	public void setGmid(grade_modification_id gmid) {
		this.gmid = gmid;
	}

	public String getModifide_grade() {
		return modifide_grade;
	}

	public void setModifide_grade(String modifide_grade) {
		this.modifide_grade = modifide_grade;
	}

	public Date getResponder_date() {
		return responder_date;
	}

	public void setResponder_date(Date responder_date) {
		this.responder_date = responder_date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean isApproved_by_deen() {
		return approved_by_deen;
	}

	public void setApproved_by_deen(boolean approved_by_deen) {
		this.approved_by_deen = approved_by_deen;
	}

	public boolean isApproved_by_registrar() {
		return approved_by_registrar;
	}

	public void setApproved_by_registrar(boolean approved_by_registrar) {
		this.approved_by_registrar = approved_by_registrar;
	}
}
