package actions;
import jpa.*;
import java.util.*;
import services.*;

import com.opensymphony.xwork2.ActionSupport;

public class ActionTerm extends ActionSupport{
	
	private List<term> TermList;
	private List<String> SpecifiedTermList; 
	private term t;
	private int year;
	private term_acad_id taid;
	private List<acad_year> AcadYearList;
	
	public List<acad_year> getAcadYearList() {
		return AcadYearList;
	}
	public void setAcadYearList(List<acad_year> acadYearList) {
		AcadYearList = acadYearList;
	}
	public void setSpecifiedTermList(List<String> specifiedTermList) {
		SpecifiedTermList = specifiedTermList;
	}
	public term getT() {
		return t;
	}
	public void setT(term t) {
		this.t = t;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public List<term> getTermList() {
		return TermList;
	}
	public void setTermList(List<term> termList) {
		TermList = termList;
	}
	public List<String> getSpecifiedTermList() {
		return SpecifiedTermList;
	}
	public void setSpecifiedTermList() {
		List<String> temp = new ArrayList<String>();
		temp.add("Autumn");
		temp.add("Winter");
		temp.add("Summer");
		SpecifiedTermList = temp;
	}
	public term_acad_id getTaid() {
		return taid;
	}
	public void setTaid(term_acad_id taid) {
		this.taid = taid;
	}
	public String getYearTerm()
	{
		
		return "success";
	}
	public String getTerm()
	{
		setTermList(new ServiceTerm().getTermByAcadYear(getYear()));
		return "success";
	}
	public String getTermYear()
	{
		setAcadYearList(new ServiceYear().getYear());
		return "success";
	}
	public String editTerm()
	{
		new ServiceTerm().editTerm(taid,t);
		return "done";
	}
	public String editTermForm()
	{
		setT(new ServiceTerm().getTermByTaid(taid));
		setSpecifiedTermList();
		return "success";
	}
	public String addTerm()
	{
		new ServiceTerm().addTerm(getT());
		return "done";
	}
	public String addTermForm()
	{
		setSpecifiedTermList();
		return "success";
	}
	
	public String deleteTerm()
	{
		System.out.println(taid);
		new ServiceTerm().deleteTerm(taid);
		return "done";
	}

}
