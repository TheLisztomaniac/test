package jpa;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class term_acad_id implements Serializable{
	
	private String t_name;
	private int a_year;
	
	public term_acad_id(String t_name,int a_year)
	{
		this.t_name = t_name;
		this.a_year = a_year;
	}

	public term_acad_id() {
		
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public void setA_year(int a_year) {
		this.a_year = a_year;
	}

	public String getT_name() {
		return t_name;
	}

	public int getA_year() {
		return a_year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a_year;
		result = prime * result + ((t_name == null) ? 0 : t_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		term_acad_id other = (term_acad_id) obj;
		if (a_year != other.a_year)
			return false;
		if (t_name == null) {
			if (other.t_name != null)
				return false;
		} else if (!t_name.equals(other.t_name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "term_acad_id [t_name=" + t_name + ", a_year=" + a_year + "]";
	}
}
