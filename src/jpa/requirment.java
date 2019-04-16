package jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class requirment {

	@EmbeddedId
	private program_batch_id pbid;

	private double s1_min_credit;
	private double s1_max_credit;
	private int s1_min_course;
	private int s1_max_course;
	private double s2_min_credit;
	private double s2_max_credit;
	private int s2_min_course;
	private int s2_max_course;
	private double s3_min_credit;
	private double s3_max_credit;
	private int s3_min_course;
	private int s3_max_course;
	private double s4_min_credit;
	private double s4_max_credit;
	private int s4_min_course;
	private int s4_max_course;
	private double s5_min_credit;
	private double s5_max_credit;
	private int s5_min_course;
	private int s5_max_course;
	private double s6_min_credit;
	private double s6_max_credit;
	private int s6_min_course;
	private int s6_max_course;
	private double s7_min_credit;
	private double s7_max_credit;
	private int s7_min_course;
	private int s7_max_course;
	private double s8_min_credit;
	private double s8_max_credit;
	private int s8_min_course;
	private int s8_max_course;
	private double total_min_credit;
	private int min_technical_elective;
	private int min_other_elective;
	private int min_science_elective;
	private int min_group_elective;

	

	public int getMin_technical_elective() {
		return min_technical_elective;
	}

	public void setMin_technical_elective(int min_technical_elective) {
		this.min_technical_elective = min_technical_elective;
	}

	public int getMin_other_elective() {
		return min_other_elective;
	}

	public void setMin_other_elective(int min_other_elective) {
		this.min_other_elective = min_other_elective;
	}

	public int getMin_science_elective() {
		return min_science_elective;
	}

	public void setMin_science_elective(int min_science_elective) {
		this.min_science_elective = min_science_elective;
	}

	public int getMin_group_elective() {
		return min_group_elective;
	}

	public void setMin_group_elective(int min_group_elective) {
		this.min_group_elective = min_group_elective;
	}

	public program_batch_id getPbid() {
		return pbid;
	}

	public void setPbid(program_batch_id pbid) {
		this.pbid = pbid;
	}

	public double getS1_min_credit() {
		return s1_min_credit;
	}

	public void setS1_min_credit(double s1_min_credit) {
		this.s1_min_credit = s1_min_credit;
	}

	public double getS1_max_credit() {
		return s1_max_credit;
	}

	public void setS1_max_credit(double s1_max_credit) {
		this.s1_max_credit = s1_max_credit;
	}

	public int getS1_min_course() {
		return s1_min_course;
	}

	public void setS1_min_course(int s1_min_course) {
		this.s1_min_course = s1_min_course;
	}

	public int getS1_max_course() {
		return s1_max_course;
	}

	public void setS1_max_course(int s1_max_course) {
		this.s1_max_course = s1_max_course;
	}

	public double getS2_min_credit() {
		return s2_min_credit;
	}

	public void setS2_min_credit(double s2_min_credit) {
		this.s2_min_credit = s2_min_credit;
	}

	public double getS2_max_credit() {
		return s2_max_credit;
	}

	public void setS2_max_credit(double s2_max_credit) {
		this.s2_max_credit = s2_max_credit;
	}

	public int getS2_min_course() {
		return s2_min_course;
	}

	public void setS2_min_course(int s2_min_course) {
		this.s2_min_course = s2_min_course;
	}

	public int getS2_max_course() {
		return s2_max_course;
	}

	public void setS2_max_course(int s2_max_course) {
		this.s2_max_course = s2_max_course;
	}

	public double getS3_min_credit() {
		return s3_min_credit;
	}

	public void setS3_min_credit(double s3_min_credit) {
		this.s3_min_credit = s3_min_credit;
	}

	public double getS3_max_credit() {
		return s3_max_credit;
	}

	public void setS3_max_credit(double s3_max_credit) {
		this.s3_max_credit = s3_max_credit;
	}

	public int getS3_min_course() {
		return s3_min_course;
	}

	public void setS3_min_course(int s3_min_course) {
		this.s3_min_course = s3_min_course;
	}

	public int getS3_max_course() {
		return s3_max_course;
	}

	public void setS3_max_course(int s3_max_course) {
		this.s3_max_course = s3_max_course;
	}

	public double getS4_min_credit() {
		return s4_min_credit;
	}

	public void setS4_min_credit(double s4_min_credit) {
		this.s4_min_credit = s4_min_credit;
	}

	public double getS4_max_credit() {
		return s4_max_credit;
	}

	public void setS4_max_credit(double s4_max_credit) {
		this.s4_max_credit = s4_max_credit;
	}

	public int getS4_min_course() {
		return s4_min_course;
	}

	public void setS4_min_course(int s4_min_course) {
		this.s4_min_course = s4_min_course;
	}

	public int getS4_max_course() {
		return s4_max_course;
	}

	public void setS4_max_course(int s4_max_course) {
		this.s4_max_course = s4_max_course;
	}

	public double getS5_min_credit() {
		return s5_min_credit;
	}

	public void setS5_min_credit(double s5_min_credit) {
		this.s5_min_credit = s5_min_credit;
	}

	public double getS5_max_credit() {
		return s5_max_credit;
	}

	public void setS5_max_credit(double s5_max_credit) {
		this.s5_max_credit = s5_max_credit;
	}

	public int getS5_min_course() {
		return s5_min_course;
	}

	public void setS5_min_course(int s5_min_course) {
		this.s5_min_course = s5_min_course;
	}

	public int getS5_max_course() {
		return s5_max_course;
	}

	public void setS5_max_course(int s5_max_course) {
		this.s5_max_course = s5_max_course;
	}

	public double getS6_min_credit() {
		return s6_min_credit;
	}

	public void setS6_min_credit(double s6_min_credit) {
		this.s6_min_credit = s6_min_credit;
	}

	public double getS6_max_credit() {
		return s6_max_credit;
	}

	public void setS6_max_credit(double s6_max_credit) {
		this.s6_max_credit = s6_max_credit;
	}

	public int getS6_min_course() {
		return s6_min_course;
	}

	public void setS6_min_course(int s6_min_course) {
		this.s6_min_course = s6_min_course;
	}

	public int getS6_max_course() {
		return s6_max_course;
	}

	public void setS6_max_course(int s6_max_course) {
		this.s6_max_course = s6_max_course;
	}

	public double getS7_min_credit() {
		return s7_min_credit;
	}

	public void setS7_min_credit(double s7_min_credit) {
		this.s7_min_credit = s7_min_credit;
	}

	public double getS7_max_credit() {
		return s7_max_credit;
	}

	public void setS7_max_credit(double s7_max_credit) {
		this.s7_max_credit = s7_max_credit;
	}

	public int getS7_min_course() {
		return s7_min_course;
	}

	public void setS7_min_course(int s7_min_course) {
		this.s7_min_course = s7_min_course;
	}

	public int getS7_max_course() {
		return s7_max_course;
	}

	public void setS7_max_course(int s7_max_course) {
		this.s7_max_course = s7_max_course;
	}

	public double getS8_min_credit() {
		return s8_min_credit;
	}

	public void setS8_min_credit(double s8_min_credit) {
		this.s8_min_credit = s8_min_credit;
	}

	public double getS8_max_credit() {
		return s8_max_credit;
	}

	public void setS8_max_credit(double s8_max_credit) {
		this.s8_max_credit = s8_max_credit;
	}

	public int getS8_min_course() {
		return s8_min_course;
	}

	public void setS8_min_course(int s8_min_course) {
		this.s8_min_course = s8_min_course;
	}

	public int getS8_max_course() {
		return s8_max_course;
	}

	public void setS8_max_course(int s8_max_course) {
		this.s8_max_course = s8_max_course;
	}

	public double getTotal_min_credit() {
		return total_min_credit;
	}

	public void setTotal_min_credit(double total_min_credit) {
		this.total_min_credit = total_min_credit;
	}

}
