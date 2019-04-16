package jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class acad_year {
	
	@Id
	private int a_year;

	public int getA_year() {
		return a_year;
	}

	public void setA_year(int a_year) {
		this.a_year = a_year;
	}

	@Override
	public String toString() {
		return "acad_year [a_year=" + a_year + "]";
	}
	
}
