package jpa;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ip_address {
	@Id
	private String serial_no;
	private int emp_id;
	private String ip_address;
	private boolean active_status;
	private LocalDateTime access_time_from;
	private LocalDateTime access_time_to;
	private String discription;

	public String getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	public boolean isActive_status() {
		return active_status;
	}

	public void setActive_status(boolean active_status) {
		this.active_status = active_status;
	}

	public LocalDateTime getAccess_time_from() {
		return access_time_from;
	}

	public void setAccess_time_from(LocalDateTime access_time_from) {
		this.access_time_from = access_time_from;
	}

	public LocalDateTime getAccess_time_to() {
		return access_time_to;
	}

	public void setAccess_time_to(LocalDateTime access_time_to) {
		this.access_time_to = access_time_to;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

}
