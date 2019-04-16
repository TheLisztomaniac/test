package jpa;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class fee_master {
	@Id
	private int fee_id;
	private String fee_name;
	private String details;
	private String f_type;
	private String f_group;
	private int p_id;
	private String applicabilities;

	public int getFee_id() {
		return fee_id;
	}

	public void setFee_id(int fee_id) {
		this.fee_id = fee_id;
	}

	public String getFee_name() {
		return fee_name;
	}

	public void setFee_name(String fee_name) {
		this.fee_name = fee_name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getF_type() {
		return f_type;
	}

	public void setF_type(String f_type) {
		this.f_type = f_type;
	}

	public String getF_group() {
		return f_group;
	}

	public void setF_group(String f_group) {
		this.f_group = f_group;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getApplicabilities() {
		return applicabilities;
	}

	public void setApplicabilities(String applicabilities) {
		this.applicabilities = applicabilities;
	}

}
